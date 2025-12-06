package jdbclearning;

import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class JdbcDemo14 {

	public static void main(String[] args) throws ParseException{
		//1.Read the input from the user
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the date::(dd-mm-yyyy)");
			String sdate = sc.next();

			//2. Convert the date from string to java.util.Date
			SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
			java.util.Date udate = sdf.parse(sdate);

			//3. Covert java.util.Date to java.sql.Date
			long value = udate.getTime();
			java.sql.Date sqlDate = new java.sql.Date(value);

			//4.Printing the Data
			System.out.println("String format date is: "+ sdate);
			System.out.println("Util Date: "+udate);
			System.out.println("sqlDate is: "+sqlDate);
	}

}
