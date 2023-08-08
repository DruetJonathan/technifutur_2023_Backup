package technifutur.be.technifutur.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import technifutur.be.technifutur.models.entities.Product;
import technifutur.be.technifutur.models.entities.User;
import technifutur.be.technifutur.services.ProductServicesImpl;
import technifutur.be.technifutur.services.UserServiceImpl;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "products" ,urlPatterns = "/products",loadOnStartup = 1)
public class ProductServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        request.setAttribute("login","");
//        request.getRequestDispatcher("pages/login.jsp").forward(request,response);
        ProductServicesImpl productServices = new ProductServicesImpl();
        List<Product> products = productServices.getMany();
        request.setAttribute("products",products);
        request.getRequestDispatcher("pages/products.jsp").forward(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    }
    public void destroy() {
    }
}
