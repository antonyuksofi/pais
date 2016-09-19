package pais;

import java.sql.SQLException;

import static org.junit.Assert.*;
import org.junit.*;


public class testWatering {
	@BeforeClass
	public static void openingConnectionToDatabase() {
		DatabaseWork.openConnection();
	}
	
	@AfterClass
	public static void closingConnectionToDatabase() {
		DatabaseWork.closeConnection();
	}
	
	@Test()
	public void getWaterededPlantsClassesById_test() throws SQLException {
		assertEquals("grassy, myrtles", Watering.getWaterededPlantsClassesById(2));
	}

	@Test
	public void getWaterededPlantsClassesByDate_test() throws SQLException {
		assertEquals("cacti, succulents, grassy, roses, myrtles, palms, lianas",
				Watering.getWaterededPlantsClassesByDate("'2016-08-30'"));
	}
	
	@Test
	public void checkIfPlantClassWasWateredOnDate() throws SQLException {
		assertEquals("The class 'cacti' wasn't watered on '2016-09-13'",
				Watering.checkIfPlantClassWasWateredOnDate("'2016-09-13'", "cacti"));
		assertEquals("The class 'grassy' was watered on '2016-08-30'",
				Watering.checkIfPlantClassWasWateredOnDate("'2016-08-30'", "grassy"));
	}
}
