package crawler;

import javax.swing.*;


public class RunCrawlerAll {
    public void run() {
        try {
            JOptionPane.showMessageDialog(null, "Vui lòng chờ đợi dữ liệu được thu thập.");
            // Tạo và chạy các crawler
            NiftyGatewayCrawler niftyGatewayCrawler = new NiftyGatewayCrawler();
            niftyGatewayCrawler.run();

            BinanceCrawler binanceCrawler = new BinanceCrawler();
            binanceCrawler.run();

            TwitterCrawler twitterCrawler = new TwitterCrawler();
            twitterCrawler.run();

            TodayNTFCrawler todayNTFCrawler = new TodayNTFCrawler();
            todayNTFCrawler.run();

            OpenseaCrawler openseaCrawler = new OpenseaCrawler();
            openseaCrawler.run();

            JOptionPane.showMessageDialog(null, "Dữ liệu đã được cập nhật thành công.");
        } catch (Exception e) {
            e.printStackTrace();
            // Xử lý exception nếu có
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra trong quá trình cập nhật dữ liệu.");
        }
    }
}