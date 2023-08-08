package com.babiarzdruet.labojavadataweb.servlets;

import java.io.*;
import java.util.List;

import com.babiarzdruet.labojavadataweb.models.entities.RequestCoaching;
import com.babiarzdruet.labojavadataweb.services.impl.RequestCoachingServiceImpl;
import jakarta.inject.Inject;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "index", value = "/index", loadOnStartup = 1)
public class HelloServlet extends HttpServlet {
    private String message;

    RequestCoachingServiceImpl requestCoachingService;
    public void init() {
//        System.out.println("ok");
//        ServletContext servletContext = this.getServletConfig().getServletContext();
//        List<RequestCoaching> requestCoachingList = requestCoachingService.getAll();
//        servletContext.setAttribute("requestCoachingList",requestCoachingList);
//        servletContext.getRequestDispatcher("/index.jsp");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

///**/        request.getRequestDispatcher("index.jsp").forward(request,response);
//        request.getRequestDispatcher("WEB-INF/pages/loginForm.jsp").forward(request,response);

    }

    public void destroy() {
    }
}