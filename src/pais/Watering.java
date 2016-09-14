package pais;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Watering {
	
	private int id;
	private String date;
	private boolean plants_classes[];
	private static String[] predefined_plants_classes = {"cacti", "succulents", "grassy",
			"roses", "myrtles", "palms", "lianas"};
	private String note;
	
	Watering () {
		this.id = -1;
		this.date = "";
		this.plants_classes = new boolean[7];
		this.note = "";
	}
	
	Watering (int id, String date, boolean[] plant_classes, String note) {
		this.id = id;
		this.date = date;
		this.plants_classes = new boolean[7];
		this.plants_classes = plant_classes;
		this.note = note;
	}
	
	Watering (String date, boolean[] plant_classes) {
		this.date = date;
		this.plants_classes = new boolean[7];
		this.plants_classes = plant_classes;
	}
	
	public static String getWaterededPlantsClassesById(int id) throws SQLException {
		String result = "";
		Statement statement = DatabaseWork.getConnection().createStatement();
		ResultSet result_set = statement.executeQuery("select * from WateringCalendar where id = " + id);
		if (result_set.next()) {
			for (int i = 0; i < predefined_plants_classes.length; i++)
				if (result_set.getBoolean(predefined_plants_classes[i]) == true) {
					result += predefined_plants_classes[i];
					result += ", ";
				}
			result = result.substring(0, result.length() - 2);
		}
		statement.close();
		result_set.close(); 
		return result;
	}
	
	public static String getWaterededPlantsClassesByDate(String date) throws SQLException {
		String result = "";
		Statement statement = DatabaseWork.getConnection().createStatement();
		ResultSet result_set = statement.executeQuery("select * from WateringCalendar where date = " + date);
		if (result_set.next()) {
			for (int i = 0; i < predefined_plants_classes.length; i++)
				if (result_set.getBoolean(predefined_plants_classes[i]) == true) {
					result += predefined_plants_classes[i];
					result += ", ";
				}
			result = result.substring(0, result.length() - 2);
		}
		statement.close();
		result_set.close(); 
		return result;
	}
	
	public static String checkIfPlantClassWasWateredOnDate(String date, String plants_class) throws SQLException {
		String result = "The class '" + plants_class + "' ";
		Statement statement = DatabaseWork.getConnection().createStatement();
		ResultSet result_set = statement.executeQuery("select " + plants_class + 
				" from WateringCalendar where date = " + date);
		if (result_set.next() && result_set.getBoolean(plants_class) == true)
			result += "was watered on " + date;
		else
			result += "wasn't watered on " + date;
					
		statement.close();
		result_set.close(); 
		return result;
	}
	
	
	public int get_id() {
		return id;
	}
	
	public String get_date() {
		return date;
	}
	
	public boolean[] get_plant_classes() {
		return plants_classes;
	}
	
	public String get_note() {
		return note;
	}
	
	public void set_id(int id) {
		this.id = id;
	}
	
	public void set_date(String date) {
		this.date = date;
	}
	
	public void set_plant_classes(boolean[] plant_classes) {
		this.plants_classes = plant_classes;
	}
	
	public void set_note(String note) {
		this.note = note;
	}

}
