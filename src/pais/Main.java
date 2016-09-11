package pais;
import java.sql.*;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws SQLException 
	{		
		Connection conn = DriverManager.getConnection(
	            "jdbc:mysql://localhost:3306/plants_collector",
	            "root", "");        
        if (conn==null)
        {
            System.out.println("Немає з'єднання з БД!");
            System.exit(0);
        }
        
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Plants");
        
        
        ArrayList<Plant> plants = new ArrayList <Plant>();

        while(rs.next())
        {
        	Plant temp_plant = new Plant(
        			rs.getString("genus"),
        			rs.getString("species"),
        			rs.getString("class"),
        			rs.getString("pot_size")
        			);
        	plants.add(temp_plant);
        }
        
        for (int i = 0; i < plants.size(); i++)
        {
        	System.out.println(i+1 + ". " + plants.get(i).get_genus() + "\t" + plants.get(i).get_species());
        }
        
        stmt.close();
	}

}
