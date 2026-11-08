package DBConnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnectorExample {

    public static final String CONNECTION_STRING = "jdbc:postgresql://ep-hidden-waterfall-bb10w1hi-pooler.c-15.us-east-1.aws.neon.tech/neondb?sslmode=require&channel_binding=require";
    public static final String USERNAME = "neondb_owner";
    public static final String PASSWORD = "npg_5uf9PioQzCDx";

    static void main() throws SQLException {

        Connection connection = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD);

        ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM companies");
        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1));
            System.out.println(resultSet.getString(2));
        }

      //  String insert = "insert into companies(\"name\", description) values('Company TST','Описание Company TST');";

       // connection.createStatement().executeUpdate(insert);

        //resultSet = connection.createStatement().executeQuery("select * from companies order by id desc limit 2");
//        resultSet = connection.createStatement().executeQuery("SELECT * FROM companies WHERE description IS NOT NULL");
//        while (resultSet.next()) {
//            System.out.println(resultSet.getString("id"));
//            System.out.println(resultSet.getString("name"));
//            System.out.println(resultSet.getString("description"));
//            System.out.println(resultSet.getString("is_active"));
//        }

        connection.close();
    }
}