package jdbclearning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class JDBCSession6 {
	//DBURL
		private static final String DBURL = "jdbc:mysql://localhost:3306/Customer";
		private static final String DBUSERNAME = "demo_user";
		private static final String DBPASS = "demo_pass";
		
		//creating query 
		private static final String INSERTDATA="INSERT INTO Customer VALUES (?, ?, ?)";

	public static void main(String[] args) throws Exception {
		Connection con = DriverManager.getConnection(DBURL,DBUSERNAME,DBPASS);
		PreparedStatement ps = con.prepareStatement(INSERTDATA);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Customer id: ");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter the Customer Name: ");
		String name = sc.nextLine();
		System.out.println("Enter the Customer City: ");
		String city = sc.nextLine();
		
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setString(3, city);
		
		int rowAffected = ps.executeUpdate();
		System.out.println(rowAffected);

	}
	//From Home Task
	//result set
	//type_scrrolable_sensitive
	//type_scrrolable_Insensitive
	//conquer_read_only
	//conquer_update_only
	
	//methods in resultset
	//next,absolute,getInt(Integer i),getInt(String st),last,previous
}
