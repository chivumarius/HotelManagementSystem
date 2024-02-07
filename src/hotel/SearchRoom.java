package hotel;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// Class for searching for available rooms
public class SearchRoom extends JFrame {
	// Database connection variables
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	// GUI components
	private JPanel contentPane;
	private JTextField txt_Type;
	private JTable table;
	private Choice c1;

	// Main method
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				SearchRoom frame = new SearchRoom();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	// Method to close the frame
	public void close() {
		this.dispose();
	}

	// Constructor
	public SearchRoom() throws SQLException {
		// Setting up the frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(530, 200, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Centering the frame on the screen
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = (int) screenSize.getWidth();
		int screenHeight = (int) screenSize.getHeight();
		int frameWidth = getWidth();
		int frameHeight = getHeight();
		int x = (screenWidth - frameWidth) / 2;
		int y = (screenHeight - frameHeight) / 2;
		setLocation(x, y);

		// Adding labels and components to the frame
		JLabel lblSearchForRoom = new JLabel("Search For Room");
		lblSearchForRoom.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSearchForRoom.setBounds(250, 11, 186, 31);
		contentPane.add(lblSearchForRoom);

		JLabel lblRoomAvailable = new JLabel("Room Bed Type:");
		lblRoomAvailable.setBounds(50, 73, 96, 14);
		contentPane.add(lblRoomAvailable);

		JLabel lblRoomType = new JLabel("Room Number");
		lblRoomType.setBounds(23, 162, 96, 14);
		contentPane.add(lblRoomType);

		JLabel lblRoomAvailable_1 = new JLabel("Availability");
		lblRoomAvailable_1.setBounds(175, 162, 120, 14);
		contentPane.add(lblRoomAvailable_1);

		JLabel lblPrice_1 = new JLabel("Price");
		lblPrice_1.setBounds(458, 162, 46, 14);
		contentPane.add(lblPrice_1);

		JLabel l1 = new JLabel("Bed Type");
		l1.setBounds(580, 162, 96, 14);
		contentPane.add(l1);

		JCheckBox checkRoom = new JCheckBox("Only display Available");
		checkRoom.setBounds(400, 69, 205, 23);
		checkRoom.setBackground(Color.WHITE);
		contentPane.add(checkRoom);

		c1 = new Choice();
		c1.add("Single Bed");
		c1.add("Double Bed");
		c1.setBounds(153, 70, 120, 20);
		contentPane.add(c1);

		// Button to search for rooms
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(e -> {
			String SQL = "select * from Room where bed_type = '" + c1.getSelectedItem() + "'";
			String SQL2 = "select * from Room where availability = 'Available' AND bed_type = '" + c1.getSelectedItem() + "'";
			try {
				DBConnection c = new DBConnection();
				rs = c.s.executeQuery(SQL);
				table.setModel(DbUtils.resultSetToTableModel(rs));

				if (checkRoom.isSelected()) {
					rs = c.s.executeQuery(SQL2);
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}
			} catch (SQLException ss) {
				ss.printStackTrace();
			}
		});
		btnSearch.setBounds(200, 400, 120, 30);
		btnSearch.setBackground(Color.BLACK);
		btnSearch.setForeground(Color.WHITE);
		contentPane.add(btnSearch);

		// Button to go back to reception
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(e -> {
			new Reception().setVisible(true);
			setVisible(false);
		});
		btnExit.setBounds(380, 400, 120, 30);
		btnExit.setBackground(Color.BLACK);
		btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);

		table = new JTable();
		table.setBounds(0, 187, 700, 300);
		contentPane.add(table);

		JLabel lblCleanStatus = new JLabel("Clean Status");
		lblCleanStatus.setBounds(306, 162, 96, 14);
		contentPane.add(lblCleanStatus);

		// Setting background color
		getContentPane().setBackground(Color.WHITE);
	}
}