package pais;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Provides the instruments for work with the table 'WateringCalendar'.
 */

public class Watering {
	
	/**
	 * 
	 * @param	id	the id of watering
	 * @param	date	the date of watering
	 * @param	plants_classes	the boolean array corresponding to plants classes
	 * 							watered on this watering 
	 * @param	note	the note to the watering
	 */
	
	/**
	 * the id of watering
	 */
	private int id;
	
	/**
	 * the date of watering
	 */
	private String date;
	
	/**
	 * the boolean array corresponding to plants classes
	 * watered on this watering 
	 */
	private boolean plants_classes[];
	
	/**
	 * the note to the watering
	 */
	private String note;
	
	/**
	 * the String array with the sequence of all plants classes
	 */
	private static String[] predefined_plants_classes = {"cacti", "succulents", "grassy",
			"roses", "myrtles", "palms", "lianas"};

	/**
	 * Constructs the object of Watering.
	 * All the fields are constructed with default values.
	 * 
	 * @return	the object of Watering
	 */	
	Watering () {
		this.id = 0;
		this.date = "";
		this.plants_classes = new boolean[7];
		this.note = "";
	}

	/**
	 * Constructs the object of Watering.
	 * All the fields are constructed with the given values.
	 * 
	 * @param	id	the id of watering
	 * @param	date	the date of watering
	 * @param	plants_classes	the boolean array corresponding to plants classes
	 * 							watered on this watering 
	 * @param	note	the note to the watering
	 * @return	the object of Watering
	 */	
	Watering (int id, String date, boolean[] plant_classes, String note) {
		this.id = id;
		this.date = date;
		this.plants_classes = new boolean[7];
		this.plants_classes = plant_classes;
		this.note = note;
	}

	/**
	 * Constructs the object of Watering.
	 * The fields 'date' and 'plants_classes' are constructed with 
	 * the given values, others with default.
	 * 
	 * @param	date	the date of watering
	 * @param	plants_classes	the boolean array corresponding to plants classes
	 * 							watered on this watering 
	 * @return	the object of Watering
	 */	
	Watering (String date, boolean[] plant_classes) {
		this.id = 0;
		this.date = date;
		this.plants_classes = new boolean[7];
		this.plants_classes = plant_classes;
		this.note = "";
	}

	/**
	 * Gets the list of watered plants classes
	 * by the id of watering.  
	 * 
	 * @param	id	the id of watering in calendar
	 * @return		the string with the names of plants classes,
	 * 				that were watered during the specified watering 
	 * @exception	SQLException
	 */	
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

	/**
	 * Gets the list of watered plants classes
	 * by the date of watering.  
	 * 
	 * @param	date	the date of watering in calendar,
	 * 					must be in format 'yyyy-mm-dd'
	 * @return		the string with the names of plants classes,
	 * 				that were watered during the specified watering 
	 * @exception	SQLException
	 */	
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

	/**
	 * Checks if the plants class was watered
	 * on the specified day.  
	 * 
	 * @param	date			the date of watering in calendar,
	 * 							must be in format 'yyyy-mm-dd'
	 * @param	plants_class	the name of plants class that must be checked for watering
	 * @return		the string with the message whether the specified
	 * 				plants class was or wasn't watered on the specified day 
	 * @exception	SQLException
	 */	
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
