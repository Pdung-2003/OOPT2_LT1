package OOP.NiftyGateway;

import junit.framework.TestCase;
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

public class NiftygatewayTest extends TestCase {
    private static List<Result> results;
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
        results = gson.fromJson(gson.toJson(data.get("results")), new TypeToken<List<Result>>() {
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
    public static List<Result> getResults() {
        return results;
    }
}
