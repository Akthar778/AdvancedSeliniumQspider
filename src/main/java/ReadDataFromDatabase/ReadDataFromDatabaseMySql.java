package ReadDataFromDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.jdbc.Driver;

public class ReadDataFromDatabaseMySql {
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
		
		//stet 5 exute query to fetch data
		ResultSet results = statement.executeQuery("select * from employee;");
		while (results.next()) {
			System.out.println(results.getInt("empID")+" "+results.getString("name"));
		}
		
		//step 6 close database
		connection.close();
	}

}
