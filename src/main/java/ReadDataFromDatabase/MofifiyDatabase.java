package ReadDataFromDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;


public class MofifiyDatabase {
	public static void main(String[] args) throws SQLException {
		//create a instance for JDBC
		Driver dbdriver= new Driver();

		//step2 register driver 
		DriverManager.registerDriver(dbdriver);

		//step 3 establish database connection 
		// google it mysql database url you will getConnection(get mysql database url/here pass database name,username,password)
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc830","root", "0000");//user name //password 

		//step 4 create statement
		Statement statement = connection.createStatement();

		//step 5 execute update query
		int result = statement.executeUpdate("insert into employee (empID,name,Salary,location) values (105,'FDG',9999,'hebbala');");
		System.out.println(result);
		
		
		//step 5 close database
		connection.close();
		
		
	}

}
