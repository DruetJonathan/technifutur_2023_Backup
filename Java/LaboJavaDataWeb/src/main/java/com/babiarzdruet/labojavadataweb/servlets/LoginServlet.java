package com.babiarzdruet.labojavadataweb.servlets;

import com.babiarzdruet.labojavadataweb.exceptions.LoginException;
import com.babiarzdruet.labojavadataweb.exceptions.PasswordException;
import com.babiarzdruet.labojavadataweb.models.entities.Role;
import com.babiarzdruet.labojavadataweb.models.entities.User;
import com.babiarzdruet.labojavadataweb.models.entities.UserSimplify;
import com.babiarzdruet.labojavadataweb.services.UserService;
import com.babiarzdruet.labojavadataweb.services.impl.UserServiceImpl;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;

@WebServlet(urlPatterns = "/loginForm", name = "loginForm")
public class LoginServlet extends HttpServlet {
    @Inject
    UserService userService;
    @Override
    public void init() {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gameprodigy");
//        EntityManager em = emf.createEntityManager();
//        Role userRole = new Role("User");
//        Role adminRole = new Role("Admin");
//        Role coachRole = new Role("Coach");
//        em.getTransaction().begin();
//        em.persist(userRole);
//        em.persist(adminRole);
//        em.persist(coachRole);
//        em.getTransaction().commit();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        HttpSession session = request.getSession(true);
//        User useratt = (User) request.getAttribute("user");
//        if (useratt != null){
//            session.setAttribute("user",new UserSimplify(useratt.getFirstname(), useratt.getEmail()));
//            request.getRequestDispatcher("index.jsp").forward(request,response);
//        }//            request.getRequestDispatcher("index.jsp").forward(request,response);
//        response.sendRedirect(request.getContextPath() + "/loginForm");
//        response.sendRedirect(request.getContextPath() + "/loginForm");
            request.getRequestDispatcher("WEB-INF/pages/loginForm.jsp").forward(request,response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        String firstname = request.getParameter("firstname");
        String password = request.getParameter("password");
//        password = BCrypt.hashpw(password, BCrypt.gensalt());

        String email = request.getParameter("email");


        try {
            User user = userService.login(email, password);
            HttpSession session = request.getSession(true);
            session.setAttribute("user",new UserSimplify(email,user.getRoles()));
            session.setAttribute("idUser",user.getId());
        }

        catch (LoginException | PasswordException e){
            request.setAttribute("loginError","Login or Password invalid !");
            request.getRequestDispatcher("WEB-INF/pages/loginForm.jsp").forward(request,response);
        }
        request.getRequestDispatcher("index.jsp").forward(request,response);
//        if (user != null){
////            response.sendRedirect(request.getContextPath()+"/");
//            request.getRequestDispatcher("index.jsp").forward(request,response);
//        }
//        else{
//            request.setAttribute("loginError","Account not found");
//            request.getRequestDispatcher("WEB-INF/pages/loginForm.jsp").forward(request,response);
//        }
    }

    @Override
    public void destroy() {

    }
}