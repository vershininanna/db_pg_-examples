package DBConnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeleteAllRecords {
    public static final String CONNECTION_STRING = "jdbc:postgresql://ep-hidden-waterfall-bb10w1hi-pooler.c-15.us-east-1.aws.neon.tech/neondb?sslmode=require&channel_binding=require";
    public static final String USERNAME = "neondb_owner";
    public static final String PASSWORD = "npg_5uf9PioQzCDx";

    static void main() throws SQLException {
        Connection connection = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD);

        ResultSet rows = connection.createStatement().executeQuery("select * from companies order by id asc");

        while (rows.next()) {
            System.out.println(rows.getInt(1));
            System.out.println(rows.getString(2));
        }

        int deletedRows = connection.createStatement().executeUpdate("DELETE FROM companies");

        System.out.println("Удалено записей: " + deletedRows);

        connection.close();
    }
}
