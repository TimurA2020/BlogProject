package blog.model;

public class Post {
    int id;
    String title;
    String post;

    public Post() {
    }

    public Post(int id, String title, String post) {
        this.id = id;
        this.title = title;
        this.post = post;
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

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }
}
