package com.babiarzdruet.labojavadataweb.servlets;

import com.babiarzdruet.labojavadataweb.models.entities.*;
import com.babiarzdruet.labojavadataweb.models.forms.UserForm;
import com.babiarzdruet.labojavadataweb.services.GameService;
import com.babiarzdruet.labojavadataweb.services.impl.GameServiceImpl;
import com.babiarzdruet.labojavadataweb.services.impl.RequestCoachingServiceImpl;
import com.babiarzdruet.labojavadataweb.services.impl.UserServiceImpl;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "requestCoachingForm", urlPatterns = "/requestCoachingForm")
public class RequestCoachingServlet extends HttpServlet {

    @Inject
    GameServiceImpl gameService;

    @Inject
    UserServiceImpl userService;
    @Inject
    RequestCoachingServiceImpl requestCoachingService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("OKKKKKKKKKKKKKK");
//        List<RequestCoaching> requestCoachingList = requestCoachingService.getAll();
//        setAttribute("requestCoachingList","requestCoachingList");

    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Game> gameList = gameService.getAll();
        List<User> userList = userService.getAll();
        request.setAttribute("gameList", gameList);
        request.setAttribute("userList", userList);
        request.getRequestDispatcher("WEB-INF/pages/requestCoachingForm.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name, description, image;
        Integer price;
        Game game;
        User user;
        List<Game> gameList;
        List<User> userList;
        RequestCoaching requestCoaching;
        List<RequestCoaching> requestCoachings;
        Long id;

        switch (request.getParameter("typeOfForm")) {
            case "create":
                try {
                    name = request.getParameter("name");
                    description = request.getParameter("description");
                    price = Integer.parseInt(request.getParameter("price"));
                    user = userService.getOne(Long.valueOf(request.getParameter("idUserForm")));
                    image = user.getProfileImage();
                    game = gameService.getOne(Long.valueOf(request.getParameter("idGame")));
                    if (!name.isBlank() && !description.isBlank() && (price != null && price >= 0) && !image.isBlank()
                            && game != null && user != null && description.length() <= 250) {
                        requestCoaching = new RequestCoaching(name,description,price,image,game,user);
                        requestCoachingService.add(requestCoaching);
                        // add le role de coach
                        boolean add = true;
                        for (Role role :
                                user.getRoles()) {
                            if(role.getName().equals("Coach"))
                                add =false;
                        }
                        if(add) {
                            user.addRole(new Role(3L, "Coach"));
                            userService.update(user);
                        }
                    } else {
                        gameList = gameService.getAll();
                        userList = userService.getAll();
                        request.setAttribute("gameList", gameList);
                        request.setAttribute("userList", userList);
                        request.setAttribute("errorCreate","Failed during the creation");
                        request.getRequestDispatcher("WEB-INF/pages/requestCoachingForm.jsp").forward(request, response);
                    }
                }catch (RuntimeException e){
                    gameList = gameService.getAll();
                    userList = userService.getAll();
                    request.setAttribute("gameList", gameList);
                    request.setAttribute("userList", userList);
                    request.setAttribute("errorCreate","Failed during the creation");
                    request.getRequestDispatcher("WEB-INF/pages/requestCoachingForm.jsp").forward(request, response);
                }
                requestCoachings = requestCoachingService.getAll();
                gameList = gameService.getAll();
                userList = userService.getAll();
                request.setAttribute("gameList", gameList);
                request.setAttribute("userList", userList);
                request.setAttribute("requestCoachingsList", requestCoachings);
                request.getServletContext().setAttribute("requestCoachingList",requestCoachingService.getAll());
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
            case "pending":
                id = Long.valueOf(request.getParameter("id"));
                requestCoachings = requestCoachingService.getAll();
                gameList = gameService.getAll();
                userList = userService.getAll();
                request.setAttribute("gameList", gameList);
                request.setAttribute("userList", userList);
                RequestCoaching one = requestCoachingService.getOne(id);
                one.setPending(false);
                requestCoachingService.update(one);
                request.getServletContext().setAttribute("requestCoachingList",requestCoachingService.getAll());
                request.getRequestDispatcher("WEB-INF/pages/requestCoachingForm.jsp").forward(request, response);
                break;
                case "delete":
                try{
                    String id1 = request.getParameter("id");
                    if (id1 != null)
                        requestCoachingService.delete(Long.valueOf(id1));
//                    gameList = gameService.getAll();
//                    request.setAttribute("gameList",gameList);
                    requestCoachings = requestCoachingService.getAll();
                    gameList = gameService.getAll();
                    userList = userService.getAll();
                    request.setAttribute("gameList", gameList);
                    request.setAttribute("userList", userList);
                    request.setAttribute("requestCoachingsList", requestCoachings);
                    request.getServletContext().setAttribute("requestCoachingList",requestCoachingService.getAll());
                    request.getRequestDispatcher("WEB-INF/pages/requestCoachingForm.jsp").forward(request,response);
                }catch (RuntimeException e){
                    requestCoachings = requestCoachingService.getAll();
                    request.setAttribute("requestCoachingsList", requestCoachings);
                    request.getServletContext().setAttribute("requestCoachingList",requestCoachingService.getAll());
                    gameList = gameService.getAll();
                    userList = userService.getAll();
                    request.setAttribute("gameList", gameList);
                    request.setAttribute("userList", userList);
                    request.setAttribute("nameErrorDelete","Failed during the delete");
                    request.getRequestDispatcher("WEB-INF/pages/requestCoachingForm.jsp").forward(request,response);
                }
                    requestCoachings = requestCoachingService.getAll();
                    request.setAttribute("requestCoachingsList", requestCoachings);
                break;
            case "rent":
                id = Long.valueOf(request.getParameter("id"));
                //
                HttpSession session = request.getSession(true);
                Long iduser = (Long) session.getAttribute("idUser");
                User userTmp = userService.getOne(iduser);
                userTmp.addRequestCoaching(requestCoachingService.getOne(id));
                userService.update(userTmp);
                //
                requestCoachings = requestCoachingService.getAll();
                request.setAttribute("requestCoachingsList", requestCoachings);
                request.getServletContext().setAttribute("requestCoachingList",requestCoachingService.getAll());
                request.getRequestDispatcher("index.jsp").forward(request, response);

                break;
        }
    }
    @Override
    public void destroy() {

    }
}