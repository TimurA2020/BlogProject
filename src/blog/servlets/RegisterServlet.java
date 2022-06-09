package blog.servlets;

import blog.DB.DBConnector;
import blog.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String redirect = "";
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String password2 = req.getParameter("password2");
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String quote = req.getParameter("quote");
        String profilepicture = req.getParameter("picture");

        User user = new User();
        user = DBConnector.getUser(email);

        if(user!=null) {
            redirect = "/register?usererror";
        }
        if(user==null){
            redirect = "/register?passworderror";
            if (password.equals(password2)){
                User RegistrationUser = new User();
                RegistrationUser.setEmail(email);
                RegistrationUser.setPassword(password);
                RegistrationUser.setQuote(quote);
                RegistrationUser.setSurname(surname);
                RegistrationUser.setProfilePicture(profilepicture);
                RegistrationUser.setName(name);
                DBConnector.addUser(RegistrationUser);
                redirect = "/register?success";
            }
        }
        resp.sendRedirect(redirect);
    }
}
