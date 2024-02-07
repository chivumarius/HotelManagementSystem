package hotel;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    // Components for the login window
    JLabel l1, l2;
    JTextField t1;
    JPasswordField t2;
    JButton b1, b2;

    // Constructor to initialize the login window
    Login() {
        super("Login");

        // Set layout to null for manual component placement
        setLayout(null);

        // Username label
        l1 = new JLabel("Username");
        l1.setBounds(40, 20, 100, 30);
        add(l1);

        // Password label
        l2 = new JLabel("Password");
        l2.setBounds(40, 70, 100, 30);
        add(l2);

        // Username text field
        t1 = new JTextField();
        t1.setBounds(150, 20, 150, 30);
        add(t1);

        // Password field for secure input
        t2 = new JPasswordField();
        t2.setBounds(150, 70, 150, 30);
        add(t2);

        // Logo image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(350, 10, 150, 150);
        add(l3);

        // Login button
        b1 = new JButton("Login");
        b1.setBounds(40, 140, 120, 30);
        b1.setFont(new Font("serif", Font.BOLD, 15));
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1);

        // Cancel button
        b2 = new JButton("Cancel");
        b2.setBounds(180, 140, 120, 30);
        b2.setFont(new Font("serif", Font.BOLD, 15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        add(b2);

        b2.addActionListener(this);

        // Set background color
        getContentPane().setBackground(Color.WHITE);

        // Set window visibility and size
        setSize(600, 300);
        // Center the window on the screen
        setLocationRelativeTo(null);
        // Close the application when the window is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set window visibility after all components are added
        setVisible(true);
    }

    // ActionListener method to handle button clicks
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            try {
                // Establish database connection
                DBConnection c1 = new DBConnection();
                String u = t1.getText();
                String v = new String(t2.getPassword()); // Use getPassword() for security

                // Check login credentials
                String q = "select * from login where username='" + u + "' and password='" + v + "'";
                ResultSet rs = c1.s.executeQuery(q);

                if (rs.next()) {
                    // If login is successful, open Dashboard
                    new Dashboard().setVisible(true);
                    setVisible(false);
                } else {
                    // If login fails, show error message
                    JOptionPane.showMessageDialog(null, "Invalid login");
                    setVisible(false);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == b2) {
            // Close the application if Cancel button is clicked
            System.exit(0);
        }
    }

    // Main method to start the Login window
    public static void main(String[] arg) {
        new Login();
    }
}