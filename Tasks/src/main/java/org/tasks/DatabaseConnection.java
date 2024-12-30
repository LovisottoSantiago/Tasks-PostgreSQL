package org.tasks;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnection {
    private static final Logger logger = Logger.getLogger(DatabaseConnection.class.getName());

    private static final String URL = "jdbc:postgresql://localhost:5432/tasks_db";

    public Connection getConnection() {
        try {
            try (Scanner scanner = new Scanner(System.in)) {
                System.out.print("Please, enter your username: ");
                String username = scanner.nextLine();
                System.out.print("Please, enter your password: ");
                String password = scanner.nextLine();

                return DriverManager.getConnection(URL, username, password);
            }
        }
        catch (SQLException e) {
            logger.log(Level.SEVERE, "An exception has occurred", e);
            return null;
        }
    }

    public void insertRow(Connection conn, String title, String description) {        
        String query = "INSERT INTO tasks (title, description, created_at) VALUES (?, ?, ?)";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, title);
            statement.setString(2, description);
            statement.setTimestamp(3, new Timestamp(System.currentTimeMillis()));

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                    System.out.println("Row inserted");
            }            
        }
        catch (Exception e) {
            logger.log(Level.SEVERE, "Error inserting row into the database", e);
        }

    }



}
