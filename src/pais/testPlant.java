package pais;

import java.sql.*;

import static org.junit.Assert.*;

import org.junit.*;

public class testPlant {
	//static DatabaseWork db = new DatabaseWork();
	
	@BeforeClass
	public static void openingConnectionToDatabase() {
		DatabaseWork.openConnection();
	}
	
	@AfterClass
	public static void closingConnectionToDatabase() {
		DatabaseWork.closeConnection();
	}
	
	
	/*@Test
	public void getPlantById_test() throws SQLException {
		//Connection connection = DatabaseWork.getConnection();
		Plant actual_plant = Plant.getPlantById(1);
		Plant expected_plant = new Plant ("Haworthia", "cv. Black Major", "", 
				"succulents", "5", "ћух≥н √ригор≥й", "", 0,0,0);
		assertEquals(actual_plant, expected_plant);
	}*/
	
	@Test
	public void getGenusById_test() throws SQLException {
		assertEquals("Haworthia", Plant.getGenusById(1));
	}
	
	
	/*public int multiply (int a, int b){
		return a*b;
	}
	
	@Test
	public void checkMultiply (){
		assertEquals(6, multiply(2,3));
	}*/
	
	/*@Test
	public void checkSum (){
		Plant plant_for_test = new Plant();
		assertEquals(6, plant_for_test.sum(2,3));
	}*/

}
