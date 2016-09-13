package pais;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseWork {
	
	private static Connection connection = null;
	
	public static Connection openConnection() {
		connection = null;
		try {
			connection = DriverManager.getConnection(
		            "jdbc:mysql://localhost:3306/plants_collector",
		            "root", "");
			return connection;
		}    catch (SQLException e){
			System.out.println(e.getMessage());
		}		
		return connection;
	}
	
	public static Connection getConnection() {
		return connection;
	}
	
	public static void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
