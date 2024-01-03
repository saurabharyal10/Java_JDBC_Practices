package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DataEntryTable {
	public static List<Map<String, String>> data = new ArrayList<Map<String, String>>();
	
	public static JTable getTableUI() {
		
		
		String[] columnNames = {"First Name","Last Name","Address","Phone","Email"}; 

		String[][] cells = new String[data.size()][6];
		for(int i = 0; i<data.size(); i++) {
			Map<String, String> row = data.get(i);
			cells[i][0] = row.get("firstname");
			cells[i][1] = row.get("lastname");
			cells[i][2] = row.get("address");
			cells[i][3] = row.get("phone");
			cells[i][4] = row.get("email");
		}

		JTable table = new JTable(cells, columnNames);
		return table;
		
	}
	 public static void main(String[] args) throws ClassNotFoundException, SQLException {
         Class.forName("com.mysql.jdbc.Driver");
         Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/bca", "root", "");

         System.out.println("Connection Successful........");
        
         Statement statement = connect.createStatement();
         String selectQuery = "select * from dataentry";
        
         ResultSet resultSet = statement.executeQuery(selectQuery);
         while(resultSet.next()) {
             System.out.println(" firstname: "+resultSet.getString(1));
             System.out.println(" lastname: "+resultSet.getString(2));
             System.out.println(" address: "+resultSet.getString(3));
             System.out.println(" phone: "+resultSet.getString(4));
             System.out.println(" email: "+resultSet.getString(5));
             System.out.println("\n"); 
     }
         List<Map<String, String>> data = new ArrayList<Map<String, String>>();
     		
     		String[][] cells = new String[data.size()][6];
     		
     	}

}
