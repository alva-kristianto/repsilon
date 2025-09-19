package com.catatantech.re;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PostgresSelectExample {
    public static void main(String[] args) {
        // Database connection parameters
        String url = "jdbc:postgresql://localhost:5432/your_database";
        String user = "your_username";
        String password = "your_password";

        // SQL query to select records
        String query = "select * from kebun.hasil_panen;"; // Replace 'employees' with your table name

        try {
            // Register PostgreSQL JDBC driver
            Class.forName("org.postgresql.Driver");

            // Establish connection
            Connection conn = DriverManager.getConnection(url, user, password);
            
            // Create statement
            Statement stmt = conn.createStatement();
            
            // Execute query and get results
            ResultSet rs = stmt.executeQuery(query);
            
            // Process results
            while (rs.next()) {
                // Assuming employees table has columns: id, first_name, last_name
                int id = rs.getInt("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                
                System.out.println("ID: " + id + ", First Name: " + firstName + ", Last Name: " + lastName);
            }
            
            // Close resources
            rs.close();
            stmt.close();
            conn.close();
            
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}