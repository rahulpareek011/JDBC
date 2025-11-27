package jdbclearning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcSession7{
	// DBURL
	private static final String DBURL = "jdbc:mysql://localhost:3306/rahul2";
	private static final String DBUSERNAME = "demo_user";
	private static final String DBPASS = "demo_pass";

	// creating query
	private static final String SHOW = "Select * from Pokemon";

	public static void main(String[] args) throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(DBURL, DBUSERNAME, DBPASS);

        // Creating scrollable and sensitive ResultSet
        Statement st = con.createStatement(
        			ResultSet.TYPE_SCROLL_SENSITIVE,
        			ResultSet.CONCUR_UPDATABLE
        		);

        ResultSet rs = st.executeQuery(SHOW);
//        System.out.println(rs.getType());
//        System.out.println("---- Testing next() ----");
//        rs.next();
//        System.out.println("Row 1 → " + rs.getInt("id") + " " + rs.getString("name"));
//        
//
//        System.out.println("---- Testing last() ----");
//        rs.last();
//        System.out.println("Last Row → " + rs.getInt(1) + " " + rs.getString(2));
//
//        System.out.println("---- Testing previous() ----");
//        rs.previous();
//        System.out.println("Second Last Row → " + rs.getInt(1) + " " + rs.getString(2));
//
//        System.out.println("---- Testing absolute(2) ----");
//        rs.absolute(2);
//        System.out.println("Row 2 → " + rs.getInt("id") + " " + rs.getString("name"));
        
        rs.absolute(2);
//        rs.updateString("name", "Meowto");
//        rs.updateRow();
//        System.out.println("Row updated");

        rs.moveToInsertRow();//moves to inserting row number from -1 index
        rs.updateInt("id", 200);//inserting in id
        rs.updateString("name", "Cat");//inserting in name
        rs.insertRow();//cmd to insert this row
        rs.moveToCurrentRow();//now again back to by default row
        
        con.close();
        

	}

}
