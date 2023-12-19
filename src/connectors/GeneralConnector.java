package connectors;

import com.google.gson.reflect.TypeToken;
import models.*;
import services.GsonHandler;
import services.IJsonHandler;

import java.util.List;

public class GeneralConnector {
    public List<Binance> binanceList;
    public List<NiftyGateway> niftyGatewayList;
    public List<Opensea> openseaList;
    public List<TodayNFTNews> todayNFTNewsList;
    public List<Twitter> twitterList;
    IJsonHandler gson = new GsonHandler();
    public GeneralConnector() {

    }
    public void getData() throws Exception {
        binanceList = gson.fromJson("Binance.json", new TypeToken<List<Binance>>() {
        }.getType());
        niftyGatewayList = gson.fromJson("NiftyGatewayData.json", new TypeToken<List<NiftyGateway>>() {
        }.getType());
        openseaList = gson.fromJson("OpenseaCrawlerRankingPer7Days.json", new TypeToken<List<Opensea>>() {
        }.getType());
        todayNFTNewsList = gson.fromJson("TodayNFTNews.json", new TypeToken<List<TodayNFTNews>>() {
        }.getType());
        twitterList = gson.fromJson("Twitter.json", new TypeToken<List<Twitter>>() {
        }.getType());
    }
}
