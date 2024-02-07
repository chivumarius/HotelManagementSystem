package hotel;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener {

        JLabel l1;
        JButton b1;

        public HotelManagementSystem() {
                // Schedule the Swing components creation on the event dispatch thread
                SwingUtilities.invokeLater(() -> {
                        // Set frame properties
                        setSize(1366, 430);
                        setLayout(null);

                        // Load and set background image
                        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
                        Image i3 = i1.getImage().getScaledInstance(1366, 390, Image.SCALE_DEFAULT);
                        ImageIcon i2 = new ImageIcon(i3);
                        l1 = new JLabel(i2);
                        l1.setBounds(0, 0, 1366, 390);
                        add(l1);

                        // Add label with text
                        JLabel lid = new JLabel("Hotel Management System");
                        lid.setBounds(30, 200, 1500, 100);
                        lid.setFont(new Font("serif", Font.PLAIN, 70));
                        lid.setForeground(Color.white);
                        l1.add(lid);

                        // Add "Next" button centered under the text
                        b1 = new JButton("Next");
                        b1.setBackground(Color.WHITE);
                        b1.setForeground(Color.BLACK);
                        b1.setBounds(600, 325, 150, 50); // Centered under the text
                        add(b1);

                        // Timer for the blinking effect
                        Timer timer = new Timer(500, new ActionListener() {
                                private boolean visible = true;

                                @Override
                                public void actionPerformed(ActionEvent e) {
                                        SwingUtilities.invokeLater(() -> {
                                                lid.setVisible(visible);
                                                b1.repaint(); // Force repaint of the button
                                        });
                                        visible = !visible;
                                }
                        });
                        timer.start();

                        // Add action listener for the button
                        b1.addActionListener(this);

                        // Center the JFrame on the screen
                        setLocationRelativeTo(null);

                        // Set frame visibility
                        setVisible(true);
                });
        }

        // Action performed when the button is clicked
        public void actionPerformed(ActionEvent ae) {
                // Open the Login window and hide the current window
                new Login().setVisible(true);
                this.setVisible(false);
        }

        // Main method to start the application
        public static void main(String[] args) {
                new HotelManagementSystem();
        }
}