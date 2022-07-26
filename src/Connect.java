import java.sql.*;

public class Connect {
    public static void startConnection() {
        Connection connection = null;
        try {
            // below two lines are used for connectivity.
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sergio",
                    "root", "password");

            // mydb is database
            // mydbuser is name of database
            // mydbuser is password of database

            Statement statement;
            statement = connection.createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery(
                    "select * from designation");
            int code;
            String title;
            // while (resultSet.next()) {
            //     code = resultSet.getInt("code");
            //     title = resultSet.getString("title").trim();
            //     System.out.println("Code : " + code
            //             + " Title : " + title);
            // }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }
}