package blog.servlets;

import blog.DB.DBConnector;
import blog.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String redirect = "/login?usererror";
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        ArrayList<User> allUsers = DBConnector.getAllUsers();

        HttpSession session = req.getSession();

        for (User u : allUsers){
            if(u.getEmail().equals(login) && u.getPassword().equals(password)){
                session.setAttribute("Current_User", u);
                System.out.println(u.getQuote());
                redirect = "/profile";
            }
        }



        resp.sendRedirect(redirect);
    }
}
