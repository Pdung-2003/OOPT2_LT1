package view;

import crawler.BinanceCrawler;
import crawler.NiftyGateway.NiftyGatewayCrawler;

public class NFTDataFetcherThread extends Thread{
    @Override
    public void run() {
        try {
            NiftyGatewayCrawler.main(new String[]{});
            BinanceCrawler.main(new String[]{});
        } catch (Exception e) {
            // Handle exceptions or log errors if needed
            e.printStackTrace();
        }
    }
}