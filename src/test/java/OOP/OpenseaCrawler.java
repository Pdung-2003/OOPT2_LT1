package OOP;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;

class OpenseaAsset {
    private Asset[] assets;

    public Asset[] getAssets() {
        return assets;
    }

    public void setAssets(Asset[] assets) {
        this.assets = assets;
    }

    public static OpenseaAsset fromJson(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, OpenseaAsset.class);
    }

    public static class Asset {

        private long id;
        private String tokenId;
        private int numSales;
        private String imageUrl;
        private String name;
        private String description;
        private String permalink;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getTokenId() {
            return tokenId;
        }

        public void setTokenId(String tokenId) {
            this.tokenId = tokenId;
        }

        public int getNumSales() {
            return numSales;
        }

        public void setNumSales(int numSales) {
            this.numSales = numSales;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getPermalink() {
            return permalink;
        }

        public void setPermalink(String permalink) {
            this.permalink = permalink;
        }


        // Getter and Setter methods for Asset class (similar to OpenseaAsset)

        public void printInfo() {
            System.out.println("ID: " + getId());
            System.out.println("Token ID: " + getTokenId());
            System.out.println("Num Sales: " + getNumSales());
            System.out.println("Image URL: " + getImageUrl());
            System.out.println("Name: " + getName());
            System.out.println("Description: " + getDescription());
            System.out.println("Permalink: " + getPermalink());
            System.out.println("----------------------------------------");
        }
    }
}



public class OpenseaCrawler {
    public static void main(String[] args) {
        try {
            String openseaUrl = "https://api.opensea.io/api/v1/assets";
            String apiKey = "fc3139b5a7d04e59a6fa482282958cb3"; // Thay YOUR_API_KEY bằng khóa API của bạn
            String requestBody = "?order_direction=desc&offset=0&limit=10";

            // Gửi yêu cầu đến Opensea sử dụng API key
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(openseaUrl + requestBody))
                    .header("accept", "application/json")
                    .header("X-API-KEY", apiKey)
                    .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/117.0.0.0 Safari/537.36 OPR/103.0.0.0")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                // Xử lý dữ liệu JSON ở đây
                System.out.println(response.body());
                String filename = "Opensea.json";
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, false))) { // Chế độ không ghi đè, mỗi lần chạy là reset file
                    writer.write(response.body());
                }
                String content = new String(Files.readAllBytes(Path.of(filename)));
                // Parse the JSON response
                String jsonString = "{ \"assets\": [ { \"id\": \"ALL\", \"token_id\": \"1987\", \"num_sales\": 0, \"image_url\": \"https://i.seadn.io/s/raw/files/99a71ce909dfd148f14ffbb127d88afb.png?w=500&auto=format\", \"name\": \"cz #55\", \"description\": \"Pics of CZ from around the world.\", \"permalink\": \"https://opensea.io/assets/ethereum/0x9ed3a4efa227816024db8ecc8661f9c0add1d1b2/55\" } ] }";

                // Chuyển đổi JSON thành đối tượng Java
                OpenseaAsset openseaAsset = OpenseaAsset.fromJson(jsonString);

                // Lấy mảng các tài sản từ đối tượng OpenseaAsset
                OpenseaAsset.Asset[] assets = openseaAsset.getAssets();

                // In thông tin từ mỗi đối tượng ra màn hình
                for (OpenseaAsset.Asset asset : assets) {
                    asset.printInfo();
                }
            } else {
                System.out.println("Request failed with status code: " + response.statusCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}