package hotel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddRoom extends JFrame implements ActionListener {

    // Panel to hold the components
    private JPanel contentPane;

    // Text fields for room details
    private JTextField t1, t2, t3, t4;

    // Combo boxes for room status and type
    private JComboBox comboBox, comboBox_1, comboBox_2, comboBox_3;

    // Buttons for actions
    JButton b1, b2;

    // Constructor
    public AddRoom() {
        // Set frame dimensions and location
        setBounds(450, 200, 1000, 450);
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

        // Adding image to the frame
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l15 = new JLabel(i2);
        l15.setBounds(400, 30, 500, 370);
        add(l15);

        // Title label
        JLabel l10 = new JLabel("Add Rooms");
        l10.setFont(new Font("Tahoma", Font.BOLD, 18));
        l10.setBounds(194, 10, 120, 22);
        contentPane.add(l10);

        // Room Number label and text field
        JLabel l1 = new JLabel("Room Number");
        l1.setForeground(new Color(25, 25, 112));
        l1.setFont(new Font("Tahoma", Font.BOLD, 14));
        l1.setBounds(64, 70, 102, 22);
        contentPane.add(l1);
        t4 = new JTextField();
        t4.setBounds(174, 70, 156, 20);
        contentPane.add(t4);

        // Availability label and combo box
        JLabel l2 = new JLabel("Availability");
        l2.setForeground(new Color(25, 25, 112));
        l2.setFont(new Font("Tahoma", Font.BOLD, 14));
        l2.setBounds(64, 110, 102, 22);
        contentPane.add(l2);
        comboBox = new JComboBox(new String[]{"Available", "Occupied"});
        comboBox.setBounds(176, 110, 154, 20);
        contentPane.add(comboBox);

        // Cleaning Status label and combo box
        JLabel l3 = new JLabel("Cleaning Status");
        l3.setForeground(new Color(25, 25, 112));
        l3.setFont(new Font("Tahoma", Font.BOLD, 14));
        l3.setBounds(64, 150, 102, 22);
        contentPane.add(l3);
        comboBox_2 = new JComboBox(new String[]{"Cleaned", "Dirty"});
        comboBox_2.setBounds(176, 150, 154, 20);
        contentPane.add(comboBox_2);

        // Price label and text field
        JLabel l4 = new JLabel("Price");
        l4.setForeground(new Color(25, 25, 112));
        l4.setFont(new Font("Tahoma", Font.BOLD, 14));
        l4.setBounds(64, 190, 102, 22);
        contentPane.add(l4);
        t2 = new JTextField();
        t2.setBounds(174, 190, 156, 20);
        contentPane.add(t2);

        // Bed Type label and combo box
        JLabel l5 = new JLabel("Bed Type");
        l5.setForeground(new Color(25, 25, 112));
        l5.setFont(new Font("Tahoma", Font.BOLD, 14));
        l5.setBounds(64, 230, 102, 22);
        contentPane.add(l5);
        comboBox_3 = new JComboBox(new String[]{"Single Bed", "Double Bed"});
        comboBox_3.setBounds(176, 230, 154, 20);
        contentPane.add(comboBox_3);

        // Add button
        b1 = new JButton("Add");
        b1.addActionListener(this);
        b1.setBounds(64, 321, 111, 33);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        contentPane.add(b1);

        // Back button
        b2 = new JButton("Back");
        b2.addActionListener(this);
        b2.setBounds(198, 321, 111, 33);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        contentPane.add(b2);

        // Set background color of the panel
        contentPane.setBackground(Color.WHITE);
    }

    // Action performed method to handle button clicks
    public void actionPerformed(ActionEvent ae) {
        try {
            if (ae.getSource() == b1) {
                try {
                    // Database connection and insertion
                    DBConnection c = new DBConnection();
                    String room = t4.getText();
                    String available = (String) comboBox.getSelectedItem();
                    String status = (String) comboBox_2.getSelectedItem();
                    String price = t2.getText();
                    String type = (String) comboBox_3.getSelectedItem();
                    String str = "INSERT INTO room values( '" + room + "', '" + available + "', '" + status + "','" + price + "', '" + type + "')";
                    c.s.executeUpdate(str);
                    JOptionPane.showMessageDialog(null, "Room Successfully Added");
                    this.setVisible(false);
                } catch (Exception ee) {
                    // Exception handling
                    System.out.println(ee);
                }
            } else if (ae.getSource() == b2) {
                // Close the window
                this.setVisible(false);
            }
        } catch (Exception eee) {
            // Exception handling
            throw new RuntimeException(eee);
        }
    }


    public static void main(String[] args) {
        // Crearea unei instanțe a ferestrei AddRoom și afișarea ei
        SwingUtilities.invokeLater(() -> {
            AddRoom addRoom = new AddRoom();
            addRoom.setVisible(true);
        });
    }
}