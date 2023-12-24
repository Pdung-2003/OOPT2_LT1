package crawler;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import io.github.bonigarcia.wdm.WebDriverManager;
import models.TodayNFTNews;
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

public class TodayNFTCrawler implements DataCrawler {
    public static List<TodayNFTNews> CollectionInfoList = new ArrayList<>();

    @Override
    public void fetchData() throws IOException, InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        List<String> postUrls = new ArrayList<>();

        //n số page cần crawl
        int n = 15;
        for (int i=1;i<n ;i++)
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

            // Kiểm tra xem nút đóng có tồn tại trên trang không trước khi click
            if (closeButton.isDisplayed() && closeButton.isEnabled()) {
                // Click vào thẻ button
                closeButton.click();
            }
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
                System.out.println("URL_completed: " + postUrl);

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

                CollectionInfoList.add(new TodayNFTNews(author, date, tag, content, title, imageUrl));

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
    }


    @Override
    public void saveData(String filename) throws IOException {
        saveDataToJson(CollectionInfoList, filename);
    }



    private void saveDataToJson(List<TodayNFTNews> collectionInfoList, String filename) {
        JsonArray jsonArray = new JsonArray();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(collectionInfoList);
        String filePath = "data/" + filename;
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(json);
            System.out.println("Dữ liệu đã được lưu vào " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() throws IOException, InterruptedException {
        fetchData();
        saveData("TodayNFTNews.json");
        System.out.println("Dữ liệu từ TodayNFTNews đã được thu thập và lưu vào 'TodayNFTNews.json'.");
    }
}