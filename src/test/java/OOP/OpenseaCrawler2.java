package OOP;

    import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class OpenseaCrawler2 {

        public static void main(String[] args) {
            String url = "https://opensea.io/rankings/trending?sortBy=one_day_volume";

            try {
                // Kết nối đến trang web và lấy HTML
                Document document = Jsoup.connect(url).get();

                // Tìm bảng ranking (hoặc phần tử HTML chứa thông tin bạn quan tâm)
                Element rankingTable = document.select("mx-auto w-full max-w-[2560px] px-4 sm:px-8 xxl:px-16 sc-43a40a80-0 jRllDH mb-8 xl:mb-16").first();

                // Xử lý và in thông tin từ bảng
                if (rankingTable != null) {
                    Elements rows = rankingTable.select("tr");
                    for (Element row : rows) {
                        // Xử lý từng hàng và lấy thông tin bạn cần
                        Elements columns = row.select("td");
                        if (!columns.isEmpty()) {
                            // In thông tin bạn quan tâm từ mỗi cột
                            System.out.println(columns.get(0).text() + " " +
                                    columns.get(1).text() + " " +
                                    columns.get(2).text());
                        }
                    }
                } else {
                    System.out.println("Không tìm thấy bảng xếp hạng.");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

