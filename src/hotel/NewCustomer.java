package hotel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NewCustomer extends JFrame {
	Connection conn = null;
	PreparedStatement pst = null;
	private JPanel contentPane;
	private JTextField t1, t2, t3, t4, t5, t6;
	JComboBox comboBox;
	JRadioButton r1, r2;
	Choice c1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		// Launch the application on the event dispatch thread
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewCustomer frame = new NewCustomer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NewCustomer() throws SQLException {
		// Set frame dimensions and initialize content pane
		setBounds(530, 200, 850, 550);
		contentPane = new JPanel();
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

		// Add an image
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
		Image i3 = i1.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
		ImageIcon i2 = new ImageIcon(i3);
		JLabel l1 = new JLabel(i2);
		l1.setBounds(480, 10, 300, 500);
		add(l1);

		// Add labels and input fields
		JLabel lblName = new JLabel("New Customer Form");
		lblName.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
		lblName.setBounds(118, 11, 260, 53);
		contentPane.add(lblName);

		// Add ID label and combo box
		JLabel lblId = new JLabel("ID :");
		lblId.setBounds(35, 76, 200, 14);
		contentPane.add(lblId);
		comboBox = new JComboBox(new String[]{"Passport", "Personal Identification Number\t", "Voter Id", "Driving license"});
		comboBox.setBounds(271, 73, 150, 20);
		contentPane.add(comboBox);

		// Add Number label and text field
		JLabel l2 = new JLabel("Number :");
		l2.setBounds(35, 111, 200, 14);
		contentPane.add(l2);
		t1 = new JTextField();
		t1.setBounds(271, 111, 150, 20);
		contentPane.add(t1);
		t1.setColumns(10);

		// Add Name label and text field
		JLabel lblName_1 = new JLabel("Name :");
		lblName_1.setBounds(35, 151, 200, 14);
		contentPane.add(lblName_1);
		t2 = new JTextField();
		t2.setBounds(271, 151, 150, 20);
		contentPane.add(t2);
		t2.setColumns(10);

		// Add Gender label and radio buttons
		JLabel lblGender = new JLabel("Gender :");
		lblGender.setBounds(35, 191, 200, 14);
		contentPane.add(lblGender);
		r1 = new JRadioButton("Male");
		r1.setFont(new Font("Raleway", Font.BOLD, 14));
		r1.setBackground(Color.WHITE);
		r1.setBounds(271, 191, 80, 12);
		add(r1);
		r2 = new JRadioButton("Female");
		r2.setFont(new Font("Raleway", Font.BOLD, 14));
		r2.setBackground(Color.WHITE);
		r2.setBounds(350, 191, 100, 12);
		add(r2);

		// Add Country label and text field
		JLabel lblCountry = new JLabel("Country :");
		lblCountry.setBounds(35, 231, 200, 14);
		contentPane.add(lblCountry);
		t3 = new JTextField();
		t3.setBounds(271, 231, 150, 20);
		contentPane.add(t3);
		t3.setColumns(10);

		// Add Allocated Room Number label and choice component
		JLabel lblReserveRoomNumber = new JLabel("Allocated Room Number :");
		lblReserveRoomNumber.setBounds(35, 274, 200, 14);
		contentPane.add(lblReserveRoomNumber);
		c1 = new Choice();
		try {
			DBConnection c = new DBConnection();
			ResultSet rs = c.s.executeQuery("select * from room");
			while (rs.next()) {
				c1.add(rs.getString("room_number"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		c1.setBounds(271, 274, 150, 20);
		contentPane.add(c1);

		// Add Checked-In label and text field
		JLabel lblCheckInStatus = new JLabel("Checked-In :");
		lblCheckInStatus.setBounds(35, 316, 200, 14);
		contentPane.add(lblCheckInStatus);
		t5 = new JTextField();
		t5.setBounds(271, 316, 150, 20);
		contentPane.add(t5);
		t5.setColumns(10);

		// Add Deposit label
		JLabel lblDeposit = new JLabel("Deposit:");
		lblDeposit.setBounds(35, 359, 200, 14);
		contentPane.add(lblDeposit);

// Add Deposit text field
		t6 = new JTextField();
		t6.setBounds(271, 359, 150, 20);
		contentPane.add(t6);
		t6.setColumns(10);

// Add button to submit the form
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Establish database connection
				DBConnection c = new DBConnection();
				String radio = null;

				// Determine selected gender
				if (r1.isSelected()) {
					radio = "Male";
				} else if (r2.isSelected()) {
					radio = "Female";
				}

				// Get selected room number
				String s6 = c1.getSelectedItem();

				try {
					// Retrieve form inputs
					String s1 = (String) comboBox.getSelectedItem();
					String s2 = t1.getText();
					String s3 = t2.getText();
					String s4 = radio;
					String s5 = t3.getText();
					String s7 = t5.getText();
					String s8 = t6.getText();

					// Construct SQL queries
					String q1 = "insert into customer values('" + s1 + "','" + s2 + "','" + s3 + "','" + s4 + "','" + s5 + "','" + s6 + "','" + s7 + "','" + s8 + "')";
					String q2 = "update room set availability = 'Occupied' where room_number = " + s6;

					// Execute SQL queries
					c.s.executeUpdate(q1);
					c.s.executeUpdate(q2);

					// Display success message
					JOptionPane.showMessageDialog(null, "Data Inserted Successfully");

					// Redirect to Reception window
					new Reception().setVisible(true);
					setVisible(false);
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				} catch (NumberFormatException s) {
					JOptionPane.showMessageDialog(null, "Please enter a valid Number");
				}
			}
		});
		btnNewButton.setBounds(100, 430, 120, 30);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setForeground(Color.WHITE);
		contentPane.add(btnNewButton);

// Add button to navigate back to Reception window
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Reception().setVisible(true);
				setVisible(false);
			}
		});
		btnExit.setBounds(260, 430, 120, 30);
		btnExit.setBackground(Color.BLACK);
		btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);

		// Set background color
		getContentPane().setBackground(Color.WHITE);
	}
}