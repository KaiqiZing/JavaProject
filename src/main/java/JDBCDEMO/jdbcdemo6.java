package JDBCDEMO;

import java.sql.*;

/*
 * Ö´ÐÐDDLÓï¾ä
*/
public class jdbcdemo6 {
    public static void main(String[] args) {
        Statement statement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        try {
            // 1.register driver
            Class.forName("com.mysql.jdbc.Driver");
            // definition sql
            String sql = "select * from account";
            // 3. get connection object
            connection = DriverManager.getConnection("jdbc:mysql://192.168.0.201:3306/test", "root", "root");
            // 4. get process object
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString("name");
                double money = resultSet.getDouble(3);
                System.out.println(id +":"+  name+":"  + money);
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            // consider to "null pointer exception"
            if (resultSet != null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

        }

    }
}
