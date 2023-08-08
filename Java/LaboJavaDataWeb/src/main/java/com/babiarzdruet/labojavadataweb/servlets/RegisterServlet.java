package com.babiarzdruet.labojavadataweb.servlets;

import com.babiarzdruet.labojavadataweb.models.entities.Role;
import com.babiarzdruet.labojavadataweb.models.entities.User;
import com.babiarzdruet.labojavadataweb.models.entities.UserSimplify;
import com.babiarzdruet.labojavadataweb.models.forms.UserForm;
import com.babiarzdruet.labojavadataweb.services.UserService;
import com.babiarzdruet.labojavadataweb.services.impl.UserServiceImpl;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashSet;
import java.util.Set;

@WebServlet(urlPatterns = "/registerForm", name = "registerForm")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50 // 50MB
)
public class RegisterServlet extends HttpServlet {
    @Inject
    UserService userService;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/registerForm.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String password = request.getParameter("password");
        request.setAttribute("password", password);

        String confirmpassword = request.getParameter("confirmpassword");
        request.setAttribute("confirmpassword", confirmpassword);

        String firstname = request.getParameter("firstname");
        request.setAttribute("firstname", firstname);

         String lastname = request.getParameter("lastname");
        request.setAttribute("lastname", lastname);

        String email = request.getParameter("email");
        request.setAttribute("email", email);

        String profileImage = request.getParameter("profileImage");
        System.out.println(profileImage);

        if (password.equals(confirmpassword) && (!password.isBlank() && !confirmpassword.isBlank())) {
            // Récupérer la partie de fichier à partir de la requête HTTP
            Part filePart = request.getPart("profileImage");
            // Récupérer le nom de fichier soumis
            String fileName = filePart.getSubmittedFileName();
            // Récupérer le contenu du fichier
            InputStream fileContent = filePart.getInputStream();
            // récupère le nom de l'utilisateur de la machine pour pouvoir avoir le bon chemin
            String nameOfMachine = System.getProperty("user.name");
            try{
                // Écrire le contenu du fichier sur le disque dur
                OutputStream outputStream = new FileOutputStream(new File("C:\\Users\\"+nameOfMachine+"\\Documents\\LaboJavaDataWeb\\src\\main\\webapp\\images\\" + fileName));
                int read = 0;
                byte[] bytes = new byte[1024];
                while ((read = fileContent.read(bytes)) != -1) {
                    outputStream.write(bytes, 0, read);
                }
            }catch (FileNotFoundException e){
                // todo fix ce message
//                request.setAttribute("imageProfileError","imageProfileError");
                request.getRequestDispatcher("/WEB-INF/pages/registerForm.jsp").forward(request,response);
            }

            UserForm userForm = UserForm.builder()
                    .firstname(firstname)
                    .lastname(lastname)
                    .email(email)
                    .password(password)
                    .profileImage(fileName)
                    .build();

           //
            Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
            Set<ConstraintViolation<UserForm>> constraints = validator.validate(userForm);
            if(constraints.size() > 0){

                for (ConstraintViolation<UserForm> constraint : constraints) {
                    if(constraint.getPropertyPath().toString().equals("firstname")){

                        request.setAttribute("firstNameError",constraint.getMessage());
                    }
                    if(constraint.getPropertyPath().toString().equals("lastname")){

                        request.setAttribute("lastNameError",constraint.getMessage());
                    }
                    if(constraint.getPropertyPath().toString().equals("email")){

                        request.setAttribute("emailError",constraint.getMessage());
                    }
                    if(constraint.getPropertyPath().toString().equals("password")){

                        request.setAttribute("passwordError",constraint.getMessage());
                    }
                    if(constraint.getPropertyPath().toString().equals("confirmpassword")){

                        request.setAttribute("confirmPasswordError",constraint.getMessage());
                    }
                    if(constraint.getPropertyPath().toString().equals("profileImage")){

                        request.setAttribute("profileImageError",constraint.getMessage());
                    }
                }

                request.getRequestDispatcher("/WEB-INF/pages/registerForm.jsp").forward(request,response);
            }else{
                User user = userService.add(userForm.toEntity());

                UserSimplify userSimplify = new UserSimplify(user.getEmail(),user.getRoles());
                userSimplify.setId(user.getId());
                request.getSession(true).setAttribute("user", userSimplify);
                response.sendRedirect(request.getContextPath() +"/");
            }

        } else {
            request.setAttribute("passwordError","constraint.getMessage()");
            response.sendRedirect(request.getContextPath() + "/registerForm");
        }

    }

}