package jdbclearning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class JdbcSession9 {
	//private static final String DBURL = "jdbc:mysql://localhost:3306/rahul2";
	private static final String DBURL = "jdbc:mysql://localhost:3306/task1";
	private static final String DBUSERNAME = "demo_user";
	private static final String DBPASS = "demo_pass";
	//private static final String QUERY = "insert into pokemon values(?,?);";
	private static final String QUERY1 = "insert into Employee values(?,?,?);";
	
	public static void main(String[] args) throws Exception {
		Connection con = DriverManager.getConnection(DBURL, DBUSERNAME, DBPASS);
		PreparedStatement ps = con.prepareStatement(QUERY1);

		
//		// Assignment 1 
//		//Q. insert 3 records into table using batch operation with
//		// prepared statement.
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.println("Enter the number of data you want insert: ");
//		int id = sc.nextInt();
//		
//		for(int i=1; i<=id;i++) {
//			System.out.println("Enter the id for pokemon: ");
//			int pokId = sc.nextInt();
//			ps.setInt(1, pokId);
//			sc.nextLine();
//			System.out.println("Enter the name: ");
//			String pokName = sc.nextLine();
//			ps.setString(2, pokName);
//			
//			ps.addBatch();
//			ps.executeBatch();
//		}
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of data you want insert: ");
		int id = sc.nextInt();
		
		for(int i=1;i<=id;i++) {
			System.out.println("Enter the Employee Id: ");
			int empId = sc.nextInt();
			
			sc.nextLine();
			
			System.out.println("Enter the Employee Name: ");
			String empName = sc.nextLine();
			
			System.out.println("Enter the Employee Salary: ");
			double empSalary = sc.nextDouble();
			
			ps.setInt(1, empId);
			ps.setString(2, empName);
			ps.setDouble(3, empSalary);
			
			ps.addBatch();
			ps.executeBatch();
		}
		
		con.close();
	}
}

/*
 * Assignment 1 Q. insert 3 records into table using batch operation with
 * prepared statement.
 * 
 * Assignment 2 Q. Read emoloyee and employee address data from keyword and
 * insert into db table. Emp data : ID NAME & SALARY Address data: CITY, STATE,
 * COUNTRY.
 * 
 * NOTE: Employee data should be inserted into Emp table and address data should
 * be into address table
 */
