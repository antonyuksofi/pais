package pais;

import java.sql.SQLException;

import static org.junit.Assert.*;
import org.junit.*;

/**
 * This class contains the JUnit test methods
 * for the class {@link Plant.java}  
 * 
 * @see Plant
 */

public class testPlant {
	
	/**
	 * This method is performed before all tests in this class.
	 * 
	 * @see DatabaseWork
	 */	
	@BeforeClass
	public static void openingConnectionToDatabase() {
		DatabaseWork.openConnection();
	}
	
	/**
	 * This method is performed after all tests in this class.
	 * 
	 * @see DatabaseWork
	 */	
	@AfterClass
	public static void closingConnectionToDatabase() {
		DatabaseWork.closeConnection();
	}
	
	/**
	 * Tests the {@link Plant#getFieldById(int, String)} 
	 */	
	@Test()
	public void getFieldById_test() throws SQLException {
		assertEquals("5", Plant.getFieldById(1, "pot_size"));
		assertEquals("Haworthia", Plant.getFieldById(1, "genus"));
	}
	
	/**
	 * Tests the {@link Plant#getGenusById(int)} 
	 */	
	@Test
	public void getGenusById_test() throws SQLException {
		assertEquals("Haworthia", Plant.getGenusById(1));
	}
	
	/**
	 * Tests the {@link Plant#getPotSizeById(int)} 
	 */	
	@Test(timeout=10)
	public void getPotSizeById_test() throws SQLException {
		assertEquals(5, Plant.getPotSizeById(1));
	}
	
	/**
	 * Tests the {@link Plant#getTheBiggestPlantId()} 
	 */	
	@Test
	public void getTheBiggestPlantId_test() throws SQLException {
		assertTrue(7 <= Plant.getTheBiggestPlantId());
	}
	
	/**
	 * Tests the {@link Plant#countPlants()} 
	 */	
	@Test
	public void countPlants_test() throws SQLException {
		assertFalse(0 == Plant.countPlants());
	}
	
	/*//@Ignore("Isn't working correctly")
	@Test (expected = SQLException.class)
	public void throwingException_test() throws SQLException {
		Plant.throwingException();
	}*/
}
