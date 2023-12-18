package models;

public class TodayNFTNews extends PostGeneral{
    private String title;
    private String imageUrl;
    public TodayNFTNews(String author, String date, String hashtag, String content, String title, String imageUrl) {
        super(author, date, hashtag, content);
        this.title = title;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
