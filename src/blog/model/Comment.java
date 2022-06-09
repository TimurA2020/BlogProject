package blog.model;

import java.sql.Timestamp;

public class Comment {
    int id;
    User user;
    Blog blog;
    String comment;
    Timestamp postdate;

    public Comment() {
    }

    public Comment(int id, User user, Blog blog, String comment, Timestamp postdate) {
        this.id = id;
        this.user = user;
        this.blog = blog;
        this.comment = comment;
        this.postdate = postdate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Timestamp getPostdate() {
        return postdate;
    }

    public void setPostdate(Timestamp postdate) {
        this.postdate = postdate;
    }
}
