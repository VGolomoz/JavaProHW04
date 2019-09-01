import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(urlPatterns = "/input")
public class InputServlet extends HttpServlet {

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
        }
        else {req.getSession().setAttribute("wrongNumber", "Wrong mobile phone number");
        }
        resp.sendRedirect("input.jsp");
    }

    private boolean checkPhoneNumber(String number){
        Pattern p = Pattern.compile("^\\d+(?:\\.\\d+)?$");
        Matcher m = p.matcher(number);
        return m.matches();
    }
}
