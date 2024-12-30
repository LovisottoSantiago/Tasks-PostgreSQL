package org.tasks;

import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DatabaseConnection db = new DatabaseConnection();
        Connection connection = db.getConnection();

        if (connection != null){
            System.out.println("Connection successfully");
        } else {
            System.out.println("Connection error");
        }

        if (connection != null) {
                    try (Scanner scanner = new Scanner(System.in)) {
                        System.out.print("Enter task title: ");
                        String title = scanner.nextLine();

                        System.out.print("Enter task description: ");
                        String description = scanner.nextLine();

                        db.insertRow(connection, title, description);
                    }
                }

    }




}