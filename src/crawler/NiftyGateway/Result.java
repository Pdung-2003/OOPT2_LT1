package OOP.NiftyGateway;

import OOP.NiftyGateway.Collection;
import com.google.gson.annotations.SerializedName;

public class Result {
    @SerializedName("collection")
    private Collection collection;

    @SerializedName("floorPrice")
    private float floorPrice; // Giả sử là số thực


    @SerializedName("oneDayTotalVolume")
    private float oneDayTotalVolume;

    @SerializedName("oneDayChange")
    private float oneDayChange;

    @SerializedName("sevenDayTotalVolume")
    private float sevenDayTotalVolume;

    @SerializedName("sevenDayChange")
    private float sevenDayChange;

    @SerializedName("thirtyDayTotalVolume")
    private float thirtyDayTotalVolume;

    @SerializedName("thirtyDayChange")
    private float thirtyDayChange;

    @SerializedName("totalVolume")
    private float totalVolume;

    @SerializedName("avgSalePrice")
    private float avgSalePrice;

    @SerializedName("totalPrimaryVolume")
    private String totalPrimaryVolume;

    @SerializedName("totalSecondaryVolume")
    private int totalSecondaryVolume;

    @SerializedName("oneDayNumSecondarySales")
    private int oneDayNumSecondarySales;

    @SerializedName("oneDayNumSecondarySalesChange")
    private float oneDayNumSecondarySalesChange;

    @SerializedName("oneDayNumTotalSales")
    private int oneDayNumTotalSales;

    @SerializedName("oneDayNumTotalSalesChange")
    private float oneDayNumTotalSalesChange;

    @SerializedName("sevenDayNumSecondarySales")
    private int sevenDayNumSecondarySales;

    @SerializedName("sevenDayNumSecondarySalesChange")
    private float sevenDayNumSecondarySalesChange;

    @SerializedName("sevenDayNumTotalSales")
    private int sevenDayNumTotalSales;

    @SerializedName("sevenDayNumTotalSalesChange")
    private float sevenDayNumTotalSalesChange;

    @SerializedName("thirtyDayNumSecondarySales")
    private int thirtyDayNumSecondarySales;

    @SerializedName("thirtyDayNumSecondarySalesChange")
    private float thirtyDayNumSecondarySalesChange;

    @SerializedName("thirtyDayNumTotalSales")
    private int thirtyDayNumTotalSales;

    @SerializedName("thirtyDayNumTotalSalesChange")
    private float thirtyDayNumTotalSalesChange;


    @SerializedName("totalNumSecondarySales")
    private int totalNumSecondarySales;

    @SerializedName("totalNumPrimarySales")
    private int totalNumPrimarySales;


    // Các getter và setter...


    // Các getter và setter cho các thuộc tính này
    // ...


    public Collection getCollection() {
        return collection;
    }

    public void setCollection(Collection collection) {
        this.collection = collection;
    }

    public float getFloorPrice() {
        return floorPrice;
    }

    public void setFloorPrice(float floorPrice) {
        this.floorPrice = floorPrice;
    }


    public float getOneDayTotalVolume() {
        return oneDayTotalVolume;
    }

    public void setOneDayTotalVolume(float oneDayTotalVolume) {
        this.oneDayTotalVolume = oneDayTotalVolume;
    }

    public float getOneDayChange() {
        return oneDayChange;
    }

    public void setOneDayChange(float oneDayChange) {
        this.oneDayChange = oneDayChange;
    }

    public float getSevenDayTotalVolume() {
        return sevenDayTotalVolume;
    }

    public void setSevenDayTotalVolume(float sevenDayTotalVolume) {
        this.sevenDayTotalVolume = sevenDayTotalVolume;
    }

    public float getSevenDayChange() {
        return sevenDayChange;
    }

    public void setSevenDayChange(float sevenDayChange) {
        this.sevenDayChange = sevenDayChange;
    }

    public float getThirtyDayTotalVolume() {
        return thirtyDayTotalVolume;
    }

    public void setThirtyDayTotalVolume(float thirtyDayTotalVolume) {
        this.thirtyDayTotalVolume = thirtyDayTotalVolume;
    }

    public float getThirtyDayChange() {
        return thirtyDayChange;
    }

    public void setThirtyDayChange(float thirtyDayChange) {
        this.thirtyDayChange = thirtyDayChange;
    }

    public float getTotalVolume() {
        return totalVolume;
    }

    public void setTotalVolume(float totalVolume) {
        this.totalVolume = totalVolume;
    }

    public float getAvgSalePrice() {
        return avgSalePrice;
    }

    public void setAvgSalePrice(float avgSalePrice) {
        this.avgSalePrice = avgSalePrice;
    }

    public String getTotalPrimaryVolume() {
        return totalPrimaryVolume;
    }

    public void setTotalPrimaryVolume(String totalPrimaryVolume) {
        this.totalPrimaryVolume = totalPrimaryVolume;
    }

    public int getTotalSecondaryVolume() {
        return totalSecondaryVolume;
    }

    public void setTotalSecondaryVolume(int totalSecondaryVolume) {
        this.totalSecondaryVolume = totalSecondaryVolume;
    }

    public int getOneDayNumSecondarySales() {
        return oneDayNumSecondarySales;
    }

    public void setOneDayNumSecondarySales(int oneDayNumSecondarySales) {
        this.oneDayNumSecondarySales = oneDayNumSecondarySales;
    }

    public float getOneDayNumSecondarySalesChange() {
        return oneDayNumSecondarySalesChange;
    }

    public void setOneDayNumSecondarySalesChange(float oneDayNumSecondarySalesChange) {
        this.oneDayNumSecondarySalesChange = oneDayNumSecondarySalesChange;
    }

    public int getOneDayNumTotalSales() {
        return oneDayNumTotalSales;
    }

    public void setOneDayNumTotalSales(int oneDayNumTotalSales) {
        this.oneDayNumTotalSales = oneDayNumTotalSales;
    }

    public float getOneDayNumTotalSalesChange() {
        return oneDayNumTotalSalesChange;
    }

    public void setOneDayNumTotalSalesChange(float oneDayNumTotalSalesChange) {
        this.oneDayNumTotalSalesChange = oneDayNumTotalSalesChange;
    }

    public int getSevenDayNumSecondarySales() {
        return sevenDayNumSecondarySales;
    }

    public void setSevenDayNumSecondarySales(int sevenDayNumSecondarySales) {
        this.sevenDayNumSecondarySales = sevenDayNumSecondarySales;
    }

    public float getSevenDayNumSecondarySalesChange() {
        return sevenDayNumSecondarySalesChange;
    }

    public void setSevenDayNumSecondarySalesChange(float sevenDayNumSecondarySalesChange) {
        this.sevenDayNumSecondarySalesChange = sevenDayNumSecondarySalesChange;
    }

    public int getSevenDayNumTotalSales() {
        return sevenDayNumTotalSales;
    }

    public void setSevenDayNumTotalSales(int sevenDayNumTotalSales) {
        this.sevenDayNumTotalSales = sevenDayNumTotalSales;
    }

    public float getSevenDayNumTotalSalesChange() {
        return sevenDayNumTotalSalesChange;
    }

    public void setSevenDayNumTotalSalesChange(float sevenDayNumTotalSalesChange) {
        this.sevenDayNumTotalSalesChange = sevenDayNumTotalSalesChange;
    }

    public int getThirtyDayNumSecondarySales() {
        return thirtyDayNumSecondarySales;
    }

    public void setThirtyDayNumSecondarySales(int thirtyDayNumSecondarySales) {
        this.thirtyDayNumSecondarySales = thirtyDayNumSecondarySales;
    }

    public float getThirtyDayNumSecondarySalesChange() {
        return thirtyDayNumSecondarySalesChange;
    }

    public void setThirtyDayNumSecondarySalesChange(float thirtyDayNumSecondarySalesChange) {
        this.thirtyDayNumSecondarySalesChange = thirtyDayNumSecondarySalesChange;
    }

    public int getThirtyDayNumTotalSales() {
        return thirtyDayNumTotalSales;
    }

    public void setThirtyDayNumTotalSales(int thirtyDayNumTotalSales) {
        this.thirtyDayNumTotalSales = thirtyDayNumTotalSales;
    }

    public float getThirtyDayNumTotalSalesChange() {
        return thirtyDayNumTotalSalesChange;
    }

    public void setThirtyDayNumTotalSalesChange(float thirtyDayNumTotalSalesChange) {
        this.thirtyDayNumTotalSalesChange = thirtyDayNumTotalSalesChange;
    }

    public int getTotalNumSecondarySales() {
        return totalNumSecondarySales;
    }

    public void setTotalNumSecondarySales(int totalNumSecondarySales) {
        this.totalNumSecondarySales = totalNumSecondarySales;
    }

    public int getTotalNumPrimarySales() {
        return totalNumPrimarySales;
    }

    public void setTotalNumPrimarySales(int totalNumPrimarySales) {
        this.totalNumPrimarySales = totalNumPrimarySales;
    }
}
