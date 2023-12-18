package OOP.Binance;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import OOP.DataCrawler;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class BinanceCrawler implements DataCrawler {
    public static List<CollectionItem> collectionItems;

    @Override
    public void fetchData() throws IOException, InterruptedException {
        String requestBody = "{\"network\": \"ALL\", \"period\": \"24H\", \"sortType\": \"volumeDesc\", \"page\": 1, \"rows\": 100}";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://www.binance.com/bapi/nft/v1/friendly/nft/ranking/top-collections-v2"))
                .header("Content-Type", "application/json")
                .method("POST", HttpRequest.BodyPublishers.ofString(requestBody))
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        Gson gson = new GsonBuilder().create();
        BinanceResponse binanceResponse = gson.fromJson(response.body(), BinanceResponse.class);
        collectionItems = binanceResponse.getData().getRows();
    }

    @Override
    public void processData() {
        // Xử lý collectionItems nếu cần
    }

    @Override
    public void saveData(String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, false))) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(collectionItems);
            writer.write(json);
        }
    }
    public static void main(String[] args) {
        BinanceCrawler crawler = new BinanceCrawler();
        try {
            crawler.fetchData();
            crawler.processData();
            crawler.saveData("Binance.json");
            System.out.println("Dữ liệu từ Binance đã được thu thập và lưu vào 'Binance.json'.");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static List<CollectionItem> getCollectionItems() {
        return collectionItems;
    }
}
