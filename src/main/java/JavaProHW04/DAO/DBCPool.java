package JavaProHW04.DAO;


import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DBCPool {

    private static final BasicDataSource dataSource = new BasicDataSource();
    private static final String DB_URL = DBConfig.getUrl();
    private static final String DB_USER = DBConfig.getUser();
    private static final String DB_PASSWORD = DBConfig.getPassword();

    static {
        dataSource.setUrl(DB_URL);
        dataSource.setUsername(DB_USER);
        dataSource.setPassword(DB_PASSWORD);

        dataSource.setMinIdle(5);
        dataSource.setMaxIdle(10);
        dataSource.setInitialSize(5);
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    private DBCPool() {
    }
}
