package jdbclearning;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


//learning how to retrieve the BLOB Image

public class JdbcSession13 {
	private static final String DBURL = "jdbc:mysql://localhost:3306/rahul4";
	private static final String DBUSERNAME = "demo_user";
	private static final String DBPASS = "demo_pass";

	private static final String QUERY = "SELECT * FROM rahul4.person_img2;";
		
		public static void main(String[] args) throws Exception {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection(DBURL, DBUSERNAME, DBPASS);
			PreparedStatement pstmt = con.prepareStatement(QUERY);
			Statement stmt = con.createStatement();
//			pstmt.setInt(1, 101);
//			pstmt.setString(2, "Bholi 2");
//			FileInputStream fis = new FileInputStream("C:\\Users\\hp\\Downloads\\BLOBPractice.png");
//			pstmt.setBinaryStream(3, fis, fis.available());
//			int r = pstmt.executeUpdate();
//			System.out.println("Record Inserted: " + r);
			
			
			//Retrieving the data
			//file path to save that exact image
			String filePath = "C:\\Users\\hp\\OneDrive\\Desktop\\Image\\BLOBPractice.png";
			
			ResultSet rs = pstmt.executeQuery(QUERY);
			if(rs.next()==true) {
				Blob blob = rs.getBlob("pimage");
				InputStream is = blob.getBinaryStream();
				FileOutputStream fos = new FileOutputStream(filePath);
				//byte[] buffer = new byte[1024];
				int by;
				while((by=is.read())!=-1) {
					fos.write(by);
				}
			}
			System.out.println("Image retrieved to this path: "+ filePath);
			

		}

}

