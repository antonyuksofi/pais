package pais;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This class gives the instruments to work with
 * connection to the database.
 */

public class DatabaseWork {
	
	/**
	 * A static field for the connection to the database.
	 */
	private static Connection connection = null;
	
	/**
	 * Opens and returns the connection to the database.
	 * 
	 * @return		the opened connection to the database
	 */	
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

	/**
	 * Returns the opened connection to the database.
	 * 
	 * @return		the opened connection to the database
	 */	
	public static Connection getConnection() {
		return connection;
	}

	/**
	 * Closes the opened connection to the database.
	 */	
	public static void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
