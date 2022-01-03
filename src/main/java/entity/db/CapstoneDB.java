
package entity.db;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import java.sql.Connection;
import utils.*;

public class AIMSDB {

    private static Logger LOGGER = Utils.getLogger(Connection.class.getName());
    private static Connection connect;

    public static Connection getConnection() {
        if (connect != null) return connect;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "tan", "251120");
            LOGGER.info("Connect database successfully");
        } catch (Exception e) {
            LOGGER.info(e.getMessage());
        }
        return connect;
    }

    public static void main(String[] args) {
        AIMSDB.getConnection();
    }
}