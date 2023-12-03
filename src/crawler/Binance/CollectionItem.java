package OOP;
import OOP.Binance.BinanceResponse;
import com.google.gson.annotations.SerializedName;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;

public class CollectionItem {
    @SerializedName("collectionId")
    private String collectionId;

    @SerializedName("coverUrl")
    private String coverUrl;

    @SerializedName("title")
    private String title;

    @SerializedName("network")
    private String network;

    @SerializedName("volume")
    private String volume;

    @SerializedName("volumeRate")
    private String volumeRate;

    @SerializedName("ownersCount")
    private int ownersCount;

    @SerializedName("itemsCount")
    private int itemsCount;

    @SerializedName("listedCount")
    private Integer listedCount; // Nullable

    @SerializedName("floorPrice")
    private String floorPrice;

    @SerializedName("floorPriceRate")
    private String floorPriceRate;

    @SerializedName("verified")
    private int verified;

    public String getCollectionId() {
        return collectionId;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getNetwork() {
        return network;
    }

    public String getVolume() {
        return volume;
    }

    public String getVolumeRate() {
        return volumeRate;
    }

    public int getOwnersCount() {
        return ownersCount;
    }

    public int getItemsCount() {
        return itemsCount;
    }

    public Integer getListedCount() {
        return listedCount;
    }

    public String getFloorPrice() {
        return floorPrice;
    }

    public String getFloorPriceRate() {
        return floorPriceRate;
    }

    public int getVerified() {
        return verified;
    }
}

