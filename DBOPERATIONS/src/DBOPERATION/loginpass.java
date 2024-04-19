package DBOPERATION;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class loginpass {

	
	private JFrame frame;
	private JTextField tb1;
	private JPasswordField p1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginpass window = new loginpass();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public loginpass() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN PAGE");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(149, 23, 137, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("USER NAME");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(102, 69, 86, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("PASSWORD");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(102, 136, 96, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		p1 = new JPasswordField();
		p1.setBounds(250, 134, 86, 20);
		frame.getContentPane().add(p1);
		
		tb1 = new JTextField();
		tb1.setBounds(250, 66, 86, 20);
		frame.getContentPane().add(tb1);
		tb1.setColumns(10);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = tb1.getText();
				String password =p1.getText();
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","mrec");
					PreparedStatement ps = con.prepareStatement("select name,password from users where name=? and password=?");
					ps.setString(1,name);
					ps.setString(2,password);
					ResultSet rs=ps.executeQuery();
					if(rs.next()) {
						JOptionPane.showMessageDialog(btnNewButton,"valid user");
						
					}
					else {
						JOptionPane.showMessageDialog(btnNewButton,"invalid user");
					}
				
			       }
				catch(SQLException e1)
				{
					e1.printStackTrace();
				}
				}
		});
		btnNewButton.setBounds(155, 207, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\onlinelab\\Downloads\\bgg.jpg"));
		lblNewLabel_3.setBackground(new Color(0, 0, 0));
		lblNewLabel_3.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(lblNewLabel_3);
	}
}
