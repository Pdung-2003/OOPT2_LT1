package connectors;

import com.google.gson.reflect.TypeToken;
import models.*;
import services.GsonHandler;
import services.IJsonHandler;

import java.util.List;

public class GeneralConnector {
    private IJsonHandler gson = new GsonHandler();
    private String binanceDataFile = "data/Binance.json";
    private String niftyGatewayDataFile = "data/NiftyGatewayData.json";
    private String openseaDataFile = "data/OpenseaCrawlerRankingPer7Days.json";
    private String todayNFTNewsFile = "data/TodayNFTNews.json";
    private String twitterDataFile = "data/Twitter.json";

    public List<Binance> getBinanceData() throws Exception {
        return gson.fromJson(binanceDataFile, new TypeToken<List<Binance>>() {}.getType());
    }

    public List<NiftyGateway> getNiftyGatewayData() throws Exception {
        return gson.fromJson(niftyGatewayDataFile, new TypeToken<List<NiftyGateway>>() {}.getType());
    }

    public List<Opensea> getOpenseaData() throws Exception {
        return gson.fromJson(openseaDataFile, new TypeToken<List<Opensea>>() {}.getType());
    }

    public List<TodayNFTNews> getTodayNFTNews() throws Exception {
        return gson.fromJson(todayNFTNewsFile, new TypeToken<List<TodayNFTNews>>() {}.getType());
    }

    public List<Twitter> getTwitterData() throws Exception {
        return gson.fromJson(twitterDataFile, new TypeToken<List<Twitter>>() {}.getType());
    }
}