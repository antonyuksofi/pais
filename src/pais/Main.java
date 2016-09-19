package pais;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws SQLException 
	{
		DatabaseWork.openConnection();
        if (DatabaseWork.getConnection() == null) {
            System.out.println("Немає з'єднання з БД!");
            System.exit(0);
        }
        
        /*System.out.println(Watering.getWaterededPlantsClassesById(2));
        System.out.println(Watering.getWaterededPlantsClassesByDate("'2016-08-30'"));
        System.out.println(Watering.checkIfPlantClassWasWateredOnDate("'2016-09-13'", "cacti"));
        System.out.println(Watering.checkIfPlantClassWasWateredOnDate("'2016-08-30'", "grassy"));*/
        
        DatabaseWork.closeConnection();
	}

}
