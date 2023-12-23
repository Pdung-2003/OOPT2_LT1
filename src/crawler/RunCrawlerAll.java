package crawler;

import java.io.IOException;

public class RunCrawlerAll {
    public void run() {
        // Tạo và chạy NiftyGatewayCrawler
        NiftyGatewayCrawler niftyGatewayCrawler = new NiftyGatewayCrawler();
        niftyGatewayCrawler.run();

        // Tạo và chạy BinanceCrawler
        BinanceCrawler binanceCrawler = new BinanceCrawler();
        binanceCrawler.run();

        // Tạo và chạy TwitterCrawler
        TwitterCrawler twitterCrawler = new TwitterCrawler();
        twitterCrawler.run();

        // Tạo và chạy TodayNFTCrawler
        TodayNTFCrawler todayNTFCrawler = new TodayNTFCrawler();
        try {
            todayNTFCrawler.run();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        // Tạo và chạy OpenseaCrawler
        OpenseaCrawler crawler = new OpenseaCrawler();
        try {
            crawler.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}