package blog.servlets;

import blog.DB.DBConnector;
import blog.model.Blog;
import blog.model.Post;
import blog.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/home")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("Current_User");
        ArrayList<Blog> blogs = DBConnector.getAllBlogs();
        req.setAttribute("blogs", blogs);
        if(user!=null){
            req.setAttribute("currentUser", user);
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
