package com.rahul;

import java.sql.*;
import java.util.Scanner;

public class PreparedStatementDemo {

    // Step 1️⃣: Define Database connection details (URL, Username, Password)
    // Learning: Every JDBC program needs these to connect to the database.
    private static final String DBURL = "jdbc:mysql://localhost:3306/practice";
    private static final String DBUSER = "demo_user";
    private static final String DBPASS = "demo_pass";

    public static void main(String[] args) throws SQLException {
        
        // Step 2️⃣: Establish Connection with MySQL Database
        // Learning: DriverManager acts as a bridge between Java and Database.
        Connection con = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
        System.out.println("✅ Database Connected Successfully!");

        // Step 3️⃣: Write SQL Query with placeholders (?) for dynamic input
        // Learning: '?' are used to safely pass values and prevent SQL Injection.
        String sql = "INSERT INTO student (id, name, marks) VALUES (?, ?, ?)";

        // Step 4️⃣: Create PreparedStatement object to execute SQL query
        // Learning: PreparedStatement is precompiled and faster for multiple executions.
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        
        // Step 5️⃣: Take user input for the student details
        // Learning: We’ll dynamically insert these values into our table.
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter id: ");
        int id = sc.nextInt();
        System.out.println("Enter name: ");
        sc.nextLine(); // to consume leftover newline
        String name = sc.nextLine();
        System.out.println("Enter marks: ");
        int marks = sc.nextInt();
        
        // Step 6️⃣: Set values to placeholders (1-based index)
        // Learning: Each '?' is replaced with the provided data type safely.
        preparedStatement.setInt(1, id);
        preparedStatement.setString(2, name);
        preparedStatement.setInt(3, marks);
        
        // Step 7️⃣: Execute the query (DML command - INSERT)
        // Learning: executeUpdate() returns number of rows affected.
        int eu = preparedStatement.executeUpdate();
        System.out.println("✅ Record Inserted Successfully! Rows affected: " + eu);

        // Step 8️⃣: (Optional) Fetch and display inserted data for confirmation
        // Learning: Normally, SELECT query should be run separately to verify.
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM student");

        while (rs.next()) {
            System.out.println(
                "ID: " + rs.getInt("id") + 
                ", Name: " + rs.getString("name") + 
                ", Marks: " + rs.getInt("marks")
            );
        }

        // Step 9️⃣: Close resources
        // Learning: Always close connection objects to avoid memory leaks.
        rs.close();
        stmt.close();
        preparedStatement.close();
        con.close();
        sc.close();
    }
}
