package page;


import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class DatabasePage {

	public static String getData(String columName ) throws Throwable {

		Class.forName("com.mysql.cj.jdbc.Driver");
		String sqlUrl1 = "jdbc:mysql://localhost:3306/me2021";
		String sqlUseName = "root";
		String sqlPassword = "W@$$il@30011990";
		String query = "select * from users";
		// Creating a connection to your local database
		Connection con = DriverManager.getConnection(sqlUrl1, sqlUseName, sqlPassword);
		// Empowering the con ref variable to execute queries
		Statement smt=con.createStatement();
		// Executing query
		ResultSet rs= smt.executeQuery(query);
		
		while(rs.next()) {
			return rs.getString(columName);
		}
		
		return columName;

	}

}
