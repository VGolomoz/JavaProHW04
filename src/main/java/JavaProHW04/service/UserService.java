package JavaProHW04.service;

import JavaProHW04.DAO.UserDAO;
import JavaProHW04.entity.User;
import java.util.List;

public class UserService {

    private UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void addUser(User user) {
        userDAO.create(user);
    }

    public List<User> getUsers() {
        return userDAO.findAll();
    }
}
