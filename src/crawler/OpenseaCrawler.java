package crawler;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import io.github.bonigarcia.wdm.WebDriverManager;
import models.Opensea;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OpenseaCrawler implements DataCrawler {
    private WebDriver driver;
    private Set<String> collectionNames = new HashSet<>();
    private List<Opensea> collectionInfoList = new ArrayList<>();
    private final int targetElementCount = 100;
    public void fetchData() throws IOException, InterruptedException {
        // Initialize WebDriver and navigate to the page
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensea.io/rankings/trending?sortBy=seven_day_volume");

        try {
            Thread.sleep(3000);  // Initial wait for the page to load
            crawlData(driver, collectionNames, collectionInfoList, targetElementCount);
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }

    private static void crawlData(WebDriver driver, Set<String> collectionNames, List<Opensea> collectionInfoList, int targetElementCount) {
        int currentElementCount = 0;

        while (currentElementCount < targetElementCount) {
            List<WebElement> currentElements = driver.findElements(By.cssSelector("div.sc-beff130f-0.sc-e7b51c31-0.hksMfk.fWxQZN"));

            for (WebElement element : currentElements) {
                WebElement collectionNameElement = element.findElement(By.cssSelector("div.sc-beff130f-0.sc-fadcb5cd-3.hksMfk.cqKvtL"));
                String collectionName = collectionNameElement.getText();

                if (!collectionNames.contains(collectionName)) {
                    WebElement image = element.findElement(By.tagName("img"));
                    String img = image.getAttribute("src");

                    WebElement salesElement = element.findElement(By.cssSelector("div.sc-beff130f-0.sc-f89095a4-0.sc-aabd2602-2.cuwMwy.gRSeGa"));
                    String sales = salesElement.getText();

                    List<WebElement> elementList = element.findElements(By.cssSelector("div.sc-beff130f-0.sc-f89095a4-0.sc-aabd2602-2.hcyTCW.gRSeGa"));
                    String volume = (elementList.size() >= 1) ? elementList.get(0).getText() : null;
                    String discount = (elementList.size() >= 2) ? elementList.get(1).getText() : null;
                    String floorPrice = (elementList.size() >= 3) ? elementList.get(2).getText() : null;

                    if (volume != null && discount != null && floorPrice != null && sales != null) {
                        collectionInfoList.add(new Opensea(collectionName, volume, floorPrice, img, discount, sales));
                        collectionNames.add(collectionName);
                        currentElementCount++;
                    }
                }
            }

            // Check if new elements are loaded
            int newElementCount = currentElements.size();
            if (newElementCount == 0) {
                break;  // No new elements loaded, exit loop
            }

            // Use keyboard actions to simulate scrolling
            simulateScrolling(driver);

            // Wait for the content to load
            waitForLoad(driver);

            if (!infiniteScroll(driver)) {
                break;
            }
        }

    }

    private static void simulateScrolling(WebDriver driver) {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.SPACE).build().perform(); // or use .sendKeys(Keys.ARROW_DOWN)
    }

    private static void waitForLoad(WebDriver driver) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(webDriver ->
                ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }


    private static boolean infiniteScroll(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        long lastHeight = (long) js.executeScript("return document.body.scrollHeight");

        simulateScrolling(driver);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long newHeight = (long) js.executeScript("return document.body.scrollHeight");
        return newHeight != lastHeight;
    }

    @Override
    public void saveData(String filename) throws IOException {
        saveDataToJson(filename);
    }

    private void saveDataToJson(String filename) throws IOException {
        JsonArray jsonArray = new JsonArray();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(collectionInfoList);
        JsonObject mainJsonObject = new JsonObject();
        mainJsonObject.add("data", jsonArray);
        String filePath = "data/" + filename;
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(json);
            System.out.println("Data has been saved to " + filename);
        }
    }
    public void run() throws IOException, InterruptedException {
        fetchData();
        saveData("OpenseaCrawlerRankingPer7Days.json");
    }
}
