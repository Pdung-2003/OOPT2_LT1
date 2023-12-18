package models;

import java.util.ArrayList;
import java.util.List;

public class Twitter extends PostGeneral{
    private List<String> images;
    private String userId;
    public Twitter(String author, String date, String hashtag, String content, String userId) {
        super(author, date, hashtag, content);
        this.userId = userId;
        this.images = new ArrayList<>();
    }

    public List<String> getImages() {
        return images;
    }

    public String getUserId() {
        return userId;
    }
}
