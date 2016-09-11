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
            System.out.println("���� �'������� � ��!");
            System.exit(0);
        }
        
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Plants");
        
        
        /*ArrayList<String[]> plants = new ArrayList <String[]>();*/
        ArrayList<Plant> plants = new ArrayList <Plant>();

        while(rs.next())
        {
        	/*String[] genus_and_species = new String[2];
        	genus_and_species[0] = rs.getString("genus");
        	genus_and_species[1] = rs.getString("species");*/
        	Plant temp_plant = new Plant(
        			rs.getString("genus"),
        			rs.getString("species"),
        			rs.getString("class"),
        			rs.getString("pot_size")
        			);
            //System.out.println(rs.getRow() + ". " + rs.getString("genus") + "\t" + rs.getString("species"));
        	plants.add(temp_plant);
        }
        
        for (int i = 0; i < plants.size(); i++)
        {
        	System.out.println(i+1 + ". " + plants.get(i).get_genus() + "\t" + plants.get(i).get_species());
        }
        
        stmt.close();
	}

}