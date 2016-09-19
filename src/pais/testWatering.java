package pais;

import java.sql.SQLException;

import static org.junit.Assert.*;
import org.junit.*;


/**
 * This class contains the JUnit test methods
 * for the class {@link Watering.java}  
 * 
 * @see Watering
 */
public class testWatering {
	
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
	 * Tests the {@link Watering#getWaterededPlantsClassesById(int)} 
	 */	
	@Test()
	public void getWaterededPlantsClassesById_test() throws SQLException {
		assertEquals("grassy, myrtles", Watering.getWaterededPlantsClassesById(2));
	}
	
	/**
	 * Tests the {@link Watering#getWaterededPlantsClassesByDate(String)} 
	 */	
	@Test
	public void getWaterededPlantsClassesByDate_test() throws SQLException {
		assertEquals("cacti, succulents, grassy, roses, myrtles, palms, lianas",
				Watering.getWaterededPlantsClassesByDate("'2016-08-30'"));
	}
	
	/**
	 * Tests the {@link Watering#checkIfPlantClassWasWateredOnDate(String, String)} 
	 */	
	@Test
	public void checkIfPlantClassWasWateredOnDate() throws SQLException {
		assertEquals("The class 'cacti' wasn't watered on '2016-09-13'",
				Watering.checkIfPlantClassWasWateredOnDate("'2016-09-13'", "cacti"));
		assertEquals("The class 'grassy' was watered on '2016-08-30'",
				Watering.checkIfPlantClassWasWateredOnDate("'2016-08-30'", "grassy"));
	}
}
