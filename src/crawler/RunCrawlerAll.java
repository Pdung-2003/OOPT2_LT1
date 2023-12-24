package crawler;

import javax.swing.*;
import java.io.IOException;

public class RunCrawlerAll {
    public static void main(String[] args) throws IOException, InterruptedException {

        try {
            JOptionPane.showMessageDialog(null, "Vui lòng chờ đợi dữ liệu được thu thập.");

            // Tạo và chạy NiftyGatewayCrawler
            NiftyGatewayCrawler niftyGatewayCrawler = new NiftyGatewayCrawler();
            niftyGatewayCrawler.run();

            // Tạo và chạy BinanceCrawler
            BinanceCrawler binanceCrawler = new BinanceCrawler();
            binanceCrawler.run();

            // Tạo và chạy TwitterCrawler
            TwitterCrawler twitterCrawler = new TwitterCrawler();
            twitterCrawler.run();

            OpenseaCrawler openseaCrawler   = new OpenseaCrawler();
            openseaCrawler.run();

            TodayNTFCrawler todayNTFCrawler = new TodayNTFCrawler();
            todayNTFCrawler.run();

            JOptionPane.showMessageDialog(null, "Dữ liệu đã được cập nhật thành công.");
        } catch (Exception e) {
            e.printStackTrace();
            // Xử lý exception nếu có
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra trong quá trình cập nhật dữ liệu.");
        }
    }
}