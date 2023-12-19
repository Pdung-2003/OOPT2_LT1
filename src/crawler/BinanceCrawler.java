package crawler;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.common.reflect.TypeToken;
import com.google.gson.*;
import models.Binance;

public class BinanceCrawler implements DataCrawler {
    public static List<Binance> collectionItems;

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

        // Parse the JSON response
        JsonElement root = JsonParser.parseString(response.body());
        JsonArray dataArray = root.getAsJsonObject().getAsJsonObject("data").getAsJsonArray("rows");

        // Deserialize JSON array into a list of Binance objects
        Type listType = new TypeToken<List<Binance>>() {}.getType();
        collectionItems = gson.fromJson(dataArray, listType);
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
    @Override
    public void run() {
        try {
            fetchData();
            processData();
            saveData("Binance.json");
            System.out.println("Dữ liệu từ Binance đã được thu thập và lưu vào 'Binance.json'.");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
