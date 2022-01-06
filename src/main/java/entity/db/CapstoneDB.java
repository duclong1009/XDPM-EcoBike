
package entity.db;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import java.sql.Connection;
import utils.*;

public class CapstoneDB {
    private static Logger LOGGER = Utils.getLogger(Connection.class.getName());
    private static Connection connection;

    public static Connection getConnection() {
        if (connection != null) return connection;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecodb", "root", "123456");
            LOGGER.info("Connect database successfully");
        } catch (Exception e) {
            LOGGER.info(e.getMessage());
        }
        return connection;
    }
    public static void main(String[] args) {
        CapstoneDB.getConnection();
    }
}