package org.tasks;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnection {
    private static final Logger logger = Logger.getLogger(DatabaseConnection.class.getName());

    private static final String URL = "jdbc:postgresql://localhost:5432/tasks_db";

    
    public Connection getConnection(String username, String password) {
        try {
            return DriverManager.getConnection(URL, username, password);
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "An exception has occurred", e);
            return null;
        }
    }


    public void showItems(Connection conn) {
        String query = "SELECT * FROM public.tasks ORDER BY id ASC";
        try (PreparedStatement statement = conn.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery()) {
            
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");                
                System.out.println("ID: " + id + ", Title: " + title);
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error trying to show items in the database");
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
