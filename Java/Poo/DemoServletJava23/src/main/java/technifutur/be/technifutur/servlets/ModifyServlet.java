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

@WebServlet(name = "modify" ,urlPatterns = "/modify",loadOnStartup = 1)
public class ModifyServlet extends HttpServlet {
    ProductServicesImpl productServices = new ProductServicesImpl();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Product product = productServices.getOne(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("product",product);
        request.setAttribute("id",product.getId());
        request.getRequestDispatcher("pages/modify.jsp").forward(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println(request.getAttribute("id"));
        Product product = new Product(Integer.parseInt(request.getParameter("id")),
                request.getParameter("libele"),
                request.getParameter("description"),
                new BigDecimal(request.getParameter("price")));
        productServices.update(Integer.parseInt(request.getParameter("id")),product);
        List<Product> products = productServices.getMany();
        request.setAttribute("products",products);
        request.getRequestDispatcher("pages/products.jsp").forward(request,response);
    }
    public void destroy() {
    }
}
