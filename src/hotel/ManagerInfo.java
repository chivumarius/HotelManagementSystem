package hotel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import net.proteanit.sql.DbUtils;

// Define ManagerInfo class as a subclass of JFrame
public class ManagerInfo extends JFrame {
	Connection conn = null;
	private JPanel contentPane;
	private JTable table;
	private JLabel lblNewLabel;
	private JLabel lblJob;
	private JLabel lblName;
	private JLabel lblDepartment;

	// Main method to launch the application
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerInfo frame = new ManagerInfo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Method to close the window
	public void close() {
		this.dispose();
	}

	// Constructor for ManagerInfo class
	public ManagerInfo() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(430, 200, 1000, 600);

		// Create content pane
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Center the frame on the screen
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = (int) screenSize.getWidth();
		int screenHeight = (int) screenSize.getHeight();
		int frameWidth = getWidth();
		int frameHeight = getHeight();
		int x = (screenWidth - frameWidth) / 2;
		int y = (screenHeight - frameHeight) / 2;
		setLocation(x, y);

		// Create table to display data
		table = new JTable();
		table.setBounds(0, 34, 1000, 450);
		contentPane.add(table);

		// Button to load data from the database
		JButton btnLoadData = new JButton("Load Data");
		btnLoadData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// Establish database connection
					DBConnection c = new DBConnection();
					// SQL query to fetch manager information
					String displayCustomersql = "select * from Employee where job = 'Manager'";
					ResultSet rs = c.s.executeQuery(displayCustomersql);
					// Set table model with retrieved data
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnLoadData.setBounds(350, 500, 120, 30);
		btnLoadData.setBackground(Color.BLACK);
		btnLoadData.setForeground(Color.WHITE);
		contentPane.add(btnLoadData);

		// Button to navigate back to Reception window
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Reception().setVisible(true);
				setVisible(false);
			}
		});
		btnExit.setBounds(510, 500, 120, 30);
		btnExit.setBackground(Color.BLACK);
		btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);

		// Labels for table columns
		lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(41, 11, 46, 14);
		contentPane.add(lblNewLabel);

		lblJob = new JLabel("Age");
		lblJob.setBounds(159, 11, 46, 14);
		contentPane.add(lblJob);

		lblName = new JLabel("Gender");
		lblName.setBounds(273, 11, 46, 14);
		contentPane.add(lblName);

		lblDepartment = new JLabel("Job");
		lblDepartment.setBounds(416, 11, 86, 14);
		contentPane.add(lblDepartment);

		// Additional labels for table columns
		JLabel l1 = new JLabel("Salary");
		l1.setBounds(536, 11, 86, 14);
		contentPane.add(l1);

		JLabel l2 = new JLabel("Phone");
		l2.setBounds(656, 11, 86, 14);
		contentPane.add(l2);

		JLabel l3 = new JLabel("Personal Identification Number");
		l3.setBounds(786, 11, 86, 14);
		contentPane.add(l3);

		JLabel l4 = new JLabel("Gmail");
		l4.setBounds(896, 11, 86, 14);
		contentPane.add(l4);

		// Set background color
		getContentPane().setBackground(Color.WHITE);
	}
}