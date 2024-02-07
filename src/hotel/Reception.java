package hotel;

import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;

/**
 * The Reception class represents the main window for hotel reception management.
 */
public class Reception extends JFrame {

	// Panel to hold the components
	private final JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new Reception();
	}

	/**
	 * Create the frame.
	 */
	public Reception() {

		// Set frame properties
		setBounds(530, 200, 850, 570);
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



		// Load and set background image
		ImageIcon backgroundIcon = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
		Image backgroundImg = backgroundIcon.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
		ImageIcon backgroundImgIcon = new ImageIcon(backgroundImg);
		JLabel backgroundLabel = new JLabel(backgroundImgIcon);
		backgroundLabel.setBounds(250, 30, 500, 470);
		add(backgroundLabel);

		// Create buttons with specific text, Y-coordinate, and ActionListener
		createButton("New Customer Form", 10, 30, e -> {
			try {
				// Open the NewCustomer window and hide the current window
				NewCustomer custom = new NewCustomer();
				custom.setVisible(true);
				setVisible(false);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});

		createButton("Room", 10, 70, e -> {
			try {
				// Open the Room window and hide the current window
				Room room = new Room();
				room.setVisible(true);
				setVisible(false);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});

		createButton("All Employee Info", 10, 150, e -> {
			try {
				// Open the Employee window and hide the current window
				Employee em = new Employee();
				em.setVisible(true);
				setVisible(false);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});

		createButton("Customer Info", 10, 190, e -> {
			try {
				// Open the CustomerInfo window and hide the current window
				CustomerInfo customer = new CustomerInfo();
				customer.setVisible(true);
				setVisible(false);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});

		createButton("Manager Info", 10, 230, e -> {
			try {
				// Open the ManagerInfo window and hide the current window
				ManagerInfo mana = new ManagerInfo();
				mana.setVisible(true);
				setVisible(false);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});

		createButton("Check Out", 10, 270, e -> {
			try {
				// Open the CheckOut window and hide the current window
				CheckOut check = new CheckOut();
				check.setVisible(true);
				setVisible(false);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		});

		createButton("Update Check Status", 10, 310, e -> {
			try {
				// Open the UpdateCheck window and hide the current window
				UpdateCheck update = new UpdateCheck();
				update.setVisible(true);
				setVisible(false);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});

		createButton("Update Room Status", 10, 350, e -> {
			try {
				// Open the UpdateRoom window and hide the current window
				UpdateRoom room = new UpdateRoom();
				room.setVisible(true);
				setVisible(false);
			} catch (Exception s) {
				s.printStackTrace();
			}
		});

		createButton("Pick up Service", 10, 390, e -> {
			try {
				// Open the PickUp window and hide the current window
				PickUp pick = new PickUp();
				pick.setVisible(true);
				setVisible(false);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});

		createButton("Search Room", 10, 430, e -> {
			try {
				// Open the SearchRoom window and hide the current window
				SearchRoom search = new SearchRoom();
				search.setVisible(true);
				setVisible(false);
			} catch (Exception ss) {
				ss.printStackTrace();
			}
		});

		createButton("Log Out", 10, 470, e -> {
			try {
				// Open the Login window and hide the current window
				new Login().setVisible(true);
				setVisible(false);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});

		// Set the background color of the content pane
		getContentPane().setBackground(Color.WHITE);

		// Set frame visibility
		setVisible(true);
	}


	/**
	 * Helper method to create buttons with a specific text, Y-coordinate, and ActionListener.
	 *
	 * @param text      The text displayed on the button
	 * @param x         The X-coordinate of the button
	 * @param y         The Y-coordinate of the button
	 * @param listener  The ActionListener for the button
	 */
	private void createButton(String text, final int x, int y, ActionListener listener) {
		JButton button = new JButton(text);
		button.addActionListener(listener);
		button.setBounds(x, y, 200, 30);
		button.setBackground(Color.BLACK);
		button.setForeground(Color.WHITE);
		contentPane.add(button);
	}
}