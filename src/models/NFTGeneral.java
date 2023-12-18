package models;

public abstract class NFTGeneral {
    private String title;
    private String volume;
    private String floorPrice;
    private String image;

    public NFTGeneral(String title, String volume, String floorPrice, String image) {
        this.title = title;
        this.volume = volume;
        this.floorPrice = floorPrice;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public String getVolume() {
        return volume;
    }

    public String getFloorPrice() {
        return floorPrice;
    }

    public String getImage() {
        return image;
    }
}
