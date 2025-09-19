package com.catatantech.re;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.io.FileWriter;
import java.io.IOException;

public class PostgresToCsv {
    public static void main(String[] args) {
        // Database connection parameters
        String url = "jdbc:postgresql://localhost:5432/your_database";
        String user = "your_username";
        String password = "your_password";
        
        // SQL query to select 10 records
        String query = "SELECT * FROM employees LIMIT 10"; // Replace 'employees' with your table name
        
        // CSV file path
        String csvFile = "output.csv";
        
        try {
            // Register PostgreSQL JDBC driver
            Class.forName("org.postgresql.Driver");
            
            // Establish connection
            Connection conn = DriverManager.getConnection(url, user, password);
            
            // Create statement
            Statement stmt = conn.createStatement();
            
            // Execute query
            ResultSet rs = stmt.executeQuery(query);
            
            // Create CSV writer
            FileWriter csvWriter = new FileWriter(csvFile);
            
            // Write CSV header (adjust column names as needed)
            csvWriter.append("ID,First Name,Last Name\n");
            
            // Process and write up to 10 records
            while (rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                
                // Write record to CSV
                csvWriter.append(String.format("%d,%s,%s\n", id, firstName, lastName));
            }
            
            // Close resources
            csvWriter.flush();
            csvWriter.close();
            rs.close();
            stmt.close();
            conn.close();
            
            System.out.println("Data successfully written to " + csvFile);
            
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}