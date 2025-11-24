package jdbclearning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCSession5 {
	//DBURL
		private static final String DBURL = "jdbc:mysql://localhost:3306/rahul1";
		private static final String DBUSERNAME = "demo_user";
		private static final String DBPASS = "demo_pass";
		private static final String CreatingTableQuery = "create table Student(sid int,sname varchar(30),scity varchar(20))"; 
		private static final String InsertingIntoTable = "insert into Student values(101,'Rahul','Jaipur')";
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection(DBURL,DBUSERNAME,DBPASS);
		Statement stmt = con.createStatement();
		int rowAffected = stmt.executeUpdate(InsertingIntoTable);
		System.out.println("Row Affected: "+ rowAffected);
		con.close();
	}

}
