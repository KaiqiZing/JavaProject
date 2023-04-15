package JDBCDEMO;
import utils.JDBCUtils;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
 * Ö´ÐÐDDLÓï¾ä
*/
/*

explain List<Emp> list = null;
list = new ArrayList<Emp>();

This code declares a List variable named "list" and initializes it to null. In Java, when a variable is initialized, it is assigned a default value of null, which means that the variable does not point to any object in memory.

In the second line of code, the "list" variable is assigned a new ArrayList object that can store elements of the "Emp" type. This means that "list" now points to a new ArrayList object that can store Emp objects.

By doing this, we have created an empty ArrayList object that can store Emp objects and assigned it to the "list" variable. We can now use the "list" variable to add Emp objects to the ArrayList or to remove Emp objects from the ArrayList or perform any other operation that is supported by the List interface.

In summary, the code initializes a List variable to null and then creates an ArrayList object that can store Emp objects and assigns it to the List variable.
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
