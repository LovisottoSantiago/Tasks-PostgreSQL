package org.tasks;

import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            DatabaseConnection db = new DatabaseConnection();

            System.out.print("Please, enter your username: ");
            String username = scanner.nextLine();

            System.out.print("Please, enter your password: ");
            String password = scanner.nextLine();

            Connection connection = db.getConnection(username, password);

            if (connection != null) {
                System.out.println("Connection successfully\n");
                boolean menu = true; 
                while (menu) {
                    System.out.println("███╗   ███╗███████╗███╗   ██╗██╗   ██╗");
                    System.out.println("████╗ ████║██╔════╝████╗  ██║██║   ██║");
                    System.out.println("██╔████╔██║█████╗  ██╔██╗ ██║██║   ██║");
                    System.out.println("██║╚██╔╝██║██╔══╝  ██║╚██╗██║██║   ██║");
                    System.out.println("██║ ╚═╝ ██║███████╗██║ ╚████║╚██████╔╝");
                    System.out.println("╚═╝     ╚═╝╚══════╝╚═╝  ╚═══╝ ╚═════╝ ");                                     
                    System.out.println("1. Insert a new row");
                    System.out.println("2. Delete a row");
                    System.out.println("3. Show items");
                    System.out.println("4. Exit");
                    System.out.print("Enter your option: ");
                    try {
                        String option = scanner.nextLine();

                        switch (option) {
                            case "1" -> {
                                System.out.print("Enter task title: ");
                                String title = scanner.nextLine();

                                System.out.print("Enter task description: ");
                                String description = scanner.nextLine();

                                db.insertRow(connection, title, description);
                                System.out.println("\nTouch any key to return to the menu");
                                scanner.nextLine();
                            }
                            case "2" -> {
                                db.showItems(connection);
                                System.out.print("Enter the ID of the task to delete: ");
                                int taskId = scanner.nextInt();
                                scanner.nextLine();
                                db.deleteRow(connection, taskId);
                                System.out.println("\nTouch any key to return to the menu");
                                scanner.nextLine();
                            }
                            case "3" -> {
                                db.showItems(connection);                             
                                System.out.println("\nTouch any key to return to the menu");
                                scanner.nextLine();
                            }
                            case "4" -> {
                                System.out.println("Exiting the application. Goodbye!");
                                menu = false;      
                                System.out.println(menu);                          
                                System.exit(0);                                
                            }
                            default -> System.out.println("Invalid option. Please try again.");
                        }
                    } catch (Exception e) {
                        System.out.println("An error occurred: " + e.getMessage());
                        scanner.nextLine();
                    }
                }
            } else {
                System.out.println("Connection error");
            }
        }
    }
}
