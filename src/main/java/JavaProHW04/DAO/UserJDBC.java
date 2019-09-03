package JavaProHW04.DAO;

import JavaProHW04.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserJDBC implements DAO<User> {

    private Connection connection;

    public UserJDBC(Connection connection) {
        this.connection = connection;
    }

    public synchronized void create(User user) {
        try (PreparedStatement ps = connection.prepareStatement(UserSQL.INSERT_NEW_USER.getQUERY())) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getSurname());
            ps.setString(3, user.getPhoneNumber());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public synchronized List<User> findAll() {

        List<User> allUsers = new ArrayList<>();
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(UserSQL.READ_ALL.getQUERY());

            while (rs.next()) {
                User userFromDB = new User();
                userFromDB.setName(rs.getString("name"));
                userFromDB.setSurname(rs.getString("surname"));
                userFromDB.setPhoneNumber(rs.getString("phoneNumber"));
                allUsers.add(userFromDB);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allUsers;
    }

    @Override
    public void close() throws Exception {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
