package OOP;
import junit.framework.TestCase;
import com.google.gson.annotations.SerializedName;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

class CollectionItem {
    @SerializedName("collectionId")
    private String collectionId;

    @SerializedName("coverUrl")
    private String coverUrl;

    @SerializedName("title")
    private String title;

    @SerializedName("network")
    private String network;

    @SerializedName("volume")
    private String volume;

    @SerializedName("volumeRate")
    private String volumeRate;

    @SerializedName("ownersCount")
    private int ownersCount;

    @SerializedName("itemsCount")
    private int itemsCount;

    @SerializedName("listedCount")
    private Integer listedCount; // Nullable

    @SerializedName("floorPrice")
    private String floorPrice;

    @SerializedName("floorPriceRate")
    private String floorPriceRate;

    @SerializedName("verified")
    private int verified;

    public String getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(String collectionId) {
        this.collectionId = collectionId;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getVolumeRate() {
        return volumeRate;
    }

    public void setVolumeRate(String volumeRate) {
        this.volumeRate = volumeRate;
    }

    public int getOwnersCount() {
        return ownersCount;
    }

    public void setOwnersCount(int ownersCount) {
        this.ownersCount = ownersCount;
    }

    public int getItemsCount() {
        return itemsCount;
    }

    public void setItemsCount(int itemsCount) {
        this.itemsCount = itemsCount;
    }

    public Integer getListedCount() {
        return listedCount;
    }

    public void setListedCount(Integer listedCount) {
        this.listedCount = listedCount;
    }

    public String getFloorPrice() {
        return floorPrice;
    }

    public void setFloorPrice(String floorPrice) {
        this.floorPrice = floorPrice;
    }

    public String getFloorPriceRate() {
        return floorPriceRate;
    }

    public void setFloorPriceRate(String floorPriceRate) {
        this.floorPriceRate = floorPriceRate;
    }

    public int getVerified() {
        return verified;
    }

    public void setVerified(int verified) {
        this.verified = verified;
    }

}
class BinanceResponse {
    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    static class Data {
        private List<CollectionItem> rows;

        public List<CollectionItem> getRows() {
            return rows;
        }

        public void setRows(List<CollectionItem> rows) {
            this.rows = rows;
        }
    }
}
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
