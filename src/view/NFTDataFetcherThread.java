package view;

import OOP.TodayNFTNewsCrawler.TodayNTFCrawler;
import crawler.BinanceCrawler;
import crawler.NiftyGateway.NiftyGatewayCrawler;
import crawler.Opensea.OpenseaCrawler;
import crawler.Twitter.TwitterCrawler;

public class NFTDataFetcherThread extends Thread{
    @Override
    public void run() {
        try {
            NiftyGatewayCrawler.main(new String[]{});
            BinanceCrawler.main(new String[]{});
            OpenseaCrawler.main(new String[]{});
            TodayNTFCrawler.main(new String[]{});
            TwitterCrawler.main(new String[]{});
        } catch (Exception e) {
            // Handle exceptions or log errors if needed
            e.printStackTrace();
        }
    }
}