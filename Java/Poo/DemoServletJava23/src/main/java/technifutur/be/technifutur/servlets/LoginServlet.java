package technifutur.be.technifutur.servlets;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import technifutur.be.technifutur.models.entities.User;
import technifutur.be.technifutur.models.entities.UserSimplify;
import technifutur.be.technifutur.repositories.UserRepositoryImpl;
import technifutur.be.technifutur.services.UserServiceImpl;

@WebServlet(name = "login" ,urlPatterns = "/login",loadOnStartup = 1)
public class LoginServlet extends HttpServlet {
    public void init() {
        String connectionString = this.getServletContext().getInitParameter("CONNECTION_STRING");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("login","");
        request.getRequestDispatcher("pages/login.jsp").forward(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        // get session
        HttpSession session = request.getSession(true);
        //stockage session
        session.setAttribute("user",new UserSimplify(login,email));
        //tmp
        //request.setAttribute("login",login);
        //
        UserServiceImpl userService = new UserServiceImpl();
        User user = userService.login(login,password);
        //
        if (user != null){
//            response.sendRedirect(request.getContextPath()+"/");
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
        else
            request.getRequestDispatcher("pages/login.jsp").forward(request,response);
    }
    public void destroy() {
    }
}