package hotel;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.ResultSet;

public class CustomerInfo extends JFrame {

	public static void main(String[] args) {
		// Launch the application
		EventQueue.invokeLater(() -> {
			try {
				// Create and display the frame
				CustomerInfo frame = new CustomerInfo();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public CustomerInfo() {
		// Set up the frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(530, 200, 900, 600);
		// Create and configure the content pane
		JPanel contentPane = new JPanel();
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



		// Create and configure the "Back" button
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(e -> {
			// Navigate back to the reception window
			new Reception().setVisible(true);
			setVisible(false);
		});
		btnExit.setBounds(450, 510, 120, 30);
		btnExit.setBackground(Color.BLACK);
		btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);

		// Create and configure the "Load Data" button
		JButton btnLoadData = new JButton("Load Data");
		btnLoadData.addActionListener(arg0 -> {
			try {
				// Fetch customer data from the database
				DBConnection c = new DBConnection();
				String displayCustomersql = "select * from Customer";
				ResultSet rs = c.s.executeQuery(displayCustomersql);
				// Display the data in a table
				JTable table = new JTable();
				table.setBounds(0, 40, 900, 450);
				contentPane.add(table);
				table.setModel(DbUtils.resultSetToTableModel(rs));
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		btnLoadData.setBounds(300, 510, 120, 30);
		btnLoadData.setBackground(Color.BLACK);
		btnLoadData.setForeground(Color.WHITE);
		contentPane.add(btnLoadData);

		// Labels for column headers
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(31, 11, 46, 14);
		contentPane.add(lblId);

		JLabel l1 = new JLabel("Number");
		l1.setBounds(150, 11, 46, 14);
		contentPane.add(l1);

		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(270, 11, 65, 14);
		contentPane.add(lblNewLabel);

		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(360, 11, 46, 14);
		contentPane.add(lblGender);

		JLabel lblCountry = new JLabel("Country");
		lblCountry.setBounds(480, 11, 46, 14);
		contentPane.add(lblCountry);

		JLabel lblRoom = new JLabel("Room");
		lblRoom.setBounds(600, 11, 46, 14);
		contentPane.add(lblRoom);

		JLabel lblStatus = new JLabel("Check-in Status");
		lblStatus.setBounds(680, 11, 100, 14);
		contentPane.add(lblStatus);

		JLabel lblNewLabel_1 = new JLabel("Deposit");
		lblNewLabel_1.setBounds(800, 11, 100, 14);
		contentPane.add(lblNewLabel_1);

		// Set background color
		getContentPane().setBackground(Color.WHITE);
	}
}