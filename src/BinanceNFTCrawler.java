import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BinanceNFTCrawler {
    public static void main(String[] args) throws IOException, InterruptedException {
        String requestBody = "{\"network\": \"ALL\", \"period\": \"24H\", \"sortType\": \"volumeDesc\", \"page\": 1, \"rows\": 100}";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://www.binance.com/bapi/nft/v1/friendly/nft/ranking/top-collections-v2"))
                .header("Content-Type", "application/json")
                .method("POST", HttpRequest.BodyPublishers.ofString(requestBody))
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
    }
}

