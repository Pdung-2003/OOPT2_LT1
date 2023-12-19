package models;

public class CollectionNFTGateway {
    private String niftyTitle;
    private int niftyType;
    private String niftyDisplayImage;

    public CollectionNFTGateway(String niftyTitle, int niftyType, String niftyDisplayImage) {
        this.niftyTitle = niftyTitle;
        this.niftyType = niftyType;
        this.niftyDisplayImage = niftyDisplayImage;
    }

    public String getNiftyTitle() {
        return niftyTitle;
    }

    public int getNiftyType() {
        return niftyType;
    }

    public String getNiftyDisplayImage() {
        return niftyDisplayImage;
    }
}
