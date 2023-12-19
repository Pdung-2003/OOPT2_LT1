package models;

public class Binance extends NFTGeneral{
    private String collectionId;
    private int ownersCount;
    private int itemsCount;
    private float floorPriceRate;
    private String coverUrl;

    public Binance(String title, String volume, String floorPrice, String image, String collectionId, int ownersCount, int itemsCount, float floorPriceRate, String coverUrl) {
        super(title, volume, floorPrice, image);
        this.collectionId = collectionId;
        this.ownersCount = ownersCount;
        this.itemsCount = itemsCount;
        this.floorPriceRate = floorPriceRate;
        this.coverUrl = coverUrl;
    }

    public String getCollectionId() {
        return collectionId;
    }

    public int getOwnersCount() {
        return ownersCount;
    }

    public int getItemsCount() {
        return itemsCount;
    }

    public float getFloorPriceRate() {
        return floorPriceRate;
    }

    public String getCoverUrl() { return coverUrl; }
}
