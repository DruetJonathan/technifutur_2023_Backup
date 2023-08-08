package technifutur.be.technifutur.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import technifutur.be.technifutur.models.entities.Product;
import technifutur.be.technifutur.services.ProductServicesImpl;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@WebServlet(name = "add" ,urlPatterns = "/add",loadOnStartup = 1)

public class AddServlet extends HttpServlet {
    ProductServicesImpl productServices = new ProductServicesImpl();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("pages/add.jsp").forward(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Product product = new Product(
                request.getParameter("libele"),
                request.getParameter("description"),
                new BigDecimal(request.getParameter("price")));
        productServices.add(product);
        List<Product> products = productServices.getMany();
        request.setAttribute("products",products);
        request.getRequestDispatcher("pages/products.jsp").forward(request,response);
    }
    public void destroy() {
    }
}
