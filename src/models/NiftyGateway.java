package models;

public class NiftyGateway extends NFTGeneral{
    private float avgSalePrice;
    private int totalNumPrimarySales;
    private String totalVolume;
    private CollectionNFTGateway collection;

    public NiftyGateway(String totalVolume, String floorPrice, float avgSalePrice, int totalNumPrimarySales, CollectionNFTGateway collections) {
        super(floorPrice);
        this.totalVolume = totalVolume;
        this.avgSalePrice = avgSalePrice;
        this.totalNumPrimarySales = totalNumPrimarySales;
        this.collection = collection;
    }

    public float getAvgSalePrice() {
        return avgSalePrice;
    }

    public int getTotalNumPrimarySales() {
        return totalNumPrimarySales;
    }

    public String getTotalVolume() {
        return totalVolume;
    }

    public CollectionNFTGateway getCollection() {
        return collection;
    }
}
