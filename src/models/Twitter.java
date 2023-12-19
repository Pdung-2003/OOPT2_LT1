package models;

import java.util.ArrayList;
import java.util.List;

public class Twitter extends PostGeneral{
    private List<String> images;
    private String userId;
    public Twitter(String author, String date, String content, String userId, List<String> images) {
        super(author, date, content);
        this.userId = userId;
        this.images = images;
    }

    public List<String> getImages() {
        return images;
    }

    public String getUserId() {
        return userId;
    }
}
