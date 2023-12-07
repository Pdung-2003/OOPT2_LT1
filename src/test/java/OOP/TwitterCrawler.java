package OOP;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TwitterCrawler {
    public static void main(String[] args) {
        // Thiết lập đường dẫn đến ChromeDriver
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

        // Khởi tạo WebDriver
        WebDriver driver = new ChromeDriver();

        // Mở trang Twitter
        driver.get("https://twitter.com");

        // Đợi một khoảng thời gian để trang Twitter load
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Đăng nhập (điền thông tin tài khoản của bạn)
        String username = "";
        String password = "your_password";

        WebElement usernameInput = driver.findElement(By.name("session[username_or_email]"));
        WebElement passwordInput = driver.findElement(By.name("session[password]"));

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        passwordInput.sendKeys(Keys.RETURN);

        // Đợi một khoảng thời gian để đăng nhập
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Tìm kiếm các tweet có hashtag là #NFT
        String hashtag = "NFT";
        driver.get("https://twitter.com/search?q=%23" + hashtag);

        // Đợi một khoảng thời gian để trang kết quả tìm kiếm load
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Lấy và in ra các tweet
        WebElement body = driver.findElement(By.tagName("body"));
        String tweets = body.getText();
        System.out.println(tweets);

        // Đóng trình duyệt sau khi hoàn thành
        driver.quit();
    }
}
