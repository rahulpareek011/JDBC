package crudOperation;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CrudOperations {
	//DBURL
		private static final String DBURL = "jdbc:mysql://localhost:3306/crud";
		private static final String DBUSERNAME = "demo_user";
		private static final String DBPASS = "demo_pass";
		
		private static String insertQuery = "insert into student(id,name,address,marks) values(?,?,?,?)";
		private static String delKey = "delete from student where id=?";
		
		
		public static void insertData(String tabName) throws Exception {
			Connection con = DriverManager.getConnection(DBURL,DBUSERNAME,DBPASS);
			PreparedStatement ps = con.prepareStatement(insertQuery);
			
			Scanner sc = new Scanner(System.in);
			System.out.println("how many rows u want to insert: ");
			int rowNo = sc.nextInt();
			
			if(rowNo>0) {
				do {
					System.out.println("Enter id: ");
				    int id = sc.nextInt();
				    System.out.println("Enter name: ");
				    sc.nextLine();
				    String name = sc.nextLine();
				    System.out.println("Enter address: ");
				    String address = sc.nextLine();
				    System.out.println("Enter marks: ");
				    int marks = sc.nextInt();
				    
				    ps.setInt(1, id);
					ps.setString(2, name);
					ps.setString(3, address);
					ps.setInt(4, marks);
				    rowNo--;
				    
				    int row = ps.executeUpdate();
					if(row>=1) {
						System.out.println("data inserted");
					} else {
						System.out.println("data not inserted");
					}				
				} while(rowNo>0);
			} else {
				System.out.println("Enter atleast 1");
			}
		}
		
		
		public void readTable(String tabName) throws Exception {
			String query = "Select * from "+tabName;
			
			
			Connection con = DriverManager.getConnection(DBURL,DBUSERNAME,DBPASS);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			System.out.println("\nStudent Table Data:");
			while(rs.next()) {
				System.out.println(
						rs.getInt("id") + " " +
						rs.getString("name") + " " +
						rs.getString("address") + " " +
						rs.getString("marks")
				);
				System.out.println("=====================");
			}
			con.close();
		}
		
		
		public void delKey(int key) throws SQLException {
			Connection con = DriverManager.getConnection(DBURL,DBUSERNAME,DBPASS);
			PreparedStatement pd = con.prepareStatement(delKey);
			pd.setInt(1, key);
			
			//int affected = pd.executeUpdate();
//			if(affected>0) {
//				System.out.println(affected+"row deleted");
//			}else {
//				System.out.println("not deleted");
//			}
		}
		
		
		
		
		
		
		
		
		
		
		
}
