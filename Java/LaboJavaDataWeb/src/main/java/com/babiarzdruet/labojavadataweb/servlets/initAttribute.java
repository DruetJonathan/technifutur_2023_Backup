package com.babiarzdruet.labojavadataweb.servlets;

import com.babiarzdruet.labojavadataweb.models.entities.RequestCoaching;
import com.babiarzdruet.labojavadataweb.services.RequestCoachingService;
import com.babiarzdruet.labojavadataweb.services.impl.RequestCoachingServiceImpl;
import jakarta.inject.Inject;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.http.HttpServlet;

import java.util.List;

public class initAttribute implements ServletContextListener {
    RequestCoachingService requestCoachingService = new RequestCoachingServiceImpl();
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        List<RequestCoaching> requestCoachingList = requestCoachingService.getAll();
        context.setAttribute("requestCoachingList", requestCoachingList);
    }
}
