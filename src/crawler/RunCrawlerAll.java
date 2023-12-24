package crawler;

import java.io.IOException;

public class RunCrawlerAll {
    public static void main(String[] args) throws IOException, InterruptedException {
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
        // Các lệnh khác hoặc xử lý ngoại lệ (nếu cần)
    }
}