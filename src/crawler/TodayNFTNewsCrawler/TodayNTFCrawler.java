package OOP.TodayNFTNewsCrawler;

import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TodayNTFCrawler {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "chromedriver_win32 (1) - Copy\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, 10);

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

        JSONArray jsonArray = new JSONArray();

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
                JSONObject jsonArticle = new JSONObject();
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
                String tag = tagBuilder.toString();  // Loại bỏ dấu phẩy thừa ở cuối
                // Loại bỏ dấu phẩy thừa ở cuối
                if (tag.endsWith(", ")) {
                    tag = tag.substring(0, tag.length() - 2);
                }

//                System.out.println("Title: "+title);
//                System.out.println("Image Url: "+imageUrl);
//                System.out.println("Author: "+author);
//                System.out.println("Date: "+date);
//                System.out.println("Tag: "+tag);
//                System.out.println("Content: "+content);

                // Tạo đối tượng JSON cho mỗi bài viết
                jsonArticle.put("Title", title);
                jsonArticle.put("Image Url", imageUrl);
                jsonArticle.put("Author", author);
                jsonArticle.put("Date", date);
                jsonArticle.put("Tag",tag);
                jsonArticle.put("Content",content);

                // Thêm vào mảng JSON
                jsonArray.put(jsonArticle);

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

        try (FileWriter file = new FileWriter("TodayNFTNews.json")) {
            file.write(jsonArray.toString());
            System.out.println("Dữ liệu đã được lưu vào TodayNFTNews.json");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Đóng trình duyệt khi hoàn tất
        driver.quit();
    }
}

