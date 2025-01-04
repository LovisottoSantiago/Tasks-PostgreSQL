package org.tasks;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnection {
    private static final Logger logger = Logger.getLogger(DatabaseConnection.class.getName());

    private static final String URL = "jdbc:postgresql://localhost:5432/tasks_db";

    // Connection with the database
    public Connection getConnection(String username, String password) {
        try {
            return DriverManager.getConnection(URL, username, password);
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "An exception has occurred", e);
            return null;
        }
    }


//! <---------- SHOW ALL ITEMS METHOD ---------->
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

//! <---------- INSERT METHOD ---------->
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

//! <---------- DELETE METHOD ---------->
    public void deleteRow(Connection conn, int ID) {
        String query = "SELECT tasks.id AS ID, tasks.title AS TITLE FROM public.tasks WHERE tasks.id = ?";
        String deleteQuery = "DELETE FROM public.tasks WHERE tasks.id = ?";

        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, ID);

            try (ResultSet resultSet = statement.executeQuery()) {
                @SuppressWarnings("resource")
                Scanner scanner = new Scanner(System.in);

                while (resultSet.next()) {
                    int id = resultSet.getInt("ID");
                    String title = resultSet.getString("TITLE");

                    System.out.println("You are going to delete: ");
                    System.out.println("ID: " + id + ", Title: " + title);
                    System.out.println("Is it okay? Y/N: ");
                    String answer = scanner.nextLine();
                    
                    if (answer.toUpperCase().equals("Y")) {
                        try (PreparedStatement deleteStatement = conn.prepareStatement(deleteQuery)) {
                            deleteStatement.setInt(1, ID);

                            int rowsAffected = deleteStatement.executeUpdate();
                            if (rowsAffected > 0) {
                                System.out.println("The task was successfully deleted.\n");
                            } else {
                                System.out.println("No task found with the given ID.\n");
                            }
                        }
                    }
                    else {
                        System.out.println("Nothing happened.\n");
                    }
                }
            }
        }   
        catch (Exception e) {
            logger.log(Level.SEVERE, "Error finding this item in the database", e);
        }
    }



}
