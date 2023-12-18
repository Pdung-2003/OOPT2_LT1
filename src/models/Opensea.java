package models;

public class Opensea extends NFTGeneral{
    private String discount;
    private String sales;
    public Opensea(String title, String volume, String floorPrice, String image, String discount, String sales) {
        super(title, volume, floorPrice, image);
        this.discount = discount;
        this.sales = sales;
    }

    public String getDiscount() {
        return discount;
    }

    public String getSales() {
        return sales;
    }
}
