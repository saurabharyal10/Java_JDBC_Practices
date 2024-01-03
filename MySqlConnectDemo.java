package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlConnectDemo {

        public static void main(String[] args) throws ClassNotFoundException, SQLException {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/bca", "root", "");

                System.out.println("Connection Successful........");
               
                Statement statement = connect.createStatement();
                String query = "insert into student(first_name, last_name, contact) values('Nami', 'Subedi', '9841653141')";
                statement.executeUpdate(query);
               
                System.out.println("Insert Successful........");
        }
}