package OOP.Twitter;

import OOP.DataCrawler;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class TwitterCrawler implements DataCrawler {
    private final WebDriver driver;
    private JSONArray tweetArray;
    private final WebDriverWait wait;
    private final JavascriptExecutor js;

    public TwitterCrawler() {
        // Khởi tạo WebDriver
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.js = (JavascriptExecutor) driver;
        this.tweetArray = new JSONArray();
    }

    @Override
    public void fetchData() throws InterruptedException {
        this.login("dng2706", "Ducdung789");  // Thay đổi thông tin đăng nhập tùy theo nhu cầu
        this.searchTwitter("#NFT");
        this.tweetArray = this.collectTweets();
        // Logic để fetch dữ liệu từ Twitter
        // Ví dụ: login, searchTwitter, collectTweets...
    }
    public void login(String username, String password) {
        driver.get("https://twitter.com/i/flow/login");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("text"))).sendKeys(username);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']/ancestor::div[contains(@role, 'button')]"))).click();
        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
        passwordInput.sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-testid='LoginForm_Login_Button']"))).click();
    }
    public void searchTwitter(String query) {
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@aria-label='Search query']")));
        searchBox.sendKeys(query + Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article[@role='article']")));
    }
    private JSONArray collectTweets() throws InterruptedException {
        JSONArray tweetArray = new JSONArray();

        while (tweetArray.length() < 50) {
            List<WebElement> tweets = driver.findElements(By.xpath("//article[@role='article']"));
            for (WebElement tweet : tweets) {
                if (tweetArray.length() >= 50) break;
                JSONObject tweetObject = extractTweetInfo(tweet);
                tweetArray.put(tweetObject);
            }
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            Thread.sleep(2000); // Đợi nội dung tải
        }

        return tweetArray;
    }
    private JSONObject extractTweetInfo(WebElement tweet) {
        JSONObject tweetObject = new JSONObject();
        try {
            String username = tweet.findElement(By.xpath(".//div[contains(@data-testid,'User-Name')]//span")).getText();
            String userId = tweet.findElement(By.xpath(".//a[contains(@href,'/')]")).getAttribute("href").replace("https://twitter.com/", "");
            String timestamp = tweet.findElement(By.xpath(".//time")).getAttribute("datetime");
            String content = tweet.findElement(By.xpath(".//div[@data-testid='tweetText']")).getText();

            tweetObject.put("username", username);
            tweetObject.put("userId", userId);
            tweetObject.put("timestamp", timestamp);
            tweetObject.put("content", content);
            // Trích xuất URL của hình ảnh
            JSONArray images = new JSONArray();
            List<WebElement> imageElements = tweet.findElements(By.xpath(".//img[@alt='Image' and not(contains(@src,'profile_images'))]"));
            for (WebElement imgElement : imageElements) {
                String imgSrc = imgElement.getAttribute("src");
                images.put(imgSrc);
            }
            tweetObject.put("images", images); // Thêm URL hình ảnh vào tweetObject
            // Add more tweet information extraction as needed
        } catch (NoSuchElementException e) {
            System.out.println("Một số phần tử không tìm thấy trong tweet này.");
        }
        return tweetObject;
    }

    @Override
    public void processData() {
        // Xử lý dữ liệu đã fetch
    }

    @Override
    public void saveData(String filename) {
        this.saveTweetsToFile(this.tweetArray, filename);
    }
    public void saveTweetsToFile(JSONArray newTweets, String filename) {
        JSONArray existingTweets = readExistingTweets(filename);
        Set<String> existingTweetDetails = new HashSet<>();

        // Tạo Set của các chi tiết tweet hiện có để kiểm tra trùng lặp
        for (int i = 0; i < existingTweets.length(); i++) {
            JSONObject tweet = existingTweets.getJSONObject(i);
            String detail = tweet.optString("username", "") + "|" +
                    tweet.optString("userId", "") + "|" +
                    tweet.optString("timestamp", "") + "|" +
                    tweet.optString("content", "");
            existingTweetDetails.add(detail);
        }

        // Kiểm tra và thêm tweet mới nếu không trùng lặp
        for (int i = 0; i < newTweets.length(); i++) {
            JSONObject tweet = newTweets.getJSONObject(i);
            String detail = tweet.optString("username", "") + "|" +
                    tweet.optString("userId", "") + "|" +
                    tweet.optString("timestamp", "") + "|" +
                    tweet.optString("content", "");
            if (!existingTweetDetails.contains(detail)) {
                existingTweets.put(tweet);
            }
        }

        // Ghi dữ liệu vào file
        try (FileWriter file = new FileWriter(filename, false)) {  // false để ghi đè file
            file.write(existingTweets.toString(4));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private JSONArray readExistingTweets(String filename) {
        File file = new File(filename);
        JSONArray existingTweets = new JSONArray();

        if (file.exists()) {
            try (FileReader reader = new FileReader(file)) {
                JSONTokener tokener = new JSONTokener(reader);
                existingTweets = new JSONArray(tokener);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return existingTweets;
    }
    public void closeBrowser() {
        driver.quit();
    }

    public static void main(String[] args) {
        TwitterCrawler crawler = new TwitterCrawler();
        try {
            crawler.fetchData();    // Thu thập dữ liệu từ Twitter
            crawler.processData();  // Xử lý dữ liệu (nếu cần)
            crawler.saveData("Twitter.json");  // Lưu dữ liệu vào file
            System.out.println("Thu thập và lưu dữ liệu thành công.");
        } catch (InterruptedException e) {
            System.err.println("Đã xảy ra lỗi: " + e.getMessage());
            e.printStackTrace();
        } finally {
            crawler.closeBrowser();  // Đóng trình duyệt
        }
    }
}