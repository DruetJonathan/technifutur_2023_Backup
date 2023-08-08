package technifutur.be.technifutur.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import technifutur.be.technifutur.models.entities.User;
import technifutur.be.technifutur.services.UserServiceImpl;

import java.io.IOException;

@WebServlet(name = "register" ,urlPatterns = "/register",loadOnStartup = 1)

public class RegisterServlet extends HttpServlet {
    public void init() {
        String connectionString = this.getServletContext().getInitParameter("CONNECTION_STRING");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("register","");
        request.getRequestDispatcher("pages/register.jsp").forward(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        //
        UserServiceImpl userService = new UserServiceImpl();
        User user = userService.register(new User(login,email,password));
        //
        if (user != null){
//            response.sendRedirect(request.getContextPath()+"/");
            response.sendRedirect(request.getContextPath() + "/");
        }
        else
            request.getRequestDispatcher("pages/register.jsp").forward(request,response);
    }
    public void destroy() {
    }
}
