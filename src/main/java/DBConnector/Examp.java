package DBConnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Examp {

    public static final String CONNECTION_STRING = "jdbc:postgresql://ep-hidden-waterfall-bb10w1hi-pooler.c-15.us-east-1.aws.neon.tech/neondb?sslmode=require&channel_binding=require";
    public static final String USERNAME = "neondb_owner";
    public static final String PASSWORD = "npg_5uf9PioQzCDx";

    static void main() throws SQLException {

        Connection connection = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD);

        ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM companies");
    }
}
