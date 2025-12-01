package jdbclearning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JdbcSession11 {
	private static final String DBURL = "jdbc:mysql://localhost:3306/rahul3";
	private static final String DBUSERNAME = "demo_user";
	private static final String DBPASS = "demo_pass";
	
	private static final String QUERY = "Insert into Employee Values(?,?,?)";
	
	public static void main(String[] args) throws Exception {
		Connection con = DriverManager.getConnection(DBURL,DBUSERNAME,DBPASS);
		con.setAutoCommit(false);
		
		try {
			PreparedStatement ps = con.prepareStatement(QUERY);
			ps.setInt(1, 101);
			ps.setString(2, "Rohit");
			ps.setDouble(3, 100000.00);
			
			ps.executeUpdate();
			
			con.commit();
			System.out.println("Record Inserted....");
		} catch (Exception e) {
			System.out.println("Transaction Rollback....");
			con.rollback();
		}
		con.close();

	}

}
