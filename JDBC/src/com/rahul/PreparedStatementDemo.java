package com.rahul;
import java.sql.*;
import java.util.Scanner;

public class PreparedStatementDemo {
	private static final String DBURL = "jdbc:mysql://localhost:3306/practice";
	private static final String DBUSER = "demo_user";
	private static final String DBPASS = "demo_pass";

	public static void main(String[] args) throws SQLException {
	    Connection con = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
	    String sql = "INSERT INTO student (id, name, marks) VALUES (?, ?, ?)";
	    PreparedStatement preparedStatement = con.prepareStatement(sql);
	    
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Enter id: ");
	    int id = sc.nextInt();
	    System.out.println("Enter name: ");
	    sc.nextLine();
	    String name = sc.nextLine();
	    System.out.println("Enter marks: ");
	    int marks = sc.nextInt();
	    
	    preparedStatement.setInt(1, id); // 1st placeholder
	    preparedStatement.setString(2, name);// 2nd placeholder
	    preparedStatement.setDouble(3, marks);   // 3rd placeholder
	    
	    
	    
	    int eu = preparedStatement.executeUpdate();
	    System.out.println(eu);
//	    while (rs.next()) {
//            System.out.println(
//                "ID: " + rs.getInt("id") + 
//                ", Name: " + rs.getString("name") + 
//                ", Marks: " + rs.getInt("age")
//            );
//        }
	    
	    
	}

}
