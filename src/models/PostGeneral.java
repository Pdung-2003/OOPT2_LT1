package models;

public abstract class PostGeneral {
    private String author;
    private String date;
    private String hashtag;
    private String content;

    public PostGeneral(String author, String date, String hashtag, String content) {
        this.author = author;
        this.date = date;
        this.hashtag = hashtag;
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public String getDate() {
        return date;
    }

    public String getHashtag() {
        return hashtag;
    }

    public String getContent() {
        return content;
    }
}
