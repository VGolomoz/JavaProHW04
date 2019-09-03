package JavaProHW04;

import JavaProHW04.DAO.DBCPool;
import JavaProHW04.DAO.UserJDBC;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/results")
public class ResultsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Get method from ResultsServlet");

        List<User> userList =  new UserJDBC(DBCPool.getConnection()).findAll();
        if (!userList.isEmpty())req.setAttribute("userList", userList);
        else req.setAttribute("userList", null);

        req.getRequestDispatcher("/results.jsp").forward(req, resp);

    }
}
