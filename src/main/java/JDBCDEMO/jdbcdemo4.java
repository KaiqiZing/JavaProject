package JDBCDEMO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * account表 添加一条记录 insert 语句
*/
public class jdbcdemo4 {
    public static void main(String[] args) {
        Statement statement = null;
        Connection connection = null;
        try {
            // 1.register driver
            Class.forName("com.mysql.jdbc.Driver");
            // definition sql
            String sql = "delete from account where id = 11";
            // 3. get connection object
            connection = DriverManager.getConnection("jdbc:mysql://192.168.0.201:3306/test", "root", "root");
            // 4. get process object
            statement = connection.createStatement();
            int count = statement.executeUpdate(sql);
            if(count > 0){
                System.out.println("delete sql data success!!");
            }else {
                System.out.println("delete sql data failure");
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            // consider to "null pointer exception"
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
