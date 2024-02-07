package hotel;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Room extends JFrame {
	private JTable table;
	private JLabel lblAvailability;
	private JLabel lblCleanStatus;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblRoomNumber;
	private JLabel lblId;

	public Room() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 200, 1100, 600);
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



		// Load image
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
		Image i3 = i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
		ImageIcon i2 = new ImageIcon(i3);
		JLabel l1 = new JLabel(i2);
		l1.setBounds(500, 0, 600, 600);
		add(l1);

		// Create table
		table = new JTable();
		table.setBounds(0, 40, 500, 400);
		contentPane.add(table);

		// Load data button
		JButton btnLoadData = new JButton("Load Data");
		btnLoadData.addActionListener(e -> loadData());
		btnLoadData.setBounds(100, 470, 120, 30);
		btnLoadData.setBackground(Color.BLACK);
		btnLoadData.setForeground(Color.WHITE);
		contentPane.add(btnLoadData);

		// Back button
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(e -> {
			new Reception().setVisible(true);
			setVisible(false);
		});
		btnNewButton.setBounds(290, 470, 120, 30);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setForeground(Color.WHITE);
		contentPane.add(btnNewButton);

		// Labels
		lblAvailability = new JLabel("Availability");
		lblAvailability.setBounds(119, 15, 69, 14);
		contentPane.add(lblAvailability);

		lblCleanStatus = new JLabel("Clean Status");
		lblCleanStatus.setBounds(216, 15, 76, 14);
		contentPane.add(lblCleanStatus);

		lblNewLabel = new JLabel("Price");
		lblNewLabel.setBounds(330, 15, 46, 14);
		contentPane.add(lblNewLabel);

		lblNewLabel_1 = new JLabel("Bed Type");
		lblNewLabel_1.setBounds(417, 15, 76, 14);
		contentPane.add(lblNewLabel_1);

		lblId = new JLabel("Room Number");
		lblId.setBounds(12, 15, 90, 14);
		contentPane.add(lblId);

		getContentPane().setBackground(Color.WHITE);
	}

	// Method to load data into the table
	private void loadData() {
		try {
			DBConnection c = new DBConnection();
			String displayCustomersql = "select * from Room";
			ResultSet rs = c.s.executeQuery(displayCustomersql);
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// Run the application
		EventQueue.invokeLater(() -> {
			try {
				Room frame = new Room();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
}