package technifutur.be.technifutur.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import technifutur.be.technifutur.models.entities.Product;
import technifutur.be.technifutur.models.entities.Song;
import technifutur.be.technifutur.models.entities.User;
import technifutur.be.technifutur.models.entities.UserSimplify;
import technifutur.be.technifutur.services.ProductServicesImpl;
import technifutur.be.technifutur.services.SongServiceImpl;
import technifutur.be.technifutur.services.UserServiceImpl;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "songs" ,urlPatterns = "/songs",loadOnStartup = 1)

public class SongServlet extends HttpServlet {
    public void init() {
        String connectionString = this.getServletContext().getInitParameter("CONNECTION_STRING");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        ProductServicesImpl productServices = new ProductServicesImpl();
//        List<Product> products = productServices.getMany();
//        request.setAttribute("products",products);
//        request.getRequestDispatcher("pages/products.jsp").forward(request,response);
        SongServiceImpl songService = new SongServiceImpl();
        List<Song> songs = songService.getMany();
        request.setAttribute("songs",songs);
        request.getRequestDispatcher("pages/songs.jsp").forward(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    }
    public void destroy() {
    }
}
