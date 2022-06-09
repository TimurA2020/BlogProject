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

@WebServlet(value = "/addblog")
public class AddBlogServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("Current_User");
        if(user!=null){
            req.setAttribute("currentUser", user);
            req.getRequestDispatcher("/addblog.jsp").forward(req, resp);
        }
        else{
            resp.sendRedirect("/login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("Current_User");
        if(user!=null){
            Blog blog = new Blog();
            String title = req.getParameter("title");
            String content = req.getParameter("content");
            blog.setTitle(title);
            blog.setContent(content);
            blog.setUser(user);

            DBConnector.addBlog(blog);
            resp.sendRedirect("/profile");
        }
        else{
            resp.sendRedirect("/login");
        }
    }
}
