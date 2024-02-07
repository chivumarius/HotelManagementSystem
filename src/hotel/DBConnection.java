package hotel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * The DBConnection class establishes a connection to the MySQL database
 * for the Hotel Management System.
 */
public class DBConnection {
    // Connection and Statement objects for database interaction
    private Connection c;
    Statement s;

    /**
     * Constructor for DBConnection.
     * Attempts to establish a connection to the MySQL database.
     */
    public DBConnection() {
        try {
            // Load the new MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection to the database
            String url = "jdbc:mysql://localhost/hotel_management_system";
            String user = "root";
            String password = "";

            c = DriverManager.getConnection(url, user, password);

            // Create a Statement object for executing SQL queries
            s = c.createStatement();

        } catch (ClassNotFoundException | SQLException e) {
            // Handle exceptions, print error details to console
            e.printStackTrace();
        }
    }

    /**
     * Close the database connection.
     */
    public void closeConnection() {
        try {
            if (c != null) {
                c.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}