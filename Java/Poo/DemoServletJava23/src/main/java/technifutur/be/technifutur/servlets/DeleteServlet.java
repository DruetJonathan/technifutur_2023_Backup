package technifutur.be.technifutur.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import technifutur.be.technifutur.models.entities.Product;
import technifutur.be.technifutur.services.ProductServicesImpl;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "delete" ,urlPatterns = "/delete",loadOnStartup = 1)
public class DeleteServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ProductServicesImpl productServices = new ProductServicesImpl();
        productServices.delete(Integer.parseInt(request.getParameter("id")));
        List<Product> products = productServices.getMany();
        request.setAttribute("products",products);
        request.getRequestDispatcher("pages/products.jsp").forward(request,response);
    }
    public void destroy() {
    }
}
