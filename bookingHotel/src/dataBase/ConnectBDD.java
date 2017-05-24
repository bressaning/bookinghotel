package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class ConnectBDD {

	public Connection connexion;
	String url;
		
	// Connexion base de données
	public ConnectBDD()	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			url = new String("jdbc:mysql://localhost:8889/booking"); // 
			connexion = (Connection) DriverManager.getConnection(url,"root","root");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	// Identification 
    public String connectAPI(String user, String password) {	
    	String acceptConnectingHotel ="";
    	
	    try 
	    {
	    	Statement st = new ConnectBDD().connexion.createStatement();
	    	ResultSet request = st.executeQuery("SELECT * FROM users WHERE pseudo='"+user+"' AND password='"+password+"'");
	    	if (request.next()){
	    		acceptConnectingHotel = "accept;"+ request.getInt("ID");
	    		//request.getString("ID");
	    	} else {
	    		JOptionPane.showMessageDialog(null,"Données Incorrect !");
	    	}
	    		request.close();
	    }
	    catch (Exception e)
	    {
	    	System.out.println("Connexion Impossible");
	    e.printStackTrace();
	    }
	    return acceptConnectingHotel;
    }
	
}