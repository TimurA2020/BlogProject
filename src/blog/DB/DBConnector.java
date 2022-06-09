package blog.DB;

import blog.model.Blog;
import blog.model.Comment;
import blog.model.Post;
import blog.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBConnector {
    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("" +
                    "jdbc:postgresql://localhost:5432/posts", "postgres", "falcon");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Post> getAllPosts(){
        ArrayList<Post> allPosts = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM table_name");
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                Post post = new Post();
                post.setId(resultSet.getInt("id"));
                post.setTitle(resultSet.getString("title"));
                post.setPost(resultSet.getString("post"));

                allPosts.add(post);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return allPosts;
    }

    public static ArrayList<User> getAllUsers(){
        ArrayList<User> allUsers = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM users");
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setName(resultSet.getString("firstname"));
                user.setSurname(resultSet.getString("surname"));
                user.setProfilePicture(resultSet.getString("profilepicture"));
                user.setQuote(resultSet.getString("quote"));

                allUsers.add(user);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return allUsers;
    }

    public static User getUser(String email){

        User user = null;

        try{

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE email = ? LIMIT 1");
            statement.setString(1, email);

            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setName(resultSet.getString("firstname"));
                user.setSurname(resultSet.getString("surname"));
                user.setProfilePicture(resultSet.getString("profilepicture"));
                user.setQuote(resultSet.getString("quote"));
            }

            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }

    public static void addUser(User user){

        try{

            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO users (email, password, firstname, surname, profilepicture, quote) " +
                    "VALUES (?, ?, ?, ?, ?, ?)");

            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getName());
            statement.setString(4, user.getSurname());
            statement.setString(5, user.getProfilePicture());
            statement.setString(6, user.getQuote());

            statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void addBlog(Blog blog){

        try{

            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO blog (user_id, title, content, postdate) " +
                    "VALUES (?, ?, ?, NOW())");

            statement.setInt(1, blog.getUser().getId());
            statement.setString(2, blog.getTitle());
            statement.setString(3, blog.getContent());

            statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static ArrayList<Blog> getAllBlogs(){
        ArrayList<Blog> blogs = new ArrayList<>();
        try{

            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT b.id, b.title, b.content, b.postdate, b.user_id, u.firstname, u.surname, u.email, u.profilepicture " +
                    "FROM blog b " +
                    "INNER JOIN users u ON u.id = b.user_id " +
                    "ORDER BY b.postdate DESC ");

            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){

                Blog blog = new Blog();
                blog.setContent(resultSet.getString("content"));
                blog.setTitle(resultSet.getString("title"));
                blog.setPostdate(resultSet.getTimestamp("postdate"));
                blog.setId(resultSet.getInt("id"));

                User user = new User();
                user.setId(resultSet.getInt("user_id"));
                user.setName(resultSet.getString("firstname"));
                user.setSurname(resultSet.getString("surname"));
                user.setEmail(resultSet.getString("email"));
                user.setProfilePicture(resultSet.getString("profilepicture"));

                blog.setUser(user);
                blogs.add(blog);

            }
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return blogs;
    }

    public static ArrayList<Blog> getAllBlogsByUser(User user1){
        ArrayList<Blog> blogs = new ArrayList<>();
        try{

            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT b.id, b.title, b.content, b.postdate, b.user_id, u.firstname, u.surname, u.email, u.profilepicture " +
                    "FROM blog b " +
                    "INNER JOIN users u ON u.id = b.user_id WHERE user_id = ? " +
                    "ORDER BY b.postdate DESC ");
            statement.setInt(1, user1.getId());

            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){

                Blog blog = new Blog();
                blog.setContent(resultSet.getString("content"));
                blog.setTitle(resultSet.getString("title"));
                blog.setPostdate(resultSet.getTimestamp("postdate"));
                blog.setId(resultSet.getInt("id"));

                User user = new User();
                user.setId(resultSet.getInt("user_id"));
                user.setName(resultSet.getString("firstname"));
                user.setSurname(resultSet.getString("surname"));
                user.setEmail(resultSet.getString("email"));
                user.setProfilePicture(resultSet.getString("profilepicture"));

                blog.setUser(user);
                blogs.add(blog);

            }
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return blogs;
    }

    public static Blog getBlog(int id){
        Blog blog = null;

        try{

            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT b.id, b.title, b.content, b.postdate, b.user_id, u.firstname, u.surname, u.email, u.profilepicture " +
                    "FROM blog b " +
                    "INNER JOIN users u ON u.id = b.user_id " +
                    "WHERE b.id = ?");

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                blog = new Blog();
                blog.setContent(resultSet.getString("content"));
                blog.setTitle(resultSet.getString("title"));
                blog.setPostdate(resultSet.getTimestamp("postdate"));
                blog.setId(resultSet.getInt("id"));

                User user = new User();
                user.setId(resultSet.getInt("user_id"));
                user.setName(resultSet.getString("firstname"));
                user.setSurname(resultSet.getString("surname"));
                user.setEmail(resultSet.getString("email"));
                user.setProfilePicture(resultSet.getString("profilepicture"));

                blog.setUser(user);
            }
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return blog;
    }

    public static void addComment(Comment comment){

        try{

            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO comments (user_id, blog_id, comment, postdate) " +
                    "VALUES (?, ?, ?, NOW())");

            statement.setLong(1, comment.getUser().getId());
            statement.setLong(2, comment.getBlog().getId());
            statement.setString(3, comment.getComment());

            statement.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static ArrayList<Comment> getAllComments(int id){

        ArrayList<Comment> comments = new ArrayList<>();

        try{

            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT c.id, c.comment, c.user_id, c.blog_id, c.postdate, u.firstname, u.surname, u.profilepicture " +
                    "FROM comments c " +
                    "INNER JOIN users u ON u.id = c.user_id " +
                    "WHERE c.blog_id = ? " +
                    "ORDER BY c.postdate DESC ");

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){

                Comment comment = new Comment();
                comment.setId(resultSet.getInt("id"));
                comment.setComment(resultSet.getString("comment"));
                comment.setPostdate(resultSet.getTimestamp("postdate"));

                Blog blog = new Blog();
                blog.setId(resultSet.getInt("blog_id"));
                comment.setBlog(blog);

                User user = new User();
                user.setId(resultSet.getInt("user_id"));
                user.setName(resultSet.getString("firstname"));
                user.setSurname(resultSet.getString("surname"));
                user.setProfilePicture(resultSet.getString("profilepicture"));

                comment.setUser(user);
                comments.add(comment);

            }
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return comments;

    }
}
