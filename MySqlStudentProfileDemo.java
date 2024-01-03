package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JList;
import javax.swing.JTable;

public class MySqlStudentProfileDemo {

        public static void main(String[] args) throws ClassNotFoundException, SQLException {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/bca", "root", "");

                System.out.println("Connection Successful........");
               
                Statement statement = connect.createStatement();
                
                List<Map<String, String>> data = new ArrayList<Map<String, String>>();
            		
            		String[][] cells = new String[data.size()][6];
            		for(int i = 0; i<data.size(); i++) {
            			Map<String, String> row = data.get(i);
            			String name = row.get("name");
            			String classlevel = row.get("class");
            			String semester = row.get("semester");
            			String address = row.get("address");
            			String gender = row.get("gender");
            	}
                
                String query = "insert into student_field(name, class, semester, address, gender) values('name', 'classlevel', 'semester', 'address', 'gender')";
                int rows = statement.executeUpdate(query);
               
                System.out.println("Insert Successful........"+rows+" affected");
               
                String selectQuery = "select * from student_field";
               
                ResultSet resultSet = statement.executeQuery(selectQuery);
               
                while(resultSet.next()) {
                        System.out.print("ID: "+resultSet.getInt(1));
                        System.out.print(" Name: "+resultSet.getString(2));
                        System.out.print(" Class: "+resultSet.getString(3));
                        System.out.println(" Semester: "+resultSet.getString("contact"));
                        System.out.println(" Address: "+resultSet.getString(5));
                        System.out.println(" Gender: "+resultSet.getString(6));
                }
        }
}