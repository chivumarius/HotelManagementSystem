package hotel;

import javax.swing.*;
import java.awt.*;

public class Dashboard extends JFrame {

    public static void main(String[] args) {
        // Create and display the dashboard window
        new Dashboard().setVisible(true);
    }

    public Dashboard() {
        super("Hotel Management System");

        // Set layout to BorderLayout for better component positioning
        setLayout(new BorderLayout());

        // Load and set background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1950, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel backgroundLabel = new JLabel(i3);
        add(backgroundLabel, BorderLayout.CENTER); // Adding backgroundLabel to the center

        // Create a panel for vertical spacing
        JPanel topPanel = new JPanel();
        topPanel.setOpaque(false); // Make the panel transparent
        topPanel.setPreferredSize(new Dimension(1950, 100)); // Set the desired distance from the top
        backgroundLabel.setLayout(new BorderLayout()); // Set layout for backgroundLabel
        backgroundLabel.add(topPanel, BorderLayout.NORTH); // Adding topPanel to the top

        // Add label for system welcome message over the image with top margin
        JLabel systemWelcomeLabel = new JLabel("Our Hotel Welcomes You");
        systemWelcomeLabel.setForeground(Color.WHITE);
        systemWelcomeLabel.setFont(new Font("Tahoma", Font.PLAIN, 46));
        systemWelcomeLabel.setHorizontalAlignment(SwingConstants.CENTER); // Center text horizontally
        systemWelcomeLabel.setBorder(BorderFactory.createEmptyBorder(40, 0, 0, 0)); // Add top margin
        backgroundLabel.add(systemWelcomeLabel, BorderLayout.NORTH); // Adding systemWelcomeLabel to the top

        // Create menu bar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        // Add menu items for hotel management system
        JMenu hotelManagementMenu = new JMenu("Hotel Management");
        hotelManagementMenu.setForeground(Color.BLACK); // Set menu text color to black
        menuBar.add(hotelManagementMenu);

        JMenuItem receptionMenuItem = new JMenuItem("Reception");
        hotelManagementMenu.add(receptionMenuItem);

        // Add menu items for admin functions
        JMenu adminMenu = new JMenu("Admin");
        adminMenu.setForeground(Color.BLACK); // Set menu text color to black
        menuBar.add(adminMenu);

        // Add menu items for admin actions (Add Employee, Add Rooms, Add Drivers)
        JMenuItem addEmployeeMenuItem = new JMenuItem("Add Employee");
        adminMenu.add(addEmployeeMenuItem);

        // ActionListener for Add Employee menu item
        addEmployeeMenuItem.addActionListener(ae -> {
            try {
                new AddEmployee().setVisible(true);
            } catch(Exception e) {
                throw new RuntimeException(e);
            }
        });

        JMenuItem addRoomsMenuItem = new JMenuItem("Add Rooms");
        adminMenu.add(addRoomsMenuItem);

        // ActionListener for Add Rooms menu item
        addRoomsMenuItem.addActionListener(ae -> {
            try {
                new AddRoom().setVisible(true);
            } catch(Exception e) {
                throw new RuntimeException(e);
            }
        });

        // ActionListener for Reception menu item
        receptionMenuItem.addActionListener(ae -> new Reception());

        JMenuItem addDriversMenuItem = new JMenuItem("Add Drivers");
        adminMenu.add(addDriversMenuItem);

        // ActionListener for Add Drivers menu item
        addDriversMenuItem.addActionListener(ae -> {
            try {
                new AddDrivers().setVisible(true);
            } catch(Exception e) {
                throw new RuntimeException(e);
            }
        });

        // Set size, visibility, and background color
        setSize(1950, 1090);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
    }
}
