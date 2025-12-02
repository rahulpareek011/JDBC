package jdbclearning;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

//BLOB(Binary large object) -> Used to insert image (blob -> for small size image, long blob -> for long size image)

public class JdbcSession12 {
	private static final String DBURL = "jdbc:mysql://localhost:3306/rahul4";
	private static final String DBUSERNAME = "demo_user";
	private static final String DBPASS = "demo_pass";

	private static final String QUERY = "Insert into Person_Img2 Values(?,?,?)";

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection(DBURL, DBUSERNAME, DBPASS);
		PreparedStatement pstmt = con.prepareStatement(QUERY);
		pstmt.setInt(1, 101);
		pstmt.setString(2, "Bholi 2");
		FileInputStream fis = new FileInputStream("C:\\Users\\hp\\Downloads\\BLOBPractice.png");
		pstmt.setBinaryStream(3, fis, fis.available());
		int r = pstmt.executeUpdate();
		System.out.println("Record Inserted: " + r);

	}

}
