package hotel;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.*;

// Class for handling pick-up service
public class PickUp extends JFrame {
	// Database connection variables
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	// GUI components
	private JPanel contentPane;
	private JTable table;
	private Choice c1;


	// Main method to run the application
	public static void main(String[] args) {
		// Running the application
		EventQueue.invokeLater(() -> {
			try {
				// Create a new instance of the PickUp frame
				PickUp frame = new PickUp();
				// Set the frame to be visible
				frame.setVisible(true);
			} catch (Exception e) {
				// Print stack trace in case of an exception
				e.printStackTrace();
			}
		});
	}


	// Method to close the frame
	public void close() {
		this.dispose();
	}


	// Constructor
	public PickUp() {
		// Initialize the frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(530, 200, 800, 600);
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

		// Add labels and components to the frame
		JLabel lblPickUpService = new JLabel("Pick Up Service");
		lblPickUpService.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPickUpService.setBounds(90, 11, 158, 25);
		contentPane.add(lblPickUpService);

		JLabel lblTypeOfCar = new JLabel("Type of Car");
		lblTypeOfCar.setBounds(32, 97, 89, 14);
		contentPane.add(lblTypeOfCar);

		c1 = new Choice();
		try {
			DBConnection c = new DBConnection();
			ResultSet rs = c.s.executeQuery("select * from driver");
			while (rs.next()) {
				c1.add(rs.getString("brand"));
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		c1.setBounds(123, 94, 150, 25);
		contentPane.add(c1);

		// Add a button to display information
		JButton btnRegister = new JButton("Display");
		btnRegister.addActionListener(e -> {
			String SQL = "select * from driver where brand = '" + c1.getSelectedItem() + "'";
			try {
				DBConnection c = new DBConnection();
				rs = c.s.executeQuery(SQL);
				table.setModel(DbUtils.resultSetToTableModel(rs));
			} catch (SQLException ss) {
				ss.printStackTrace();
			}
		});
		btnRegister.setBounds(200, 500, 120, 30);
		btnRegister.setBackground(Color.BLACK);
		btnRegister.setForeground(Color.WHITE);
		contentPane.add(btnRegister);

		// Add a button to go back to the previous screen
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(e -> {
			new Reception().setVisible(true);
			setVisible(false);
		});
		btnExit.setBounds(420, 500, 120, 30);
		btnExit.setBackground(Color.BLACK);
		btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);

		// Add a table to display information
		table = new JTable();
		table.setBounds(0, 233, 800, 250);
		contentPane.add(table);

		// Add labels for table columns
		JLabel lblInfo = new JLabel("Name");
		lblInfo.setBounds(24, 208, 46, 14);
		contentPane.add(lblInfo);

		JLabel lblNewLabel = new JLabel("Age");
		lblNewLabel.setBounds(165, 208, 46, 14);
		contentPane.add(lblNewLabel);

		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(264, 208, 46, 14);
		contentPane.add(lblGender);

		JLabel lblTypeOfDriver = new JLabel("Company");
		lblTypeOfDriver.setBounds(366, 208, 80, 14);
		contentPane.add(lblTypeOfDriver);

		JLabel lblDateOfThe = new JLabel("Brand");
		lblDateOfThe.setBounds(486, 208, 105, 14);
		contentPane.add(lblDateOfThe);

		JLabel lblAirport = new JLabel("Available");
		lblAirport.setBounds(600, 208, 86, 14);
		contentPane.add(lblAirport);

		JLabel lblAvailable = new JLabel("Location");
		lblAvailable.setBounds(700, 208, 73, 14);
		contentPane.add(lblAvailable);

		// Set the background color
		getContentPane().setBackground(Color.WHITE);
	}
}