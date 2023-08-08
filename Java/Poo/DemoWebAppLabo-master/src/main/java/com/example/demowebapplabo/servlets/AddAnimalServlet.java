package com.example.demowebapplabo.servlets;

import com.example.demowebapplabo.models.entities.Animal;
import com.example.demowebapplabo.models.forms.AnimalForm;
import com.example.demowebapplabo.services.AnimalService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Valid;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

import java.io.IOException;
import java.util.Set;

@WebServlet(name = "animalAdd", urlPatterns = "/animal/add")
public class AddAnimalServlet extends HttpServlet {

    @Inject
    private AnimalService animalService;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/pages/animalForm.jsp").forward(request,response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");

        AnimalForm animalForm = new AnimalForm(name);

        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<AnimalForm>> constraints = validator.validate(animalForm);

        if(constraints.size() > 0){

            for (ConstraintViolation<AnimalForm> constraint : constraints) {
                if(constraint.getPropertyPath().toString().equals("name")){

                    request.setAttribute("nameError",constraint.getMessage());
                }
                System.out.println(constraint.getRootBeanClass().getSimpleName()+
                        "." + constraint.getPropertyPath() + " " + constraint.getMessage());
            }
            request.setAttribute("name",name);
            request.getRequestDispatcher("/WEB-INF/pages/animalForm.jsp").forward(request,response);
        }else{
            Animal animal = animalService.add(animalForm);
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }
    }
}