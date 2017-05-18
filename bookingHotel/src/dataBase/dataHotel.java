package dataBase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.ResultSetMetaData;

import dataBase.connectBDD;

public class dataHotel {
	Connection connexion;
	Statement statement;
	ResultSet result;
	
	public void listClient () {
		Connection connexion;
		ResultSet result;
		try{
	    	Statement st = new connectBDD().connexion.createStatement();
	    	String query="SELECT * FROM client";
	    	result=st.executeQuery(query);
			ResultSetMetaData resultMeta = (ResultSetMetaData) result.getMetaData();
			for(int i = 1; i <= resultMeta.getColumnCount(); i++)
		        System.out.println("\t *" + resultMeta.getColumnName(i));        

		      System.out.println("Here is your clients: ");
		      System.out.println("ID - Nom - Prénom - Téléphone");
		      System.out.println("\n---------------------------------");
		      
		      int i = 1;
			while(result.next())
		      {
					System.out.println("\t ID : "+result.getString("id") +" \t Nom : "+result.getString("nomClient")
					+" \t Prénom : "+result.getString("prenomClient") +" \t Numéro de téléphone : "+result.getString("telClient"));
				
					//On regarde si on se trouve sur la dernière ligne du résultat
					if(result.isLast())
		            System.out.println("\t\t* DERNIER RESULTAT !\n");
					i++;
		      } 
	    } catch(SQLException ex){
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null,"Not Found","Message d’avertissement",JOptionPane.ERROR_MESSAGE);			
		}	
	}
	
	public void addCustomer () {
		try{
			/*statement = connexion.createStatement();
			result = statement.executeUpdate("INSERT INTO pokemon(ID, Nom, Type, HP, stage) " + 
			"VALUES ("+pokemonID+",'" +pokemonName+"','" +type+"'," +hp+",'" +stade+"')");
			System.out.println("It works");*/
			
	    	Statement st = new connectBDD().connexion.createStatement();
	    	//result = statement.executeUpdate("INSERT INTO client(nomClient, prenomClient, telClient)" + " VALUES (BRESSANIN","Gautier","0667336413)");
	    	/*result = statement.executeUpdate("INSERT INTO pokemon(ID, Nom, Type, HP, stage) " + 
	    	"VALUES ("+pokemonID+",'" +pokemonName+"','" +type+"'," +hp+",'" +stade+"')");*/
	    	String query="INSERT INTO client(nomClient, prenomClient, telClient) VALUES ('BRESSANIN','Gautier','0667336413')";
	    	int resultInsert = st.executeUpdate(query);
	    	
	    	System.out.println("La requête suivante a été ajouté à la table client: \n - "+query);
		
	    } catch(SQLException ex){
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null,"Not Found","Message d’avertissement",JOptionPane.ERROR_MESSAGE);			
		}	
	}
}
