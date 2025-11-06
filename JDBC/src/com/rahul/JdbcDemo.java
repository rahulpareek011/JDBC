package com.rahul;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Statement;

public class JdbcDemo {
	//DBURL
	private static final String DBURL = "jdbc:mysql://localhost:3306/demo";
	private static final String DBUSERNAME = "user_name";
	private static final String DBPASS = "your_Password";
	
	//creating query 
	private static final String INSERTDATA="SELECT * FROM student";
	
    public static void main(String[] args) throws Exception{
    	//step 01 - load the driver(sitting on any package that sometimes causes class not found exception)
    	Class.forName("com.mysql.cj.jdbc.Driver");//forName() is a static method that loads a class dynamically at runtime.
    	
    	//step 02 - get the connection(It is an interface so create reference)
    	Connection con = DriverManager.getConnection(DBURL,DBUSERNAME,DBPASS);
    	//- Uses DriverManager to establish connection with your DB.
    	//- If everything is correct (URL, username, password), it returns a `Connection` object.
    	
    	//step 03 - create the statement(interface)
    	Statement stmt = con.createStatement();
    	//- Statement is used to send SQL queries to the database.
    	//- Think of it as a “messenger” that sends your SQL string
    	
    	
    	//step 04 - execute a query - two main types of execution methods-
    	//executeUpdate() -> use for non-select query(INSERT,UPDATE,DELETE) & it returns int (no. of rows affected)
    	//executeQuery() -> used for SELECT query & it returns ResultSet
    	//So here,
    	//since you’re selecting, you use executeQuery()
    	ResultSet rs = stmt.executeQuery(INSERTDATA);
    	
    	// Step 5: Process the result
        System.out.println("\nStudent Table Data:");
        while (rs.next()) {
            System.out.println(
                "ID: " + rs.getInt("id") + 
                ", Name: " + rs.getString("name") + 
                ", Age: " + rs.getInt("age")
            );
        }
    	System.out.println("Connection Successfully executed");
    	
    	//step 06 - close the connection 
    	con.close();
    	//Always close connection after finishing your database work.
    	//It releases memory and the network link to the MySQL server.
    	
    	//Summary — Flow in One Line
    	//Driver → Connection → Statement → Execute Query → ResultSet → Close Connection
    }
}

