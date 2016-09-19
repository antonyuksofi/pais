package pais;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Provides the instruments for work with the table 'Plants'.
 */

public class Plant {
	
	/**
	 * the id of the plant
	 */
	private int id = 0;
	
	/**
	 * the genus of the plant
	 */
	private String genus;
	
	/**
	 * the species of the plant
	 */
	private String species;
	
	/**
	 * the field number of the plant
	 */
	private String field_number = "";
	
	/**
	 * the class of the plant
	 */
	private String plant_class;
	
	/**
	 * the size of pot of the plant
	 */
	private String pot_size;
	
	/**
	 * the seller of the plant
	 */
	private String seller = "";
	
	/**
	 * the date of sowing of the plant
	 */
	private String sow_date = "";
	
	/**
	 * the id of the mother plant
	 */
	private int mum_id = 0;
	
	/**
	 * the id of the father plant
	 */
	private int dad_id = 0;
	
	/**
	 * the id of the core plant,
	 * from which this plant was separated
	 */
	private int core_head_id = 0;
	
	/**
	 * Constructs the object of Plant.
	 * All the fields are constructed with default values.
	 * 
	 * @return		the object of Plant
	 */	
	public Plant() {
		genus = species = plant_class = pot_size = "";
	}

	/**
	 * Constructs the object of Plant.
	 * The fields 'genus', 'species', 'plant_class' and 'pot_size'
	 * are constructed with the given values, others with default.
	 * 
	 * @param	genus		the genus of the plant
	 * @param	species		the species of the plant
	 * @param	plant_class	the class of the plant
	 * @param	pot_size	the size of pot of the plant
	 * @return				the object of Plant
	 */	
	public Plant(String genus, String species, String plant_class, String pot_size) {
		this.genus = genus;
		this.species = species;
		this.plant_class = plant_class;
		this.pot_size = pot_size;
	}

	/**
	 * Constructs the object of Plant.
	 * The fields 'genus', 'species', 'plant_class' and 'pot_size'
	 * are constructed with the given values, others with default.
	 * 
	 * @param	genus			the genus of the plant
	 * @param	species			the species of the plant
	 * @param	field_number	the field number of the plant
	 * @param	plant_class		the class of the plant
	 * @param	pot_size		the size of pot of the plant
	 * @param	seller			the seller of the plant
	 * @param	sow_date		the date of sowing of the plant
	 * @param	mum_id			the id of the mother plant
	 * @param	dad_id			the id of the father plant
	 * @param	core_head_id	the id of the core plant,
	 * 							from which this plant was separated
	 * @return					the object of Plant
	 */	
	public Plant(String genus, String species, String field_number, String plant_class,
			String pot_size, String seller, String sow_date, int mum_id, int dad_id,
			int core_head_id) {
		this.genus = genus;
		this.species = species;
		this.field_number = field_number;
		this.plant_class = plant_class;
		this.pot_size = pot_size;
		this.seller = seller;
		this.sow_date = sow_date;
		this.mum_id = mum_id;
		this.dad_id = dad_id;
		this.core_head_id = core_head_id;
	}

	/**
	 * Returns the value of the specified field of the
	 * plant defined by id   
	 * 
	 * @param	id	the id of the plant to be selected from database
	 * 			field	the name of the field to be selected
	 * @return		the value of the specified field of the
	 * 				database string defined by id
	 * @exception	SQLException
	 */	
	public static String getFieldById(int id, String field) throws SQLException {
		Statement statement = DatabaseWork.getConnection().createStatement();
		ResultSet result_set = statement.executeQuery("select " + field +
				" from Plants where id = " + id);
		String res = "";
		if (result_set.next())
			res = result_set.getString(field);
		statement.close();
		result_set.close(); 
		return res;		
	}

	/**
	 * Returns the genus of the specified plant
	 * 
	 * @param	id	the id of the plant
	 * @return		the genus of the specified plant
	 * @exception	SQLException
	 */	
	public static String getGenusById(int id) throws SQLException {
		Statement statement = DatabaseWork.getConnection().createStatement();
		ResultSet result_set = statement.executeQuery("select genus from Plants where id = " + id);
		String res = "";
		if (result_set.next())
			res = result_set.getString("genus");
		statement.close();
		result_set.close(); 
		return res;
	}

	/**
	 * Returns the pot size of the specified plant
	 * 
	 * @param	id	the id of the plant
	 * @return		the pot size of the specified plant
	 * @exception	SQLException
	 */	
	public static int getPotSizeById(int id) throws SQLException {
		Statement statement = DatabaseWork.getConnection().createStatement();
		ResultSet result_set = statement.executeQuery("select pot_size from Plants where id = " + id);
		int res = -1;
		if (result_set.next())
			res = result_set.getInt("pot_size");
		statement.close();
		result_set.close(); 
		return res;
	}

	/**
	 * Returns the biggest id of all plants
	 * 
	 * @return		the biggest id of all plants
	 * @exception	SQLException
	 */	
	public static int getTheBiggestPlantId() throws SQLException {
		Statement statement = DatabaseWork.getConnection().createStatement();
		ResultSet result_set = statement.executeQuery("select id from Plants order by id desc limit 1");
		int res = -1;
		if (result_set.next())
			res = result_set.getInt("id");
		statement.close();
		result_set.close();
		return res;
	}

	/**
	 * Returns the number of all plants
	 * 
	 * @return		the number of all plants
	 * @exception	SQLException
	 */	
	public static int countPlants() throws SQLException {
		Statement statement = DatabaseWork.getConnection().createStatement();
		ResultSet result_set = statement.executeQuery("select count(*) from Plants");
		int res = -1;
		if (result_set.next())
			res = result_set.getInt(1);
		statement.close();
		result_set.close(); 
		return res;
	}
	
	/*public static String throwingException() throws SQLException {
		Statement statement = DatabaseWork.getConnection().createStatement();
		ResultSet result_set = statement.executeQuery("select * from Plants where id = 1");
		String res = "";
		//if (result_set.next())
			res = result_set.getString("genus") + " " + result_set.getString("species");
		statement.close();
		result_set.close(); 
		return res;
	}*/
	
	
	public void set_id(int id) { 
		this.id = id; 
		}
	
	public void set_genus(String genus) { 
		this.genus = genus; 
		}
	
	public void set_species(String species) { 
		this.species = species;
		}
	
	public void set_plant_class(String plant_class) {
		this.plant_class = plant_class; 
		}
	
	public void set_pot_size(String pot_size) {
		this.pot_size = pot_size;
		}
	
	public void set_field_number(String field_number) {
		this.field_number = field_number;
		}
	
	public void set_seller(String seller) {
		this.seller = seller;
		}
	
	public void set_sow_date(String sow_date) {
		this.field_number = sow_date;
		}
	
	public void set_mum_id(int mum_id) {
		this.mum_id = mum_id;
		}

	public void set_dad_id(int dad_id) {
		this.dad_id = dad_id;
	}
	
	public void set_core_head_id(int core_head_id) {
		this.core_head_id = core_head_id;
	}

	
	public int get_id() {
		return this.id;
	}

	public String get_genus() { 
		return this.genus; 
	}

	public String get_species()	{
		return this.species; 
	}
	
	public String get_field_number() {
		return this.field_number;
	}

	public String get_plant_class()	{
		return this.plant_class; 
	}

	public String get_pot_size() { 
		return this.pot_size; 
	}

	public String get_seller() {
		return this.seller;
	}
	
	public String get_sow_date() {
		return this.sow_date;
	}
	
	public int get_mum_id() {
		return this.mum_id;
	}
	
	public int get_dad_id() {
		return this.dad_id;
	}
	
	public int get_core_head_id() {
		return this.core_head_id;
	}
	
}
