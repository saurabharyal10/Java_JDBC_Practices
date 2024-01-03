package JDBC;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class UserRegistration extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField firstname;
    private JTextField lastname;
    private JTextField email;
    private JTextField username;
    private JTextField mob;
    private JPasswordField passwordField;
    private JButton btnNewButton;
	private Object JTable;

   
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UserRegistration frame = new UserRegistration();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public UserRegistration() {
    	ButtonGroup group;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 421, 597);
        setResizable(false);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 4, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

		
		JLabel headerLbl = new JLabel("Form Filing:");
		headerLbl.setBounds(182, 15, 100, 20);
		contentPane.add(headerLbl);
		
		JLabel fntLbl = new JLabel("First Name:");
		fntLbl.setBounds(50, 50, 100, 20);
		contentPane.add(fntLbl);
		JTextField fnField = new JTextField();
		fnField.setBounds(150, 50, 180, 20);
		contentPane.add(fnField);
		
		JLabel lntLbl = new JLabel("Last Name:");
		lntLbl.setBounds(50, 90, 100, 20);
		contentPane.add(lntLbl);
		JTextField lnField = new JTextField();
		lnField.setBounds(150, 90, 180, 20);
		contentPane.add(lnField);

		JLabel addressLbl = new JLabel("Address:");
		addressLbl.setBounds(50, 130, 100, 20);
		contentPane.add(addressLbl);
		JTextField addressField = new JTextField();
		addressField.setBounds(150, 130, 180, 20);
		contentPane.add(addressField);
		
		JLabel contactLbl = new JLabel("Contact:");
		contactLbl.setBounds(50, 170, 100, 20);
		contentPane.add(contactLbl);
		JTextField contactField = new JTextField();
		contactField.setBounds(150, 170, 180, 20);
		contentPane.add(contactField);
		
		JLabel genderLbl = new JLabel("Gender:");
		genderLbl.setBounds(50, 210, 100, 20);
		contentPane.add(genderLbl);
		ButtonGroup radioGroup = new ButtonGroup();
		JRadioButton rb1 = new JRadioButton("Male");
		rb1.setActionCommand("male");
		rb1.setBounds(150, 210, 100, 20);
		radioGroup.add(rb1);
		contentPane.add(rb1);
		JRadioButton rb2 = new JRadioButton("Female");
		rb2.setActionCommand("female");
		rb2.setBounds(250, 210, 150, 20);
		radioGroup.add(rb2); 
		contentPane.add(rb2);
		group = new ButtonGroup();
		group.add(rb1);
	    group.add(rb2);
	    add(rb1);
	    add(rb2);
	      
		
		JLabel facultyLbl = new JLabel("Faculty:");
		facultyLbl.setBounds(50, 250, 100, 20);
		contentPane.add(facultyLbl);
		String[] facultyStrings = {"BCA", "BSC.CSIT", "BIM", "BBM", "BBA"};
		JComboBox faculties = new JComboBox(facultyStrings);
		faculties.setSelectedIndex(1);
		faculties.setBounds(150, 250, 100, 20);
		contentPane.add(faculties);
		
		JLabel sincerityLbl = new JLabel("Sincerity Level:");
		sincerityLbl.setBounds(50, 290, 100, 20);
		contentPane.add(sincerityLbl);
		JSlider volumeSlider = new JSlider(0,100,50);
		volumeSlider.setPaintTrack(true);
		volumeSlider.setPaintTicks(true);
		volumeSlider.setPaintLabels(true);
		
		volumeSlider.setMajorTickSpacing(50);
		volumeSlider.setMinorTickSpacing(5);
		volumeSlider.setBounds(150, 290, 200, 38);
		contentPane.add(volumeSlider);
		
		
		JLabel chkBoxLbl = new JLabel("Provided Information is valid:");
		chkBoxLbl.setBounds(50, 350, 200, 30);
		contentPane.add(chkBoxLbl);
		JCheckBox chkBox = new JCheckBox("", true);
		chkBox.setBounds(250, 350, 200, 30);
		contentPane.add(chkBox);

        btnNewButton = new JButton("Register");
        
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String firstname = fnField.getText();
				String lastname = lnField.getText();
				String address = addressField.getText();
				String contact = contactField.getText();
				String male = rb1.getText();
				String female = rb2.getText();
				String gender = group.getSelection().getActionCommand();
				String faculty = ""+ faculties.getItemAt(faculties.getSelectedIndex());  
				String sinceritylevel = ""+volumeSlider.getValue();
				int value = volumeSlider.getValue();
                String msg = "" + firstname;
                msg += " \n";
              
                try {
                	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/bca", "root", "");	
                	   
                    String query = "INSERT INTO form values('" + firstname + "','" + lastname + "','" + address + "','" +
                    		contact + "','" + gender + "','" + faculty + "','" + sinceritylevel + "')";

                    Statement sta = connection.createStatement();
                    int x = sta.executeUpdate(query);
                    
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "Add Success", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        btnNewButton.setBounds(100, 400, 259, 34);
        contentPane.add(btnNewButton);
        
        try {
        	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBounds(450, 190, 521, 597);
            setTitle("Table");
            setResizable(false);
            JPanel tablepanel = new JPanel();
            tablepanel.setBorder(new EmptyBorder(5, 4, 5, 5));
            setContentPane(tablepanel);
            tablepanel.setLayout(null);
            
            JLabel tableHeader = new JLabel("Table List");
            tableHeader.setBounds(212, 15, 100, 20);
            tablepanel.add(tableHeader);
    		
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/bca", "root", "");	
            String selectQuery = "select * from form";

            Statement sta = connection.createStatement();
            ResultSet resultSet = sta.executeQuery(selectQuery);
            while(resultSet.next()) {
              System.out.println(" First Name: "+resultSet.getString("firstname"));
              System.out.println(" Last Name: "+resultSet.getString("lastname"));
              System.out.println(" Address: "+resultSet.getString("address"));
              System.out.println(" Contact: "+resultSet.getString("contact"));
              System.out.println(" Gender: "+resultSet.getString("gender"));
              System.out.println(" Faculty: "+resultSet.getString("faculty"));
              System.out.println(" Sincerity Level: "+resultSet.getString("sinceritylevel"));
              System.out.println("\n"); 
            	
             
//            	
//            	String lastname = resultSet.getString("lastname");
//            	String address = resultSet.getString("address");
//            	String contact = resultSet.getString("contact");
//            	String gender = resultSet.getString("gender");
//            	String faculty = resultSet.getString("faculty");
//            	String sinceritylevel = resultSet.getString("sinceritylevel");
            	
//            	List<Map<String, String>> data = new ArrayList<Map<String, String>>();
//                String[] columnNames = {"First Name","Last Name","Address"
//     					,"Contact","Gender","Faculty","Sincerity Level"}; 
                
                
//                String[][] cells = new String[data.size()][8];
//             
//                for(int i = 0; i<data.size(); i++) {
//            	Map<String, String> row = data.get(i);
//             	cells[i][0] = row.get("firstname");
//    				cells[i][1] = row.get("lastname");
//    				cells[i][2] = row.get("address");
//    				cells[i][3] = row.get("contact");
//    				cells[i][4] = row.get("gender");
//    				cells[i][5] = row.get("faculty");
//    				cells[i][6] = row.get("sinceritylevel");
//    				}
//                JTable table = new JTable(cells, columnNames);
//                return;
            }  

        }catch (Exception exception) {
            exception.printStackTrace();
        } 
       
		
			
			


    }
}