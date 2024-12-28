package org.tasks;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Connection connection = DatabaseConnection.getConnection();

        if (connection != null){
            System.out.println("Connection successfully");
        } else {
            System.out.println("Connection error");
        }

    }




}