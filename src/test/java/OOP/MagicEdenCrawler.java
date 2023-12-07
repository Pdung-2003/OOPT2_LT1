package OOP;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class MagicEdenCrawler {
    public static void main(String[] args) {
        try {
            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url("https://api-mainnet.magiceden.dev/v2/collections")
                    .get()
                    .addHeader("accept", "application/json")
                    .build();

            Response response = client.newCall(request).execute();

            if (response.isSuccessful()) {
                String responseData = response.body().string();

                System.out.println(responseData);

                // Lưu dữ liệu vào tệp JSON với tất cả các trường bạn quan tâm
                saveDataToFile(responseData, "Magiceden.json","symbol", "name", "description", "image", "twitter", "discord", "website", "categories", "isBadged", "hasCNFTs", "isOcp", "splTokens");

                // In thông báo
                System.out.println("Dữ liệu đã được ghi vào tệp Magiceden.json");
            } else {
                System.out.println("Không thể truy cập URL, mã trạng thái: " + response.code());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void saveDataToFile(String data, String filename, String... fields) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            // Chuyển đổi dữ liệu JSON thành một mảng JSONArray
            JSONArray jsonArray = new JSONArray(data);

            // Tạo một đối tượng JSONObject mới chỉ chứa các trường quan tâm cho từng phần tử trong mảng
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject item = jsonArray.getJSONObject(i);
                JSONObject filteredData = new JSONObject();

                for (String field : fields) {
                    if (item.has(field)) {
                        filteredData.put(field, item.get(field));
                    } else {
                        System.out.println("Trường '" + field + "' không tồn tại trong dữ liệu.");
                    }
                }

                // Ghi dữ liệu vào tệp và xuống dòng
                writer.write(filteredData.toString(4)); // Sử dụng 4 để có định dạng đẹp
                writer.newLine();
            }

            System.out.println("Dữ liệu đã được ghi vào tệp.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
