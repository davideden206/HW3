package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DB {
	private static  Connection connection;
	private static  Statement statement;
	private static ResultSet resultSet;
	

	public static void main(String[] args) {
		
		try {
			connection = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=HomeWork4DB;integratedSecurity=true;");
			statement = connection.createStatement();
			
			// 3. Execute SQL query
			resultSet = statement.executeQuery("SELECT * FROM Manager");
			
			// 4. Process the result set
			while (resultSet.next()) {
				System.out.println(resultSet.getInt("ID") + ", " + resultSet.getString("Name"));
			}
		}catch (Exception e) {
				System.out.println("not connected");
			}
	}

}
