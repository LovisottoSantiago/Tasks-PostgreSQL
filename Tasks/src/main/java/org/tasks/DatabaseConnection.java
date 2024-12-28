package org.tasks;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnection {
    private static final Logger logger = Logger.getLogger(DatabaseConnection.class.getName());

    private static final String URL = "jdbc:postgresql://localhost:5432/tasks_db";

    public static Connection getConnection() {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Please, enter your username: ");
            String username = scanner.nextLine();
            System.out.print("Please, enter your password: ");
            String password = scanner.nextLine();

            return DriverManager.getConnection(URL, username, password);
        }
        catch (Exception e) {
            logger.log(Level.SEVERE, "An exception has occurred", e);
            return null;
        }
    }



}
