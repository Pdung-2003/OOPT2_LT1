package OOP.Binance;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;

public class BinanceTest {
    public static void main(String[] args) throws IOException, InterruptedException {

        String requestBody = "{\"network\": \"ALL\", \"period\": \"24H\", \"sortType\": \"volumeDesc\", \"page\": 1, \"rows\": 100}";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://www.binance.com/bapi/nft/v1/friendly/nft/ranking/top-collections-v2"))
                .header("Content-Type", "application/json")
                .method("POST", HttpRequest.BodyPublishers.ofString(requestBody))
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
        String filename = "Binance.json";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, false))) { // Chế độ không ghi đè, mỗi lần chạy là reset file
            writer.write(response.body());
        }
        // Đọc dữ liệu từ file
        String content = new String(Files.readAllBytes(Path.of(filename)));
        // Parse the JSON response
        Gson gson = new GsonBuilder().create();
        BinanceResponse binanceResponse = gson.fromJson(content, BinanceResponse.class);

        // Process and display the items
        for (CollectionItem item : binanceResponse.getData().getRows()) {
            System.out.println("Collection ID: " + item.getCollectionId());
            System.out.println("Cover URL: " + item.getCoverUrl());
            System.out.println("Title: " + item.getTitle());
            System.out.println("Network: " + item.getNetwork());
            System.out.println("Volume: " + item.getVolume());
            System.out.println("Volume Rate: " + item.getVolumeRate());
            System.out.println("Owners Count: " + item.getOwnersCount());
            System.out.println("Items Count: " + item.getItemsCount());
            System.out.println("Listed Count: " + item.getListedCount());
            System.out.println("Floor Price: " + item.getFloorPrice());
            System.out.println("Floor Price Rate: " + item.getFloorPriceRate());
            System.out.println("Verified: " + item.getVerified());
            System.out.println("----------------------------------------");
        }
    }
}
