package pais;

import java.sql.*;

import static org.junit.Assert.*;

import org.junit.*;

public class testPlant {	
	@BeforeClass
	public static void openingConnectionToDatabase() {
		DatabaseWork.openConnection();
	}
	
	@AfterClass
	public static void closingConnectionToDatabase() {
		DatabaseWork.closeConnection();
	}
	
	@Test()
	public void getById_test() throws SQLException {
		assertEquals("5", Plant.getById(1, "pot_size"));
		assertEquals("Haworthia", Plant.getById(1, "genus"));
	}
	
	@Test
	public void getGenusById_test() throws SQLException {
		assertEquals("Haworthia", Plant.getGenusById(1));
	}
	
	@Test(timeout=10)
	public void getPotSizeById_test() throws SQLException {
		assertEquals(5, Plant.getPotSizeById(1));
	}
	
	@Test
	public void getTheBiggestPlantId_test() throws SQLException {
		assertTrue(7 <= Plant.getTheBiggestPlantId());
	}
	
	@Test
	public void countPlants_test() throws SQLException {
		assertFalse(0 == Plant.countPlants());
	}
	
	//@Ignore("Isn't working correctly")
	@Test (expected = SQLException.class)
	public void throwingException_test() throws SQLException {
		Plant.throwingException();
	}
}
