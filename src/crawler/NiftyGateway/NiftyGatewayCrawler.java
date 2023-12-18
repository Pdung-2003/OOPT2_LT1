package crawler.NiftyGateway;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import crawler.DataCrawler;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class NiftyGatewayCrawler implements DataCrawler {
    private List<Result> results;

    @Override
    public void fetchData() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.niftygateway.com/stats/rankings/?page=1&page_size=50&sort=-one_day_total_volume"))
                .header("accept", "application/json, text/plain, /")
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/117.0.0.0 Safari/537.36 OPR/103.0.0.0")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        Gson gson = new GsonBuilder().create();
        Response responseObj = gson.fromJson(response.body(), Response.class);
        results = responseObj.getResults();
    }

    @Override
    public void processData() {
        // Xử lý dữ liệu (nếu cần)
    }

    @Override
    public void saveData(String filename) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(this.results);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(json);
        }
    }
    public static void main(String[] args) {
        NiftyGatewayCrawler crawler = new NiftyGatewayCrawler();
        try {
            crawler.fetchData(); // Thu thập dữ liệu từ Nifty Gateway
            crawler.processData(); // Xử lý dữ liệu (nếu cần)
            crawler.saveData("NiftyGatewayData.json"); // Lưu dữ liệu vào file
            System.out.println("Dữ liệu từ Nifty Gateway đã được thu thập và lưu vào 'NiftyGatewayData.json'.");
        } catch (IOException | InterruptedException e) {
            System.err.println("Đã xảy ra lỗi: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
