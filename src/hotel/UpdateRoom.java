package hotel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.ResultSet;

/**
 * This class provides functionality to update room status in the hotel management system.
 */
public class UpdateRoom extends JFrame {
	private JPanel contentPane;
	private JTextField txt_Ava;
	private JTextField txt_Status;
	private JTextField txt_Room;
	private Choice c1;

	/**
	 * Launches the UpdateRoom frame.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				UpdateRoom frame = new UpdateRoom();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	/**
	 * Closes the current frame.
	 */
	public void close() {
		this.dispose();
	}

	/**
	 * Creates the frame for updating room status.
	 */
	public UpdateRoom() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(530, 200, 1000, 450);
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

		// Add background image
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
		Image i3 = i1.getImage().getScaledInstance(550, 250, Image.SCALE_DEFAULT);
		ImageIcon i2 = new ImageIcon(i3);
		JLabel l1 = new JLabel(i2);
		l1.setBounds(400, 80, 600, 250);
		add(l1);

		// Label for the title
		JLabel lblUpdateRoomStatus = new JLabel("Update Room Status");
		lblUpdateRoomStatus.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUpdateRoomStatus.setBounds(85, 11, 206, 34);
		contentPane.add(lblUpdateRoomStatus);

		// Label and choice for selecting guest ID
		JLabel lblNewLabel = new JLabel("Guest ID:");
		lblNewLabel.setBounds(27, 87, 90, 14);
		contentPane.add(lblNewLabel);
		c1 = new Choice();
		try {
			DBConnection c = new DBConnection();
			ResultSet rs = c.s.executeQuery("select * from customer");
			while (rs.next()) {
				c1.add(rs.getString("number"));
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		c1.setBounds(160, 84, 140, 20);
		contentPane.add(c1);

		// Labels and text fields for displaying and updating room availability and clean status
		JLabel lblAvailability = new JLabel("Availability:");
		lblAvailability.setBounds(27, 187, 90, 14);
		contentPane.add(lblAvailability);
		JLabel lblCleanStatus = new JLabel("Clean Status:");
		lblCleanStatus.setBounds(27, 240, 90, 14);
		contentPane.add(lblCleanStatus);
		txt_Ava = new JTextField();
		txt_Ava.setBounds(160, 184, 140, 20);
		contentPane.add(txt_Ava);
		txt_Ava.setColumns(10);
		txt_Status = new JTextField();
		txt_Status.setBounds(160, 237, 140, 20);
		contentPane.add(txt_Status);
		txt_Status.setColumns(10);

		// Text field for displaying the room number
		txt_Room = new JTextField();
		txt_Room.setBounds(160, 130, 140, 20);
		contentPane.add(txt_Room);
		txt_Room.setColumns(10);



		// Button to check and display room details
		JButton b1 = new JButton("Check");
		b1.addActionListener(e -> {
			try {
				String s1 = c1.getSelectedItem();
				DBConnection c = new DBConnection();
				ResultSet rs1 = c.s.executeQuery("select * from customer where number = " + s1);
				while (rs1.next()) {
					txt_Room.setText(rs1.getString("room_number"));
				}
			} catch (Exception ee) {
				throw new RuntimeException(ee);
			}
			try {
				DBConnection c = new DBConnection();
				ResultSet rs2 = c.s.executeQuery("select * from room where room_number = " + txt_Room.getText());
				while (rs2.next()) {
					txt_Ava.setText(rs2.getString("availability"));
					txt_Status.setText(rs2.getString("clean_status"));
				}
			} catch (Exception ee) {
				throw new RuntimeException(ee);
			}
		});
		b1.setBounds(120, 315, 89, 23);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		contentPane.add(b1);



		// Button to update room clean status
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(e -> {
			try {
				// Establish database connection
				DBConnection c = new DBConnection();
				// Construct SQL query to update room clean status
				String str = "update room set clean_status = '" + txt_Status.getText() + "' where room_number = " + txt_Room.getText();
				// Execute the update query
				c.s.executeUpdate(str);
				// Show message for successful update
				JOptionPane.showMessageDialog(null, "Update Successful");
				// Navigate back to the reception screen
				new Reception().setVisible(true);
				// Close the current window
				setVisible(false);
			} catch (Exception ee) {
				// Print stack trace for any exceptions
				ee.printStackTrace();
			}
		});
		// Set bounds for the update button
		btnUpdate.setBounds(60, 355, 89, 23);
		// Set background color to black
		btnUpdate.setBackground(Color.BLACK);
		// Set foreground color to white
		btnUpdate.setForeground(Color.WHITE);
		// Add the update button to the content pane
		contentPane.add(btnUpdate);

		// Button to go back to the reception screen
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(e -> {
			// Show the reception screen
			new Reception().setVisible(true);
			// Close the current window
			setVisible(false);
		});
		// Set bounds for the exit button
		btnExit.setBounds(180, 355, 89, 23);
		// Set background color to black
		btnExit.setBackground(Color.BLACK);
		// Set foreground color to white
		btnExit.setForeground(Color.WHITE);
		// Add the exit button to the content pane
		contentPane.add(btnExit);

		// Label for the room number
		JLabel lblRoomId = new JLabel("Room Number:");
		// Set bounds for the room number label
		lblRoomId.setBounds(27, 133, 100, 14);
		// Add the room number label to the content pane
		contentPane.add(lblRoomId);

		// Set the background color of the content pane to white
		getContentPane().setBackground(Color.WHITE);
	}
}