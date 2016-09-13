package pais;
import java.sql.*;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws SQLException 
	{
		DatabaseWork.openConnection();
        if (DatabaseWork.getConnection() == null) {
            System.out.println("Немає з'єднання з БД!");
            System.exit(0);
        }
        
        /*Statement stmt = DatabaseWork.getConnection().createStatement();
        int id = 1;
        ResultSet rs = stmt.executeQuery("select * from Plants where id = " + id);
        if (rs.next())
        	System.out.println(rs.getString("genus"));*/
        
        System.out.println(Plant.getGenusById(1));
        
        /*ArrayList<Plant> plants = new ArrayList <Plant>();
        while(rs.next()) {
        	Plant temp_plant = new Plant(
        			rs.getString("genus"),
        			rs.getString("species"),
        			rs.getString("class"),
        			rs.getString("pot_size")
        			);
        	temp_plant.set_field_number( rs.getString("field_number") );
        	plants.add(temp_plant);
        }        
        for (int i = 0; i < plants.size(); i++) {
        	System.out.println(i+1 + ". " + plants.get(i).get_genus() + 
        			"\t" + plants.get(i).get_species() + 
        			"\t" + plants.get(i).get_field_number());
        }*/
        
        //stmt.close();
        DatabaseWork.closeConnection();
	}

}
