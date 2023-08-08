package com.babiarzdruet.labojavadataweb.servlets;

import com.babiarzdruet.labojavadataweb.models.entities.Game;
import com.babiarzdruet.labojavadataweb.services.GameService;
import com.babiarzdruet.labojavadataweb.services.impl.GameServiceImpl;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/gameForm", name = "gameForm",loadOnStartup = 1)
public class GameServlet extends HttpServlet {

    @Inject
    GameService gameService;
    @Override
    public void init() {

    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Game> gameList = gameService.getAll();
        request.setAttribute("gameList",gameList);
        request.getRequestDispatcher("WEB-INF/pages/gameForm.jsp").forward(request,response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name,idGame;
        Game game;
        List<Game> gameList;
        switch (request.getParameter("typeOfForm")){
            case "create":
                name = request.getParameter("name");
                if (!name.isBlank()) {
                    game = new Game(name);
                    gameService.add(game);
                }else{
                    gameList = gameService.getAll();
                    request.setAttribute("gameList",gameList);
                    request.setAttribute("nameError","Failed during the creation");
                    request.getRequestDispatcher("WEB-INF/pages/gameForm.jsp").forward(request,response);
                }
                break;
            case "update":
                idGame = request.getParameter("idGame");
                String nameModify = request.getParameter("nameModify");
                if (!nameModify.isBlank()){
                    try{
                        game = gameService.getOne(Long.valueOf(idGame));
                        game.setName(nameModify);
                        gameService.update(game);
                    }catch (RuntimeException e){
                        request.setAttribute("nameErrorModify","Failed during the modification");
                        request.getRequestDispatcher("WEB-INF/pages/gameForm.jsp").forward(request,response);
                    }
                }
                else{
                    gameList = gameService.getAll();
                    request.setAttribute("gameList",gameList);
                    request.setAttribute("nameErrorModify","Failed during the modification");
                    request.getRequestDispatcher("WEB-INF/pages/gameForm.jsp").forward(request,response);
                }
                break;
            case "delete":
                try{
                    idGame = request.getParameter("idGame");
                    if (idGame != null)
                        gameService.delete(Long.valueOf(idGame));
//                    gameList = gameService.getAll();
//                    request.setAttribute("gameList",gameList);
                }catch (RuntimeException e){
                    gameList = gameService.getAll();
                    request.setAttribute("gameList",gameList);
                    request.setAttribute("nameErrorDelete","Failed during the delete");
                    request.getRequestDispatcher("WEB-INF/pages/gameForm.jsp").forward(request,response);
                }
                break;
        }
        gameList = gameService.getAll();
        request.setAttribute("gameList",gameList);
        request.getRequestDispatcher("WEB-INF/pages/gameForm.jsp").forward(request,response);

    }

    @Override
    public void destroy() {

    }
}