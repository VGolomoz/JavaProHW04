package JavaProHW04.servlet;

import JavaProHW04.DAO.UserJDBC;
import JavaProHW04.entity.User;
import JavaProHW04.service.UserService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/results")
public class ResultsServlet extends HttpServlet {

    private UserService userService = new UserService(new UserJDBC());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Get method from ResultsServlet");

        List<User> userList =  userService.getUsers();
        if (!userList.isEmpty())req.setAttribute("userList", userList);
        else req.setAttribute("userList", null);

        req.getRequestDispatcher("/results.jsp").forward(req, resp);

    }
}
