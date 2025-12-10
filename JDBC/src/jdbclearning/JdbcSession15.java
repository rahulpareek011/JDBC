package jdbclearning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

//In this session passing SQL format date to database date column and then retrieving from there

public class JdbcSession15 {
	private static final String URL = "jdbc:mysql://localhost:3306/rahul5";
	private static final String UNAME = "demo_user";
	private static final String UPASS = "demo_pass";
	
	private static final String QUERY = "insert into employees values(?,?,?,?);"; 
	private static final String QUERY2 = "Select DepositDate from employees";
	
	public static void main(String[] args) throws ParseException, SQLException {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Give date and time in the format of (dd-mm-yyyy)");
//		String udate = sc.nextLine();
		
//		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");//asking for a date like this parameter type
//		java.util.Date df = sdf.parse(udate);
		
		//System.out.println(df);
		
		//long value = df.getTime();
		//System.out.println(value);//stmp format
		
//		java.sql.Date sqlDate = new java.sql.Date(value);
//		System.out.println(sqlDate);
		
		Connection con = DriverManager.getConnection(URL,UNAME,UPASS);
		
//		PreparedStatement ps = con.prepareStatement(QUERY);
//		ps.setInt(1, 102);
//		ps.setString(2, "rohit");
//		ps.setInt(3, 200000);
//		ps.setDate(4, sqlDate);
//		
//		int rowAffected = ps.executeUpdate();
//		System.out.println("Row Affected: "+rowAffected);
		
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(QUERY2);
		while(rs.next()) {
			Date d = rs.getDate("DepositDate");
			System.out.println(d);
		}	
	}

}
