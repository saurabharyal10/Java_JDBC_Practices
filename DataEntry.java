package JDBC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import saurav.TableInfo;

public class DataEntry {
	public static void main(String args[]) throws ClassNotFoundException, SQLException {
		JFrame frame=new JFrame();
		
		JMenuBar menu=new JMenuBar();
		frame.setJMenuBar(menu);		
		JMenu file=new JMenu("File");
		menu.add(file);
		JMenu table=new JMenu("Table");
		menu.add(table);
		
		JLabel fname=new JLabel("First Name:");
		frame.add(fname);
		fname.setBounds(10, 10, 150, 40);
		JTextField txtfname=new JTextField();
		frame.add(txtfname);
		txtfname.setBounds(100, 12, 150, 30);
		
		JLabel lname=new JLabel("Last Name:");
		frame.add(lname);
		lname.setBounds(10, 40, 150, 40);
		JTextField txtlname=new JTextField();
		frame.add(txtlname);
		txtlname.setBounds(100, 42, 150, 30);
		
		JLabel address=new JLabel("Address:");
		frame.add(address);
		address.setBounds(10, 70, 150, 40);
		JTextField txtaddress=new JTextField();
		frame.add(txtaddress);
		txtaddress.setBounds(100, 72, 150, 30);
		
		JLabel phone=new JLabel("Phone Number:");
		frame.add(phone);
		phone.setBounds(10, 100, 150, 40);
		JTextField txtphone=new JTextField();
		frame.add(txtphone);
		txtphone.setBounds(100, 102, 150, 30);
		
		JLabel email=new JLabel("E-mail:");
		frame.add(email);
		email.setBounds(10, 130, 150, 40);
		JTextField txtemail=new JTextField();
		frame.add(txtemail);
		txtemail.setBounds(100, 132, 150, 30);
		
		
		JButton btn=new JButton("Save");
		frame.add(btn);
		btn.setBounds(150, 172, 100, 30);
		 Class.forName("com.mysql.jdbc.Driver");
         Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/bca", "root", "");	
   
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					   String query = "insert into dataentry values(?,?,?,?,?)";
		      PreparedStatement pt=connect.prepareStatement(query);
		      pt.setString(1, txtfname.getText());
		      pt.setString(2, txtlname.getText());
		      pt.setString(3, txtaddress.getText());
		      pt.setString(4, txtphone.getText());
		      pt.setString(5, txtemail.getText());
		      pt.executeUpdate();
		      
//		      DatabaseUtil.save(txtfname, txtlname,txtaddress,txtphone,txtemail);
		      
		      JOptionPane.showMessageDialog(btn, "Insert Success");
				
			}
				catch(Exception e1){
				System.out.println("Error"+e1);
			}
			}
		});
		
		
		Statement statement = connect.createStatement();
		String selectQuery = "select * from dataentry";
        
        ResultSet resultSet = statement.executeQuery(selectQuery);
       
        while(resultSet.next()) {
                System.out.println(" First Name: "+resultSet.getString("firstname"));
                System.out.println(" Last Name: "+resultSet.getString("lastname"));
                System.out.println(" Address: "+resultSet.getString("address"));
                System.out.println(" Phone: "+resultSet.getString("phone"));
                System.out.println(" Email: "+resultSet.getString("email"));
                System.out.println("\n"); 
        }

    		
		frame.setSize(400,400);
		frame.setTitle("Address Book");
		frame.setLayout(null);
		frame.setVisible(true);
		
	
          
         
	}
}