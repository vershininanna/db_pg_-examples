package DBConnector;

import java.sql.*;

public class StatementExamples {
    public static final String CONNECTION_STRING = "jdbc:postgresql://ep-hidden-waterfall-bb10w1hi-pooler.c-15.us-east-1.aws.neon.tech/neondb?sslmode=require&channel_binding=require";
    public static final String USERNAME = "neondb_owner";
    public static final String PASSWORD = "npg_5uf9PioQzCDx";

    static void main() throws SQLException {
        Connection connection = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD);

        // если хотим отправить обычный запрос (без параметров), то делаем createStatement
//        Statement statement = connection.createStatement();
//        ResultSet resultSet = statement.executeQuery("select * from companies");
//        while (resultSet.next()) {
//            System.out.println(resultSet.getInt(1));
//            System.out.println(resultSet.getString(2));
//       }
//       // удаление по id с простым Statement
//       statement.executeUpdate("delete from companies where id = 47");

        //создаем PreparedStatement
        String insertValues = "insert into companies (\"name\", description, is_active) values (?, ?, ?);";

        PreparedStatement ps = connection.prepareStatement(insertValues, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1,"TST - 3 - best company");
        ps.setString(2,"Описание проекта");
        ps.setBoolean(3,true);

        ps.executeUpdate();

        ResultSet generatedKeys = ps.getGeneratedKeys(); //получить id только что созданного объекта

        if (generatedKeys.next()) {
            System.out.println("Новый ID: " + generatedKeys.getInt(1));
        }
        int rows = ps.executeUpdate();

     //   System.out.println("Добавлено записей: " + rows); // если использовать addBatch например

//        ResultSet resultps = statement.executeQuery("select * from companies");
//        resultps.next();
//
//        System.out.println(resultps.getInt("id") + " " + resultps.getString("name"));
    }
}
