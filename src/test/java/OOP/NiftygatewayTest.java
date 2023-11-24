package OOP;

import junit.framework.TestCase;
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

    @SerializedName("totalSupply")
    private int totalSupply;

    @SerializedName("numOwners")
    private int numOwners;
    @SerializedName("totalMarketCap")
    private String totalMarketCap;

    @SerializedName("totalNumTotalSales")
    private int totalNumTotalSales;


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
    public String getTotalMarketCap() {
        return totalMarketCap;
    }

    public void setTotalMarketCap(String totalMarketCap) {
        this.totalMarketCap = totalMarketCap;
    }

    public int getTotalNumTotalSales() {
        return totalNumTotalSales;
    }

    public void setTotalNumTotalSales(int totalNumTotalSales) {
        this.totalNumTotalSales = totalNumTotalSales;
    }

    public int getTotalSupply() {
        return totalSupply;
    }

    public void setTotalSupply(int totalSupply) {
        this.totalSupply = totalSupply;
    }

    public int getNumOwners() {
        return numOwners;
    }

    public void setNumOwners(int numOwners) {
        this.numOwners = numOwners;
    }
}

class Result {
    @SerializedName("collection")
    private Collection collection;

    @SerializedName("floorPrice")
    private float floorPrice; // Giả sử là số thực


    @SerializedName("oneDayTotalVolume")
    private float oneDayTotalVolume;

    @SerializedName("oneDayChange")
    private float oneDayChange;

    @SerializedName("sevenDayTotalVolume")
    private float sevenDayTotalVolume;

    @SerializedName("sevenDayChange")
    private float sevenDayChange;

    @SerializedName("thirtyDayTotalVolume")
    private float thirtyDayTotalVolume;

    @SerializedName("thirtyDayChange")
    private float thirtyDayChange;

    @SerializedName("totalVolume")
    private float totalVolume;

    @SerializedName("avgSalePrice")
    private float avgSalePrice;

    @SerializedName("totalPrimaryVolume")
    private int totalPrimaryVolume;

    @SerializedName("totalSecondaryVolume")
    private int totalSecondaryVolume;

    @SerializedName("oneDayNumSecondarySales")
    private int oneDayNumSecondarySales;

    @SerializedName("oneDayNumSecondarySalesChange")
    private float oneDayNumSecondarySalesChange;

    @SerializedName("oneDayNumTotalSales")
    private int oneDayNumTotalSales;

    @SerializedName("oneDayNumTotalSalesChange")
    private float oneDayNumTotalSalesChange;

    @SerializedName("sevenDayNumSecondarySales")
    private int sevenDayNumSecondarySales;

    @SerializedName("sevenDayNumSecondarySalesChange")
    private float sevenDayNumSecondarySalesChange;

    @SerializedName("sevenDayNumTotalSales")
    private int sevenDayNumTotalSales;

    @SerializedName("sevenDayNumTotalSalesChange")
    private float sevenDayNumTotalSalesChange;

    @SerializedName("thirtyDayNumSecondarySales")
    private int thirtyDayNumSecondarySales;

    @SerializedName("thirtyDayNumSecondarySalesChange")
    private float thirtyDayNumSecondarySalesChange;

    @SerializedName("thirtyDayNumTotalSales")
    private int thirtyDayNumTotalSales;

    @SerializedName("thirtyDayNumTotalSalesChange")
    private float thirtyDayNumTotalSalesChange;


    @SerializedName("totalNumSecondarySales")
    private int totalNumSecondarySales;

    @SerializedName("totalNumPrimarySales")
    private int totalNumPrimarySales;


    // Các getter và setter...


    // Các getter và setter cho các thuộc tính này
    // ...


    public Collection getCollection() {
        return collection;
    }

    public void setCollection(Collection collection) {
        this.collection = collection;
    }

    public float getFloorPrice() {
        return floorPrice;
    }

    public void setFloorPrice(float floorPrice) {
        this.floorPrice = floorPrice;
    }


    public float  getOneDayTotalVolume() {
        return oneDayTotalVolume;
    }

    public void setOneDayTotalVolume(float  oneDayTotalVolume) {
        this.oneDayTotalVolume = oneDayTotalVolume;
    }

    public float  getOneDayChange() {
        return oneDayChange;
    }

    public void setOneDayChange(float  oneDayChange) {
        this.oneDayChange = oneDayChange;
    }

    public float getSevenDayTotalVolume() {
        return sevenDayTotalVolume;
    }

    public void setSevenDayTotalVolume(float sevenDayTotalVolume) {
        this.sevenDayTotalVolume = sevenDayTotalVolume;
    }

    public float getSevenDayChange() {
        return sevenDayChange;
    }

    public void setSevenDayChange(float sevenDayChange) {
        this.sevenDayChange = sevenDayChange;
    }

    public float getThirtyDayTotalVolume() {
        return thirtyDayTotalVolume;
    }

    public void setThirtyDayTotalVolume(float thirtyDayTotalVolume) {
        this.thirtyDayTotalVolume = thirtyDayTotalVolume;
    }

    public float getThirtyDayChange() {
        return thirtyDayChange;
    }

    public void setThirtyDayChange(float thirtyDayChange) {
        this.thirtyDayChange = thirtyDayChange;
    }

    public float getTotalVolume() {
        return totalVolume;
    }

    public void setTotalVolume(float totalVolume) {
        this.totalVolume = totalVolume;
    }

    public float getAvgSalePrice() {
        return avgSalePrice;
    }

    public void setAvgSalePrice(float avgSalePrice) {
        this.avgSalePrice = avgSalePrice;
    }

    public int getTotalPrimaryVolume() {
        return totalPrimaryVolume;
    }

    public void setTotalPrimaryVolume(int totalPrimaryVolume) {
        this.totalPrimaryVolume = totalPrimaryVolume;
    }

    public int getTotalSecondaryVolume() {
        return totalSecondaryVolume;
    }

    public void setTotalSecondaryVolume(int totalSecondaryVolume) {
        this.totalSecondaryVolume = totalSecondaryVolume;
    }

    public int getOneDayNumSecondarySales() {
        return oneDayNumSecondarySales;
    }

    public void setOneDayNumSecondarySales(int oneDayNumSecondarySales) {
        this.oneDayNumSecondarySales = oneDayNumSecondarySales;
    }

    public float getOneDayNumSecondarySalesChange() {
        return oneDayNumSecondarySalesChange;
    }

    public void setOneDayNumSecondarySalesChange(float oneDayNumSecondarySalesChange) {
        this.oneDayNumSecondarySalesChange = oneDayNumSecondarySalesChange;
    }

    public int getOneDayNumTotalSales() {
        return oneDayNumTotalSales;
    }

    public void setOneDayNumTotalSales(int oneDayNumTotalSales) {
        this.oneDayNumTotalSales = oneDayNumTotalSales;
    }

    public float getOneDayNumTotalSalesChange() {
        return oneDayNumTotalSalesChange;
    }

    public void setOneDayNumTotalSalesChange(float oneDayNumTotalSalesChange) {
        this.oneDayNumTotalSalesChange = oneDayNumTotalSalesChange;
    }

    public int getSevenDayNumSecondarySales() {
        return sevenDayNumSecondarySales;
    }

    public void setSevenDayNumSecondarySales(int sevenDayNumSecondarySales) {
        this.sevenDayNumSecondarySales = sevenDayNumSecondarySales;
    }

    public float getSevenDayNumSecondarySalesChange() {
        return sevenDayNumSecondarySalesChange;
    }

    public void setSevenDayNumSecondarySalesChange(float sevenDayNumSecondarySalesChange) {
        this.sevenDayNumSecondarySalesChange = sevenDayNumSecondarySalesChange;
    }

    public int getSevenDayNumTotalSales() {
        return sevenDayNumTotalSales;
    }

    public void setSevenDayNumTotalSales(int sevenDayNumTotalSales) {
        this.sevenDayNumTotalSales = sevenDayNumTotalSales;
    }

    public float getSevenDayNumTotalSalesChange() {
        return sevenDayNumTotalSalesChange;
    }

    public void setSevenDayNumTotalSalesChange(float sevenDayNumTotalSalesChange) {
        this.sevenDayNumTotalSalesChange = sevenDayNumTotalSalesChange;
    }

    public int getThirtyDayNumSecondarySales() {
        return thirtyDayNumSecondarySales;
    }

    public void setThirtyDayNumSecondarySales(int thirtyDayNumSecondarySales) {
        this.thirtyDayNumSecondarySales = thirtyDayNumSecondarySales;
    }

    public float getThirtyDayNumSecondarySalesChange() {
        return thirtyDayNumSecondarySalesChange;
    }

    public void setThirtyDayNumSecondarySalesChange(float thirtyDayNumSecondarySalesChange) {
        this.thirtyDayNumSecondarySalesChange = thirtyDayNumSecondarySalesChange;
    }

    public int getThirtyDayNumTotalSales() {
        return thirtyDayNumTotalSales;
    }

    public void setThirtyDayNumTotalSales(int thirtyDayNumTotalSales) {
        this.thirtyDayNumTotalSales = thirtyDayNumTotalSales;
    }

    public float getThirtyDayNumTotalSalesChange() {
        return thirtyDayNumTotalSalesChange;
    }

    public void setThirtyDayNumTotalSalesChange(float thirtyDayNumTotalSalesChange) {
        this.thirtyDayNumTotalSalesChange = thirtyDayNumTotalSalesChange;
    }

    public int getTotalNumSecondarySales() {
        return totalNumSecondarySales;
    }

    public void setTotalNumSecondarySales(int totalNumSecondarySales) {
        this.totalNumSecondarySales = totalNumSecondarySales;
    }

    public int getTotalNumPrimarySales() {
        return totalNumPrimarySales;
    }

    public void setTotalNumPrimarySales(int totalNumPrimarySales) {
        this.totalNumPrimarySales = totalNumPrimarySales;
    }
}
class Response {
    private int count;
    private String next;
    private String previous;
    private int totalPages;
    private List<Result> results;

    public int getCount() {
        return count;
    }

    public String getNext() {
        return next;
    }

    public String getPrevious() {
        return previous;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public List<Result> getResults() {
        return results;
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

 //        System.out.println(response.body());

        Gson gson = new GsonBuilder().create();
        Response responseObj = gson.fromJson(response.body(), Response.class);
        TypeToken<Map<String, Object>> token = new TypeToken<>() {
        };
        Map<String, Object> data = gson.fromJson(response.body(), token.getType());

        // Ép kiểu các thuộc tính số cẩn thận
        double countDouble = (double) data.get("count");
        int count = (int) countDouble;

        double totalPagesDouble = (double) data.get("totalPages");
        int totalPages = (int) totalPagesDouble;

        // Các truy xuất còn lại...
        String next = (String) data.get("next");
        String previous = (String) data.get("previous");

        // Truy xuất mảng results từ dữ liệu
        List<Result> results = gson.fromJson(gson.toJson(data.get("results")), new TypeToken<List<Result>>() {
        }.getType());

        // Bây giờ bạn có thể làm việc với các biến và mảng này theo nhu cầu của bạn
        // Ví dụ: in ra số lượng kết quả và các giá trị từ mảng results
        System.out.println("Count: " + count);
        System.out.println("Next: " + next);
        System.out.println("Previous: " + previous);
        System.out.println("Total Pages: " + totalPages);
        System.out.println("Number of Results: " + results.size());

        for (Result result : responseObj.getResults()) { // đoạn này là in toàn bộ NFT và toàn bộ thuộc tính, dựa vào đó để chỉnh sửa các lệnh như insert Database...
            Collection collection = result.getCollection();
            System.out.println("Collection Title: " + collection.getNiftyTitle());
            System.out.println("Collection Type: " + collection.getNiftyType());
            System.out.println("Contract Address: " + collection.getNiftyContractAddress());
            System.out.println("Display Image: " + collection.getNiftyDisplayImage());
            System.out.println("Total Market Cap: " + collection.getTotalMarketCap());
            System.out.println("Number of Owners: " + collection.getNumOwners());
            System.out.println("Total Supply: " + collection.getTotalSupply());
            System.out.println("Total Num Total Sales: " + collection.getTotalNumTotalSales());
            System.out.println("Floor Price: " + result.getFloorPrice());
            System.out.println("One Day Total Volume: " + result.getOneDayTotalVolume());
            System.out.println("One Day Change: " + result.getOneDayChange());
            System.out.println("Seven Day Total Volume: " + result.getSevenDayTotalVolume());
            System.out.println("Seven Day Change: " + result.getSevenDayChange());
            System.out.println("Thirty Day Total Volume: " + result.getThirtyDayTotalVolume());
            System.out.println("Thirty Day Change: " + result.getThirtyDayChange());
            System.out.println("Total Volume: " + result.getTotalVolume());
            System.out.println("Average Sale Price: " + result.getAvgSalePrice());
            System.out.println("Total Primary Volume: " + result.getTotalPrimaryVolume());
            System.out.println("Total Secondary Volume: " + result.getTotalSecondaryVolume());
            System.out.println("One Day Num Secondary Sales: " + result.getOneDayNumSecondarySales());
            System.out.println("One Day Num Secondary Sales Change: " + result.getOneDayNumSecondarySalesChange());
            System.out.println("One Day Num Total Sales: " + result.getOneDayNumTotalSales());
            System.out.println("One Day Num Total Sales Change: " + result.getOneDayNumTotalSalesChange());
            System.out.println("Seven Day Num Secondary Sales: " + result.getSevenDayNumSecondarySales());
            System.out.println("Seven Day Num Secondary Sales Change: " + result.getSevenDayNumSecondarySalesChange());
            System.out.println("Seven Day Num Total Sales: " + result.getSevenDayNumTotalSales());
            System.out.println("Seven Day Num Total Sales Change: " + result.getSevenDayNumTotalSalesChange());
            System.out.println("Thirty Day Num Secondary Sales: " + result.getThirtyDayNumSecondarySales());
            System.out.println("Thirty Day Num Secondary Sales Change: " + result.getThirtyDayNumSecondarySalesChange());
            System.out.println("Thirty Day Num Total Sales: " + result.getThirtyDayNumTotalSales());
            System.out.println("Thirty Day Num Total Sales Change: " + result.getThirtyDayNumTotalSalesChange());
            System.out.println("Total Num Secondary Sales: " + result.getTotalNumSecondarySales());
            System.out.println("Total Num Primary Sales: " + result.getTotalNumPrimarySales());

            System.out.println("----------------------------------------");
        }

    }
}
