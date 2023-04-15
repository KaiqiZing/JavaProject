package JDBCDEMO;
import utils.JDBCUtils;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
 * Ö´ÐÐDDLÓï¾ä
*/
public class jdbcdemo7 {
    public static void main(String[] args) {
        List<account> list1 = new jdbcdemo7().findAll();
        System.out.println(list1);

        List<account> list2 = new jdbcdemo7().findall2();
        System.out.println(list2);

    }

    public List<account> findAll(){
        Statement statement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        List<account> list = null;
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
            account acc = null;
            list = new ArrayList<account>();

            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                float money = resultSet.getFloat("money");
                acc = new account();
                acc.setId(id);
                acc.setName(name);
                acc.setMoney(money);
                list.add(acc);
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
        return list;
    }

    public List<account> findall2(){
        Statement statement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        List<account> list = null;
        try {
            // 1.register driver
            Class.forName("com.mysql.jdbc.Driver");
            // definition sql
            String sql = "select * from account";
            // 3. get connection object
            connection = JDBCUtils.getConnection();
            // 4. get process object
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            account acc = null;
            list = new ArrayList<account>();

            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                float money = resultSet.getFloat("money");
                acc = new account();
                acc.setId(id);
                acc.setName(name);
                acc.setMoney(money);
                list.add(acc);
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
        return list;

    }

}
