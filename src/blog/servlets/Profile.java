package blog.servlets;

import blog.DB.DBConnector;
import blog.model.Blog;
import blog.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/profile")
public class Profile extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("Current_User");
        if(user!=null){
            req.setAttribute("currentUser", user);
            ArrayList<Blog> blogs = DBConnector.getAllBlogsByUser(user);
            req.setAttribute("blogs", blogs);
            req.getRequestDispatcher("/profile.jsp").forward(req, resp);
        }
        else{
            resp.sendRedirect("/login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
