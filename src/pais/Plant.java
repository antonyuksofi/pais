package pais;

public class Plant {
	
	private String genus;
	private String species;
	private String plant_class;
	private String pot_size;
	
	public Plant(String genus, String species, String plant_class, String pot_size)
	{
		this.genus = genus;
		this.species = species;
		this.plant_class = plant_class;
		this.pot_size = pot_size;
	}
	
	public void set_genus(String genus)
	{
		this.genus = genus;
	}
	
	public void set_species(String species)
	{
		this.species = species;
	}

	public String get_genus()
	{
		return this.genus;
	}

	public String get_species()
	{
		return this.species;
	}

}
