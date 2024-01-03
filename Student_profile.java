package JDBC;

import javax.swing.*;

import saurav.TableInfo;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;
public class Student_profile {
    public static void main(String args[]){
        
        JFrame Frame = new JFrame("Student Profile");
        JLabel header,l1,l2,l3,l4,l5;
        JTextField t1,t2,t3,t4;
        
        header =new JLabel("Students Profile");
        header.setBounds(160,10,200,30);
        
        header.setFont(new Font("Verdana", Font.PLAIN, 18));
        Frame.add(header);
        
        l1 = new JLabel("Name :");
        l1.setBounds(50, 50, 100, 20);
        Frame.add(l1);
        
        t1 = new JTextField();
        t1.setBounds(200,50,170,20);
        Frame.add(t1);
        
        l2 = new JLabel("Class :");
        l2.setBounds(50, 80, 100, 20);
        Frame.add(l2);
        
        t2 = new JTextField();
        t2.setBounds(200,80,170,20);
        Frame.add(t2);
        
        l3 = new JLabel("Semester :");
        l3.setBounds(50, 110, 100, 20);
        Frame.add(l3);
        
        t3 = new JTextField();
        t3.setBounds(200,110,170,20);
        Frame.add(t3);
        
        l4 = new JLabel("Address :");
        l4.setBounds(50, 140, 100, 20);
        Frame.add(l4);
        
        t4 = new JTextField();
        t4.setBounds(200,140,170,20);
        Frame.add(t4);
        
        l5 = new JLabel("Gender :");
        l5.setBounds(50, 170, 100, 20);
        Frame.add(l5);

        JRadioButton m1,f1;
        m1 = new JRadioButton("Male");
        f1 = new JRadioButton("Female");
        m1.setBounds(200,170,80,20);
        f1.setBounds(280,170,120,20);
        Frame.add(m1);
        Frame.add(f1);
        
        JButton submit = new JButton("Register");
        submit.setBounds(200,210,100,30);
        Frame.add(submit);
                
        
//        Class.forName("com.mysql.jdbc.Driver");
//        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/bca", "root", "");
//        
        submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

//				String query = "insert into student_field values()"
				String name = t1.getText();
				String classlevel = t2.getText();
				String semester = t3.getText();
				String address = t4.getText();
				String male = m1.getText();
				String female = f1.getText();
				
				Map<String, String> record = new HashMap<String, String>();
				record.put("name", name);
				record.put("classlevel", classlevel);
				record.put("semester", semester);
				record.put("address", address);
				record.put("gender", male);
				record.put("gender", female);
				
//				TableInfo.data.add(record);
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				m1.setText("");
				f1.setText("");
				JOptionPane.showMessageDialog(null, "Add Success", "Success", JOptionPane.INFORMATION_MESSAGE);
			}
		});
        
        Frame.setSize(500,500);  
        Frame.setLayout(null);  
        Frame.setVisible(true);  
    }
    
}
