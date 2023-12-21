package crawler;

public class RunCrawlerAll {
    public static void main(String[] args) {
        // Tạo và chạy NiftyGatewayCrawler
        NiftyGatewayCrawler niftyGatewayCrawler = new NiftyGatewayCrawler();
        niftyGatewayCrawler.run();

        // Tạo và chạy BinanceCrawler
        BinanceCrawler binanceCrawler = new BinanceCrawler();
        binanceCrawler.run();

        // Tạo và chạy TwitterCrawler
        TwitterCrawler twitterCrawler = new TwitterCrawler();
        twitterCrawler.run();

        // Các lệnh khác hoặc xử lý ngoại lệ (nếu cần)
    }
}