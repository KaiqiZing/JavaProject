package JDBCDEMO;

import java.sql.*;

public class jdbcdemo1 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        Class.forName("com.mysql.jdbc.Driver");  mysql5之后不需要注册驱动
        Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.0.201:3306/test", "root", "root");
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM account");
        while (resultSet.next()){
            System.out.println(resultSet.getString("name") + resultSet.getString("money"));
        }

        statement.close();
        conn.close();
    }
}
