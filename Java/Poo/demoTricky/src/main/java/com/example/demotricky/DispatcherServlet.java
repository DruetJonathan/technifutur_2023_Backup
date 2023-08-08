package com.example.demotricky;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.rmi.server.ServerCloneException;
import java.util.List;
import java.util.Map;

import com.example.demotricky.di.DIContainer;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "DispatcherServlet", value = "/*", loadOnStartup = 1)
public class DispatcherServlet extends HttpServlet {
    DIContainer diContainer = new DIContainer();

    @Override
    public void init(){
        diContainer.initController();
        diContainer.initRoutes();
    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map.Entry<Class<?>,String> action = diContainer.getAction(request.getRequestURI().replace("demoTricky",""),"GET");
        Object controller = diContainer.getController(action.getKey());

        try {
            Method actionMethod = action.getKey().getMethod(action.getValue());
            List<String> result = (List<String>) actionMethod.invoke(controller);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public void destroy() {
    }
}