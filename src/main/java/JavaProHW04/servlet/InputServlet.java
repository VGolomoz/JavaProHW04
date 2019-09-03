package JavaProHW04.servlet;

import JavaProHW04.DAO.DBCPool;
import JavaProHW04.DAO.UserJDBC;
import JavaProHW04.entity.User;
import JavaProHW04.service.UserService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@WebServlet(urlPatterns = "/input")
public class InputServlet extends HttpServlet {

    private UserService userService = new UserService(new UserJDBC());

    @Override
    public void init() throws ServletException {
        try (Statement st = DBCPool.getConnection().createStatement()) {

            st.execute("DROP TABLE IF EXISTS `Users`");
            st.execute("CREATE TABLE `Users` (`id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY," +
                    " `name` VARCHAR(20) NOT NULL," +
                    " `surname` VARCHAR(20) NOT NULL," +
                    " `phoneNumber` VARCHAR(20) NOT NULL)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Get method from InputServlet");
        resp.sendRedirect("input.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Post method from InputServlet");

        String phoneNumber = req.getParameter("phoneNumber");

        if(checkPhoneNumber(phoneNumber)) {
            User user = new User();
            user.setPhoneNumber(phoneNumber);
            user.setName(req.getParameter("name"));
            user.setSurname(req.getParameter("surname"));
            userService.addUser(user);
            req.getSession().setAttribute("inputDone", "Input Successful");
        }
        else {req.getSession().setAttribute("wrongNumber", "Wrong mobile phone number");
        }
        resp.sendRedirect("input.jsp");
    }

    private boolean checkPhoneNumber(String number){
        Pattern p = Pattern.compile("^\\d+(?:\\.\\d+)?$");
        Matcher m = p.matcher(number);
        return (m.matches() && number.length()<=12);
    }
}
