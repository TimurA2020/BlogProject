package blog.model;

import java.sql.Timestamp;

public class Blog {
    private int id;
    private User user;
    private String title;
    private String content;

    private Timestamp postdate;

    public Blog() {
    }

    public Blog(int id, User user, String title, String content, Timestamp postdate) {
        this.id = id;
        this.user = user;
        this.title = title;
        this.content = content;
        this.postdate = postdate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Timestamp getPostdate() {
        return postdate;
    }

    public void setPostdate(Timestamp postdate) {
        this.postdate = postdate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
