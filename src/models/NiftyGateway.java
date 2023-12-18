package models;

public class NiftyGateway extends NFTGeneral{
    private int niftyType;
    private float avgSalePrice;
    private int totalNumPrimarySales;

    public NiftyGateway(String title, String volume, String floorPrice, String image, int niftyType, float avgSalePrice, int totalNumPrimarySales) {
        super(title, volume, floorPrice, image);
        this.niftyType = niftyType;
        this.avgSalePrice = avgSalePrice;
        this.totalNumPrimarySales = totalNumPrimarySales;
    }

    public int getNiftyType() {
        return niftyType;
    }

    public float getAvgSalePrice() {
        return avgSalePrice;
    }

    public int getTotalNumPrimarySales() {
        return totalNumPrimarySales;
    }
}
