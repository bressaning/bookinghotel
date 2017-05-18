package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class connectBDD {
	Connection connexion;
	String url;
	Statement statement;
	//ResultSet result;
	int result;
		
	public connectBDD()
		{
		// TODO Auto-generated method stub
		try{
			/*Class.forName("com.mysql.jdbc.Driver").newInstance();
			url = new String("jdbc:mysql://localhost:3306/booking");
			connexion = DriverManager.getConnection(url,"root","");
			statement = connexion.createStatement();*/
			
			Class.forName("com.mysql.jdbc.Driver");
			url = new String("jdbc:mysql://localhost:3306/booking"); // 
			connexion = (Connection) DriverManager.getConnection(url,"root","");
			
			//System.out.println("It work !");
		/*	
			ResultSet result = statement.executeQuery("SELECT * FROM client");
			ResultSetMetaData resultMeta = result.getMetaData();

			
			for(int i = 1; i <= resultMeta.getColumnCount(); i++)
		        System.out.println("\t *" + resultMeta.getColumnName(i));        

		      System.out.println("Here is your pokedeck: ");
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
			*/
			//System.out.println("ça marche");
		} catch (Exception e){
			JOptionPane.showMessageDialog(null,"Erreur"); 
			e.printStackTrace();
		}
	}
	public void affiche()
	{
		
	}
}
