package hotel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

// Define UpdateCheck class as a subclass of JFrame
public class UpdateCheck extends JFrame {
	Connection conn = null;
	PreparedStatement pst = null;
	private JPanel contentPane;
	private JTextField txt_ID;
	private JTextField txt_Status;
	private JTextField txt_Date;
	private JTextField txt_Time;
	private JTextField txt_Payment;

	Choice c1, c2;

	// Main method to launch the application
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateCheck frame = new UpdateCheck();
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

	// Constructor for UpdateCheck class
	public UpdateCheck() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 950, 500);

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

		// Load image icon for decoration
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
		JLabel l1 = new JLabel(i1);
		l1.setBounds(450, 70, 476, 270);
		add(l1);

		// Label for Check-In Details title
		JLabel lblUpdateCheckStatus = new JLabel("Check-In Details");
		lblUpdateCheckStatus.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUpdateCheckStatus.setBounds(124, 11, 222, 25);
		contentPane.add(lblUpdateCheckStatus);

		// Label and choice for selecting customer ID
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setBounds(25, 88, 46, 14);
		contentPane.add(lblNewLabel);

		c1 = new Choice();
		try {
			// Fetch customer IDs from the database
			DBConnection c = new DBConnection();
			ResultSet rs = c.s.executeQuery("select * from customer");
			while (rs.next()) {
				c1.add(rs.getString("number"));
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		c1.setBounds(248, 85, 140, 20);
		contentPane.add(c1);

		// Labels for various details
		JLabel lblNewLabel_1 = new JLabel("Room Number :");
		lblNewLabel_1.setBounds(25, 129, 107, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Name : ");
		lblNewLabel_2.setBounds(25, 174, 97, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Checked-in :");
		lblNewLabel_3.setBounds(25, 216, 107, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Amount Paid (Rs) : ");
		lblNewLabel_4.setBounds(25, 261, 107, 14);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Pending Amount (Rs) : ");
		lblNewLabel_5.setBounds(25, 302, 150, 14);
		contentPane.add(lblNewLabel_5);

		// Text fields for user input
		txt_ID = new JTextField();
		txt_ID.setBounds(248, 126, 140, 20);
		contentPane.add(txt_ID);

		txt_Status = new JTextField();
		txt_Status.setBounds(248, 171, 140, 20);
		contentPane.add(txt_Status);
		txt_Status.setColumns(10);

		txt_Date = new JTextField();
		txt_Date.setBounds(248, 216, 140, 20);
		contentPane.add(txt_Date);
		txt_Date.setColumns(10);

		txt_Time = new JTextField();
		txt_Time.setBounds(248, 258, 140, 20);
		contentPane.add(txt_Time);
		txt_Time.setColumns(10);

		txt_Payment = new JTextField();
		txt_Payment.setBounds(248, 299, 140, 20);
		contentPane.add(txt_Payment);
		txt_Payment.setColumns(10);

		// Button to update customer details
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					// Update customer details in the database
					DBConnection c = new DBConnection();
					String s1 = c1.getSelectedItem();
					String s2 = txt_ID.getText(); // Room number
					String s3 = txt_Status.getText(); // Name
					String s4 = txt_Date.getText(); // Checked-in status
					String s5 = txt_Time.getText(); // Amount paid
					c.s.executeUpdate("update customer set room_number = '" + s2 + "', name = '" + s3 + "', status = '" + s4 + "', deposit = '" + s5 + "' where number = '" + s1 + "'");
					JOptionPane.showMessageDialog(null, "Data Updated Successfully");
					new Reception().setVisible(true);
					setVisible(false);
				} catch (Exception ee) {
					System.out.println(ee);
				}
			}
		});
		btnUpdate.setBounds(168, 378, 89, 23);
		btnUpdate.setBackground(Color.BLACK);
		btnUpdate.setForeground(Color.WHITE);
		contentPane.add(btnUpdate);

		// Button to navigate back to Reception window
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Reception().setVisible(true);
				setVisible(false);
			}
		});
		btnExit.setBounds(281, 378, 89, 23);
		btnExit.setBackground(Color.BLACK);
		btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);


		// Button to retrieve customer details
		JButton btnAdd = new JButton("Check");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String s1 = c1.getSelectedItem();
					DBConnection c = new DBConnection();
					ResultSet rs1 = c.s.executeQuery("select * from customer where number = " + s1);

					// Populate text fields with fetched details
					while (rs1.next()) {
						txt_ID.setText(rs1.getString("room_number"));
						txt_Status.setText(rs1.getString("name"));
						txt_Date.setText(rs1.getString("status"));
						txt_Time.setText(rs1.getString("deposit"));
					}

					// Calculate pending amount
					try {
						String total = "";
						ResultSet rs2 = c.s.executeQuery("select * from room where room_number = " + txt_ID.getText());
						while (rs2.next()) {
							total = rs2.getString("price");
						}
						String paid = txt_Time.getText();
						int pending = Integer.parseInt(total) - Integer.parseInt(paid);
						txt_Payment.setText(Integer.toString(pending));
					} catch (Exception ee) {
						throw new RuntimeException(ee);
					}
				} catch (Exception ee) {
					throw new RuntimeException(ee);
				}
			}
		});
		btnAdd.setBounds(56, 378, 89, 23);
		btnAdd.setBackground(Color.BLACK);
		btnAdd.setForeground(Color.WHITE);
		contentPane.add(btnAdd);

		// Set background color of content pane
		getContentPane().setBackground(Color.WHITE);
	}
}