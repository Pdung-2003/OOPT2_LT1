package OOP.TodayNFTNewsCrawler;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

class CollectionInfo {
    private String title;
    private String imageUrl;
    private String author;
    private String date;
    private String tag;
    private String content;

    public CollectionInfo(String title, String imageUrl, String author, String date, String tag, String content) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.author = author;
        this.date = date;
        this.tag = tag;
        this.content = content;
    }
}

public class TodayNTFCrawler {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "chromedriver_win32 (1) - Copy\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        List<String> postUrls = new ArrayList<>();

        //n số page cần crawl
        int n=1;
        for (int i=1;i<=n ;i++)
        {
            String url = "https://www.todaynftnews.com/nft-news/page/"+i+"/";
            driver.get(url);

            try {
                Thread.sleep(5000);  // Chờ trang web tải
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Tìm thẻ button có class "pum-close"
            WebElement closeButton = driver.findElement(By.cssSelector("button.pum-close"));
            // Click vào thẻ button
            closeButton.click();
            // Cuộn đến cuối trang để tải thêm nếu có
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            // Chờ đợi cho đến khi tải thêm dữ liệu (nếu có)
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("w-loading")));

            // Tìm tất cả các thẻ a trong class "latestPost-inner"
            List<WebElement> postLinks = driver.findElements(By.cssSelector(".latestPost-inner h2 a"));

            // Lặp qua từng thẻ a và lưu URL vào danh sách
            for (WebElement postLink : postLinks) {
                String postUrl = postLink.getAttribute("href");
                System.out.println("URL: "+postUrl);
                postUrls.add(postUrl);
            }
        }

        List<CollectionInfo> CollectionInfoList = new ArrayList<>();

        // Lặp qua danh sách URL và truy cập từng URL để thu thập thông tin
        for (String postUrl : postUrls) {

            driver.get(postUrl);
            try {
                Thread.sleep(5000);  // Chờ trang web tải
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                // Lấy thông tin từ các phần tử HTML tương ứng
                System.out.println("URL_completed: "+postUrl);

                String title = driver.findElement(By.cssSelector("h1.title.single-title.entry-title")).getText();

                String imageUrl = driver.findElement(By.cssSelector("div.featured-thumbnail img")).getAttribute("src");

                String author = driver.findElement(By.cssSelector("span.theauthor span a")).getText();

                String date = driver.findElement(By.cssSelector("span.thetime.date.updated span")).getText();

                // Cuộn đến cuối trang để tải thêm nếu có
                js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
                // Chờ đợi cho đến khi tải thêm dữ liệu (nếu có)
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("w-loading")));
                // Lấy nội dung từ thẻ p trong class "thecontent"
                List<WebElement> pElements = driver.findElements(By.xpath("//div[@class='thecontent']//p[not(ancestor::div[contains(@class, 'list-style')])]"));
                StringBuilder contentBuilder = new StringBuilder();
                for (WebElement pElement : pElements) {
                    contentBuilder.append(pElement.getText()).append("\n");
                }
                String content = contentBuilder.toString();

                // Cuộn đến cuối trang để tải thêm nếu có
                js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
                // Chờ đợi cho đến khi tải thêm dữ liệu (nếu có)
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("w-loading")));

                // Lấy thông tin từ thẻ a trong class "tags"
                List<WebElement> tagElements = driver.findElements(By.cssSelector("div.tags a"));
                StringBuilder tagBuilder = new StringBuilder();
                for (WebElement tagElement : tagElements) {
                    tagBuilder.append(tagElement.getText()).append(", ");
                }
                String tag = tagBuilder.toString();
                // Loại bỏ dấu phẩy thừa ở cuối
                if (tag.endsWith(", ")) {
                    tag = tag.substring(0, tag.length() - 2);
                }

                CollectionInfoList.add(new CollectionInfo(title,imageUrl,author,date,tag,content));

            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
            } finally {
                try {
                    Thread.sleep(5000);  // Chờ trang web tải
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        saveDataToJson(CollectionInfoList);

        // Đóng trình duyệt khi hoàn tất
        driver.quit();
    }

    private static void saveDataToJson(List<OOP.TodayNFTNewsCrawler.CollectionInfo> collectionInfoList) {
        JsonArray jsonArray = new JsonArray();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(collectionInfoList);
        JsonObject mainJsonObject = new JsonObject();
        mainJsonObject.add("data", jsonArray);

        try (FileWriter fileWriter = new FileWriter("TodayNFTNews.json")) {
            fileWriter.write(json);
            System.out.println("Dữ liệu đã được lưu vào TodayNFTNews.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
