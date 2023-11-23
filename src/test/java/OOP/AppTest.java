package OOP;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import com.google.gson.annotations.SerializedName;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

class Collection {
    @SerializedName("niftyTitle")
    private String niftyTitle;

    @SerializedName("niftyType")
    private int niftyType;

    @SerializedName("niftyContractAddress")
    private String niftyContractAddress;

    @SerializedName("niftyDisplayImage")
    private String niftyDisplayImage;

    // Các getter và setter cho các thuộc tính này
    // ...

    public Collection(String niftyTitle, int niftyType, String niftyContractAddress, String niftyDisplayImage) {
        this.niftyTitle = niftyTitle;
        this.niftyType = niftyType;
        this.niftyContractAddress = niftyContractAddress;
        this.niftyDisplayImage = niftyDisplayImage;
    }

    public String getNiftyTitle() {
        return niftyTitle;
    }

    public void setNiftyTitle(String niftyTitle) {
        this.niftyTitle = niftyTitle;
    }

    public int getNiftyType() {
        return niftyType;
    }

    public void setNiftyType(int niftyType) {
        this.niftyType = niftyType;
    }

    public String getNiftyContractAddress() {
        return niftyContractAddress;
    }

    public void setNiftyContractAddress(String niftyContractAddress) {
        this.niftyContractAddress = niftyContractAddress;
    }

    public String getNiftyDisplayImage() {
        return niftyDisplayImage;
    }

    public void setNiftyDisplayImage(String niftyDisplayImage) {
        this.niftyDisplayImage = niftyDisplayImage;
    }
}

class Result {
    @SerializedName("collection")
    private Collection collection;

    @SerializedName("floorPrice")
    private String floorPrice;

    @SerializedName("numOwners")
    private int numOwners;

    @SerializedName("oneDayTotalVolume")
    private String oneDayTotalVolume;

    @SerializedName("oneDayChange")
    private String oneDayChange;

    // Các getter và setter cho các thuộc tính này
    // ...

    public Result(Collection collection, String floorPrice, int numOwners, String oneDayTotalVolume, String oneDayChange) {
        this.collection = collection;
        this.floorPrice = floorPrice;
        this.numOwners = numOwners;
        this.oneDayTotalVolume = oneDayTotalVolume;
        this.oneDayChange = oneDayChange;
    }

    public Collection getCollection() {
        return collection;
    }

    public void setCollection(Collection collection) {
        this.collection = collection;
    }

    public String getFloorPrice() {
        return floorPrice;
    }

    public void setFloorPrice(String floorPrice) {
        this.floorPrice = floorPrice;
    }

    public int getNumOwners() {
        return numOwners;
    }

    public void setNumOwners(int numOwners) {
        this.numOwners = numOwners;
    }

    public String getOneDayTotalVolume() {
        return oneDayTotalVolume;
    }

    public void setOneDayTotalVolume(String oneDayTotalVolume) {
        this.oneDayTotalVolume = oneDayTotalVolume;
    }

    public String getOneDayChange() {
        return oneDayChange;
    }

    public void setOneDayChange(String oneDayChange) {
        this.oneDayChange = oneDayChange;
    }
}
public class AppTest extends TestCase {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Print");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.niftygateway.com/stats/rankings/?page=1&page_size=50&sort=-one_day_total_volume"))
                .header("accept", "application/json, text/plain, /")
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/117.0.0.0 Safari/537.36 OPR/103.0.0.0")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());

        Gson gson = new GsonBuilder().create();
        TypeToken<Map<String, Object>> token = new TypeToken<>() {};
        Map<String, Object> data = gson.fromJson(response.body(), token.getType());

        // Truy xuất các thuộc tính cụ thể từ dữ liệu
        int count = (int) data.get("count");
        String next = (String) data.get("next");
        String previous = (String) data.get("previous");
        int totalPages = (int) data.get("totalPages");

        // Truy xuất mảng results từ dữ liệu
        List<Result> results = gson.fromJson(gson.toJson(data.get("results")), new TypeToken<List<Result>>() {}.getType());

        // Bây giờ bạn có thể làm việc với các biến và mảng này theo nhu cầu của bạn
        // Ví dụ: in ra số lượng kết quả và các giá trị từ mảng results
        System.out.println("Count: " + count);
        System.out.println("Next: " + next);
        System.out.println("Previous: " + previous);
        System.out.println("Total Pages: " + totalPages);
        System.out.println("Number of Results: " + results.size());
    }
}
