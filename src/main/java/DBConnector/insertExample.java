package DBConnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class insertExample {

    public static final String CONNECTION_STRING = "jdbc:postgresql://ep-hidden-waterfall-bb10w1hi-pooler.c-15.us-east-1.aws.neon.tech/neondb?sslmode=require&channel_binding=require";
    public static final String USERNAME = "neondb_owner";
    public static final String PASSWORD = "npg_5uf9PioQzCDx";

    static void main() throws SQLException {

        Scanner scanner = new Scanner(System.in);
        String companyName = scanner.nextLine();

        Connection connection = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD);

        String insert = "insert into companies(\"name\") values('"+ companyName +"');";

        connection.createStatement().executeUpdate(insert);

        int limNum = scanner.nextInt();
        ResultSet resultSet = connection.createStatement().executeQuery("select * from companies order by id desc limit " + limNum);

        while (resultSet.next()) {
            System.out.println(resultSet.getString("id"));
            System.out.println(resultSet.getString("name"));
            System.out.println(resultSet.getString("description"));
            System.out.println(resultSet.getString("is_active"));
        }

        connection.close();
    }
}
