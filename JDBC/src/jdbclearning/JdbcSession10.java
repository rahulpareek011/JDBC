package jdbclearning;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class JdbcSession10 {
	private static final String DBURL = "jdbc:mysql://localhost:3306/task1";
	private static final String DBUSERNAME = "demo_user";
	private static final String DBPASS = "demo_pass";
	
	private static final String QUERY = "call emp_salary(?,?);";
	public static void main(String[] args) throws Exception{
		Connection con = DriverManager.getConnection(DBURL, DBUSERNAME, DBPASS);
		CallableStatement cs = con.prepareCall(QUERY);
		
		/*
		 In MySQL-
		 ========
		Delimiter $$
		Create Procedure emp_salary(in Emp_name varchar(20),out empSalary int)
		Begin
			Select salary into empSalary from Employee where Name=Emp_name;
		end $$

		call emp_salary('Rohit',@Emp_Salary);
		
		//table in MySQL
		id		name		Salary
		101		Rahul		65000
		102		Rohit		60000
		*/
		
		//getting data from IN and Out procedure
		cs.setString(1,"Rohit");
		cs.registerOutParameter(2, Types.FLOAT);
		
		cs.execute();
		System.out.println("Employee Salary: "+cs.getFloat(2));
		
		cs.setString(1,"Rahul");
		cs.registerOutParameter(2, Types.FLOAT);
		
		cs.execute();
		System.out.println("Employee Salary: "+cs.getFloat(2));
		con.close();
	}

}
