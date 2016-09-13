package pais;

import java.sql.*;

public class Plant {
	
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
	
	public Plant(String genus, String species, String field_number, String plant_class, String pot_size,
			String seller, String sow_date, int mum_id, int dad_id, int core_head_id) {
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
	
	public static Plant getPlantById(int id) throws SQLException {
		Statement statement = DatabaseWork.getConnection().createStatement();
		ResultSet result = statement.executeQuery("select * from Plants where id = " + id);
		Plant plant = new Plant();
		plant.set_genus(result.getString("genus"));
		plant.set_species (result.getString("species"));
		plant.set_field_number (result.getString("field_number"));
		plant.set_plant_class (result.getString("plant_class"));
		plant.set_pot_size (result.getString("pot_size"));
		plant.set_seller (result.getString("seller"));
		plant.set_sow_date (result.getString("sow_date"));
		plant.set_mum_id (result.getInt("mum_id"));
		plant.set_dad_id (result.getInt("dad_id"));
		plant.set_core_head_id (result.getInt("core_head_id"));
		statement.close();
		return plant;
	}
	
	public static String getGenusById(int id) throws SQLException {
		Statement statement = DatabaseWork.getConnection().createStatement();
		ResultSet result = statement.executeQuery("select genus from Plants where id = " + id);
		statement.close();
		return result.getString("genus");
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
	

	public String get_genus() { 
		return this.genus; 
		}

	public String get_species()	{
		return this.species; 
		}

	public String get_plant_class()	{
		return this.plant_class; 
		}

	public String get_pot_size() { 
		return this.pot_size; 
		}
	
	public String get_field_number() {
		return this.field_number;
	}
	
	/*public int sum(int a, int b){
		return a+b;
	}*/
}
