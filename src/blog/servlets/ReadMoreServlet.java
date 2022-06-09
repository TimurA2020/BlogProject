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
import java.util.ArrayList;

@WebServlet(value = "/readmore")
public class ReadMoreServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("Current_User");
        if(user!=null){
            req.setAttribute("currentUser", user);
        }
        int id = Integer.parseInt(req.getParameter("id"));
        Blog blog = DBConnector.getBlog(id);

        if(blog!=null){
            ArrayList<Comment> comments = DBConnector.getAllComments(id);
            req.setAttribute("comments", comments);
        }

        req.setAttribute("blog", blog);
        req.getRequestDispatcher("/readmore.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }
}
