import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class OpenSeaNFTCrawler {
    public static void main(String[] args) {
        // Thiết lập đường dẫn đến trình duyệt ChromeDriver
        System.setProperty("webdriver.chrome.driver", "\"C:\\Users\\FPTSHOP\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe\"");

        // Khởi tạo trình duyệt Chrome
        WebDriver driver = new ChromeDriver();

        // Mở trang web OpenSea
        driver.get("https://opensea.io/rankings/trending?sortBy=one_day_volume");

        // Đợi một khoảng thời gian để trang web tải đầy đủ
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Tìm tất cả các phần tử chứa thông tin về NFT
        List<WebElement> nftElements = driver.findElements(By.className("sc-beff130f-0 sc-630fc9ab-0 hksMfk bNkKFC w-full"));

        // Lặp qua từng phần tử và in ra thông tin
        for (WebElement nftElement : nftElements) {
            // Trích xuất thông tin từ mỗi phần tử và xử lý dữ liệu theo nhu cầu
            String nftName = nftElement.findElement(By.className("sc-48082a-0 bguyED")).getText();
            String nftPrice = nftElement.findElement(By.className("sc-48082a-0 axQXd")).getText();
            String nftNum = nftElement.findElement(By.className("sc-48082a-0 axQXd")).getText();

            // In ra thông tin NFT
            System.out.println("Tên NFT: " + nftName);
            System.out.println("Giá NFT: " + nftPrice);
            System.out.println("Số lượng:  " + nftDescription);
            System.out.println("------------------------");
        }

        // Đóng trình duyệt
        driver.quit();
    }
}
