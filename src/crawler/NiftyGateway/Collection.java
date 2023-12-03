package OOP;

import com.google.gson.annotations.SerializedName;

public class Collection {
    @SerializedName("niftyTitle")
    private String niftyTitle;

    @SerializedName("niftyType")
    private int niftyType;

    @SerializedName("niftyContractAddress")
    private String niftyContractAddress;

    @SerializedName("niftyDisplayImage")
    private String niftyDisplayImage;

    @SerializedName("totalSupply")
    private int totalSupply;

    @SerializedName("numOwners")
    private int numOwners;
    @SerializedName("totalMarketCap")
    private String totalMarketCap;

    @SerializedName("totalNumTotalSales")
    private int totalNumTotalSales;


    // Các getter và setter cho các thuộc tính này
    // ...

    public Collection(String niftyTitle, int niftyType, String niftyContractAddress, String niftyDisplayImage) {
        this.niftyTitle = niftyTitle;
        this.niftyType = niftyType;
        this.niftyContractAddress = niftyContractAddress;
        this.niftyDisplayImage = niftyDisplayImage;
    }

    public String getNiftyTitle() {
        return niftyTitle;
    }

    public void setNiftyTitle(String niftyTitle) {
        this.niftyTitle = niftyTitle;
    }

    public int getNiftyType() {
        return niftyType;
    }

    public void setNiftyType(int niftyType) {
        this.niftyType = niftyType;
    }

    public String getNiftyContractAddress() {
        return niftyContractAddress;
    }

    public void setNiftyContractAddress(String niftyContractAddress) {
        this.niftyContractAddress = niftyContractAddress;
    }

    public String getNiftyDisplayImage() {
        return niftyDisplayImage;
    }

    public void setNiftyDisplayImage(String niftyDisplayImage) {
        this.niftyDisplayImage = niftyDisplayImage;
    }

    public String getTotalMarketCap() {
        return totalMarketCap;
    }

    public void setTotalMarketCap(String totalMarketCap) {
        this.totalMarketCap = totalMarketCap;
    }

    public int getTotalNumTotalSales() {
        return totalNumTotalSales;
    }

    public void setTotalNumTotalSales(int totalNumTotalSales) {
        this.totalNumTotalSales = totalNumTotalSales;
    }

    public int getTotalSupply() {
        return totalSupply;
    }

    public void setTotalSupply(int totalSupply) {
        this.totalSupply = totalSupply;
    }

    public int getNumOwners() {
        return numOwners;
    }

    public void setNumOwners(int numOwners) {
        this.numOwners = numOwners;
    }
}
