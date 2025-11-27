package jdbclearning;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class JdbcSession8 {
	private static final String DBURL = "jdbc:mysql://localhost:3306/rahul2";
	private static final String DBUSERNAME = "demo_user";
	private static final String DBPASS = "demo_pass";
	private static final String PROCEDURECALLING = "call getSpecificPokemon(103);";
	public static void main(String[] args) throws Exception {
//		Connection con = DriverManager.getConnection(DBURL,DBUSERNAME,DBPASS);
//		  CallableStatement cstmt = con.prepareCall(PROCEDURECALLING);
//		  ResultSet rs = cstmt.executeQuery();
//		  while(rs.next()) {
//			  System.out.println(rs.getInt(1)+" "+rs.getString(2));
//		  }
//		  con.close();
		
		Connection con = DriverManager.getConnection(DBURL,DBUSERNAME,DBPASS);
		  CallableStatement cstmt = con.prepareCall(PROCEDURECALLING);
		  ResultSet rs = cstmt.executeQuery();
		  rs.next();
		  System.out.println(rs.getInt(1)+" "+rs.getString(2));
		  con.close();
	}

}
