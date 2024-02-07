package hotel;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AddEmployee extends JFrame {

    JTextField textField, textField_1, textField_2, textField_3, textField_4, textField_5, textField_6;
    JComboBox<String> c1;


    public AddEmployee(){
        getContentPane().setForeground(Color.BLUE);
        getContentPane().setBackground(Color.WHITE);
        setTitle("Add Employee Details");




        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(778,486);
        getContentPane().setLayout(null);



        JLabel PassportNo = new JLabel("Name");
        PassportNo.setFont(new Font("Tahoma", Font.PLAIN, 17));
        PassportNo.setBounds(60, 30, 150, 27);
        add(PassportNo);

        textField = new JTextField();
        textField.setBounds(200, 30, 150, 27);
        add(textField);

        JButton Next = new JButton("Save");
        Next.setBounds(200, 420, 150, 30);
        Next.setBackground(Color.BLACK);
        Next.setForeground(Color.WHITE);
        add(Next);

        JLabel Age = new JLabel("Age");
        Age.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Age.setBounds(60, 80, 150, 27);
        add(Age);

        textField_1 = new JTextField();
        textField_1.setBounds(200, 80, 150, 27);
        add(textField_1);

        JLabel Gender = new JLabel("Gender");
        Gender.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Gender.setBounds(60, 120, 150, 27);
        add(Gender);

        JRadioButton NewRadioButton = new JRadioButton("MALE");
        NewRadioButton.setBackground(Color.WHITE);
        NewRadioButton.setBounds(200, 120, 70, 27);
        add(NewRadioButton);

        JRadioButton Female = new JRadioButton("FEMALE");
        Female.setBackground(Color.WHITE);
        Female.setBounds(280, 120, 70, 27);
        add(Female);


        JLabel job = new JLabel("Job");
        job.setFont(new Font("Tahoma", Font.PLAIN, 17));
        job.setBounds(60, 170, 150, 27);
        add(job);

        String[] course = {"Front Desk Clerks", "Porters", "Housekeeping", "Kitchen Staff", "Room Service", "Waiter/Waitress", "Manager", "Accountant", "Chef"};
        c1 = new JComboBox<>(course);
        c1.setBackground(Color.WHITE);
        c1.setBounds(200,170,150,30);
        add(c1);

        JLabel Nationality = new JLabel("Salary");
        Nationality.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Nationality.setBounds(60, 220, 150, 27);
        add(Nationality);

        textField_3 = new JTextField();
        textField_3.setBounds(200, 220, 150, 27);
        add(textField_3);

        JLabel Name = new JLabel("Phone");
        Name.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Name.setBounds(60, 270, 150, 27);
        add(Name);

        textField_4 = new JTextField();
        textField_4.setBounds(200, 270, 150, 27);
        add(textField_4);

        JLabel PIN = new JLabel("Personal Identification Number");
        PIN.setFont(new Font("Tahoma", Font.PLAIN, 17));
        PIN.setBounds(60, 320, 150, 27);
        add(PIN);

        textField_5 = new JTextField();
        textField_5.setBounds(200, 320, 150, 27);
        add(textField_5);


        JLabel email = new JLabel("Email");
        email.setFont(new Font("Tahoma", Font.PLAIN, 17));
        email.setBounds(60, 370, 150, 27);
        add(email);

        textField_6 = new JTextField();
        textField_6.setBounds(200, 370, 150, 27);
        add(textField_6);

        setVisible(true);


        JLabel AddPassengers = new JLabel("Add Employee Details");
        AddPassengers.setForeground(Color.BLUE);
        AddPassengers.setFont(new Font("Tahoma", Font.PLAIN, 31));
        AddPassengers.setBounds(450, 24, 442, 35);
        add(AddPassengers);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 500,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel image = new JLabel(i2);
        image.setBounds(410,80,480,410);
        add(image);


        Next.addActionListener(ae -> {
            String name = textField.getText();
            String age = textField_1.getText();
            String salary = textField_3.getText();
            String phone = textField_4.getText();
            String personal_identification_number = textField_5.getText();
            String email1 = textField_6.getText();

            String gender = null;

            if(NewRadioButton.isSelected()){
                gender = "male";

            }else if(Female.isSelected()){
                gender = "female";
            }


            String s6 = (String)c1.getSelectedItem();

            try {
                DBConnection c = new DBConnection();
                String str = "INSERT INTO employee values( '" + name + "', '" + age + "', '" + gender + "','" + s6 + "', '" + salary  + "', '" + phone + "','" + personal_identification_number + "', '"+ email1 +"')";

                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"Employee Added");
                setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        setSize(900,600);
        setVisible(true);
        setLocation(530,200);


        getContentPane().setForeground(Color.BLUE);
        getContentPane().setBackground(Color.WHITE);
        setTitle("Add Employee Details");

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(900, 600);
        setLayout(null);



        // Calculate the central position
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();
        int frameWidth = getWidth();
        int frameHeight = getHeight();

        int x = (screenWidth - frameWidth) / 2;
        int y = (screenHeight - frameHeight) / 2;

        setLocation(x, y);


        // Event listener for window movement
        addComponentListener(new ComponentAdapter() {
            public void componentMoved(ComponentEvent e) {
                // If the window is moved, reposition it to the center of the screen
                int frameX = getLocation().x;
                int frameY = getLocation().y;
                int newX = frameX + (frameWidth / 2);
                int newY = frameY + (frameHeight / 2);

                setLocation(newX - (frameWidth / 2), newY - (frameHeight / 2));
            }
        });


        setVisible(true);
    }


    public static void main(String[] args) {
        new AddEmployee();
    }
}