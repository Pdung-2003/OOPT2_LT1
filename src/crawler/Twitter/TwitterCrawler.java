package OOP.Twitter;

import OOP.DataCrawler;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.JSONArray;

import org.json.JSONTokener;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

 class TweetInfo {
    private final String username;
    private String userId;
    private String timestamp;
    private String content;
    private List<String> images;

    public TweetInfo(String username, String userId, String timestamp, String content, List<String> images) {
        this.username = username;
        this.userId = userId;
        this.timestamp = timestamp;
        this.content = content;
        this.images = images;
    }

    // Add getters and setters here if necessary
}
    public class TwitterCrawler implements DataCrawler {
        private final WebDriver driver;
        private final WebDriverWait wait;
        private final JavascriptExecutor js;
        private List<TweetInfo> tweetInfoList;

        public TwitterCrawler() {
            WebDriverManager.chromedriver().setup();
            this.driver = new ChromeDriver();
            this.driver.manage().window().maximize();
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            this.js = (JavascriptExecutor) driver;
            this.tweetInfoList = new ArrayList<>();
        }

    @Override
    public void fetchData() throws InterruptedException {
        this.login("dng2706", "Ducdung789");  // Use actual credentials
        this.searchTwitter("#NFT");
        this.tweetInfoList = this.collectTweets();
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
    private List<TweetInfo> collectTweets() throws InterruptedException {
        List<TweetInfo> tweetInfoList = new ArrayList<>();

        while (tweetInfoList.size() < 50) {
            List<WebElement> tweets = driver.findElements(By.xpath("//article[@role='article']"));
            for (WebElement tweet : tweets) {
                if (tweetInfoList.size() >= 50) break;
                TweetInfo tweetInfo = extractTweetInfo(tweet);
                if (tweetInfo != null) {
                    tweetInfoList.add(tweetInfo);
                }
            }
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            Thread.sleep(2000); // Wait for content to load
        }

        return tweetInfoList;
    }
    private TweetInfo extractTweetInfo(WebElement tweet) {
        try {
            String username = tweet.findElement(By.xpath(".//div[contains(@data-testid,'User-Name')]//span")).getText();
            String userId = tweet.findElement(By.xpath(".//a[contains(@href,'/')]")).getAttribute("href").replace("https://twitter.com/", "");
            String timestamp = tweet.findElement(By.xpath(".//time")).getAttribute("datetime");
            String content = tweet.findElement(By.xpath(".//div[@data-testid='tweetText']")).getText();

            List<String> images = new ArrayList<>();
            List<WebElement> imageElements = tweet.findElements(By.xpath(".//img[@alt='Image' and not(contains(@src,'profile_images'))]"));
            for (WebElement imgElement : imageElements) {
                images.add(imgElement.getAttribute("src"));
            }

            return new TweetInfo(username, userId, timestamp, content, images);
        } catch (NoSuchElementException e) {
            System.out.println("Some elements were not found in this tweet.");
            return null; // Or handle the exception as needed
        }
    }


    @Override
    public void processData() {
        // Xử lý dữ liệu đã fetch
    }

    @Override
    public void saveData(String filename) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(this.tweetInfoList);

        try (FileWriter file = new FileWriter(filename)) {
            file.write(json);
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
        } catch (InterruptedException | IOException e) {
            System.err.println("Đã xảy ra lỗi: " + e.getMessage());
            e.printStackTrace();
        } finally {
            crawler.closeBrowser();  // Đóng trình duyệt
        }
    }
}