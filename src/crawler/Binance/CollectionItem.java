package OOP.Binance;
import com.google.gson.annotations.SerializedName;

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

