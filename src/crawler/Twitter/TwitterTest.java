package OOP.Twitter;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.JSONTokener;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.*;

import java.io.File;
import java.io.FileReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.FileWriter;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TwitterTest {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final JavascriptExecutor js;

    public TwitterTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        js = (JavascriptExecutor) driver;
    }
    public void login(String username, String password) throws InterruptedException {
        driver.get("https://twitter.com/i/flow/login");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("text"))).sendKeys(username);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']/ancestor::div[contains(@role, 'button')]"))).click();
        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
        passwordInput.sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-testid='LoginForm_Login_Button']"))).click();
    }
    public void searchTwitter(String query) throws InterruptedException {
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

    public void closeBrowser() {
        driver.quit();
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

    public static void main(String[] args) {
        TwitterTest test = new TwitterTest();
        try {
            test.login("dng2706", "Ducdung789");  // Thay đổi thông tin đăng nhập tùy theo nhu cầu
            test.searchTwitter("#NFT");

            JSONArray tweets = test.collectTweets();
            if (!tweets.isEmpty()) {
                test.saveTweetsToFile(tweets, "Twitter.json");
                System.out.println("Đã lưu " + tweets.length() + " tweet về chủ đề #NFT vào file Twitter.json");
            } else {
                System.out.println("Không tìm thấy tweet nào về chủ đề #NFT để lưu.");
            }
        } catch (InterruptedException e) {
            System.err.println("Đã xảy ra lỗi: " + e.getMessage());
            e.printStackTrace();
        } finally {
            test.closeBrowser();
        }
    }
}




