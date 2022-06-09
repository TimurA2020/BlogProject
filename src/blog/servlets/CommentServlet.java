 package blog.servlets;

import blog.DB.DBConnector;
import blog.model.Blog;
import blog.model.Comment;
import blog.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/addcomment")
public class CommentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf8");

        User user = (User) req.getSession().getAttribute("Current_User");
        if(user!=null){
            String text = req.getParameter("comment");
            Comment comment = new Comment();
            comment.setUser(user);
            comment.setComment(text);
            Blog blog = DBConnector.getBlog(Integer.parseInt(req.getParameter("blog_id")));
            comment.setBlog(blog);
            DBConnector.addComment(comment);
            resp.sendRedirect("/readmore?id=" + Integer.parseInt(req.getParameter("blog_id")));
        }
        else{
            resp.sendRedirect("/login");
        }
    }
}
