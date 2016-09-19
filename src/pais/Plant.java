package pais;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Plant {
	
	private int id = 0;
	private String genus;
	private String species;
	private String field_number = "";
	private String plant_class;
	private String pot_size;
	private String seller = "";
	private String sow_date = "";
	private int mum_id;
	private int dad_id;
	private int core_head_id;
	
	
	public Plant() {
		genus = species = plant_class = pot_size = "";
	}
	
	public Plant(String genus, String species, String plant_class, String pot_size) {
		this.genus = genus;
		this.species = species;
		this.plant_class = plant_class;
		this.pot_size = pot_size;
	}
	
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

	public static String getById(int id, String field) throws SQLException {
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
	
	public static String throwingException() throws SQLException {
		Statement statement = DatabaseWork.getConnection().createStatement();
		ResultSet result_set = statement.executeQuery("select * from Plants where id = 1");
		String res = "";
		//if (result_set.next())
			res = result_set.getString("genus") + " " + result_set.getString("species");
		statement.close();
		result_set.close(); 
		return res;
	}
	
	
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
