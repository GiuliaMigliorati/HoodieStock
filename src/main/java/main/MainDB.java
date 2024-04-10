package main;



import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.SwingUtilities;

import controller.DataBase;
import model.*;
import view.ViewBenvenuto;


public class MainDB {

	public static void main(String[] args) throws SQLException {
			
		// Avvio interfaccia utente
		SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ViewBenvenuto();
            }
        });
				
		//Creazione DB
		final String DB_URL = "jdbc:sqlite:sample.db";				
		
		Connection conn = DriverManager.getConnection(DB_URL);
		DatabaseMetaData meta = conn.getMetaData();
		System.out.println("The driver name is " + meta.getDriverName());
		System.out.println("A new database has been created.");
				
		// Elimina la vecchia tabella DESCRIZIONE se esiste
        DataBase.dropTable(DB_URL, "DESCRIZIONE");
				
		//Creazione tabella
		String sql = "CREATE TABLE DESCRIZIONE (" + " ID NUMERIC," + " MODELLO TEXT, "
				+ "TAGLIA TEXT, " + "COLORE TEXT)";
		
		DataBase.createTable(DB_URL, sql);
				
		//Inserzioni in db
		Hoodie hoodie = new Hoodie ("2", "B", "L", "VERDE"); 
		DataBase.insertInDB(hoodie);
		DataBase.insertInDB(hoodie);
		DataBase.insertInDB(hoodie);
		Hoodie hoodie66 = new Hoodie ("34", "C", "L", "ROSSO"); 
		DataBase.insertInDB(hoodie66);		
		Hoodie hoodie2 = new Hoodie ("1", "A", "S", "VERDE"); 
		DataBase.insertInDB(hoodie2);		
		Hoodie hoodie3 = new Hoodie ("23", "C", "M", "GIALLO"); 
		DataBase.insertInDB(hoodie3);
		DataBase.insertInDB(hoodie3);		
		DataBase.insertInDB(hoodie3);		
		DataBase.insertInDB(hoodie3);		
		Hoodie hoodie4 = new Hoodie ("12", "B", "S", "VERDE"); 
		DataBase.insertInDB(hoodie4);		
		Hoodie hoodie5 = new Hoodie ("233", "A", "L", "VERDE"); 
		DataBase.insertInDB(hoodie5);
		DataBase.insertInDB(hoodie5);		
		DataBase.insertInDB(hoodie5);		
		Hoodie hoodie6 = new Hoodie ("0", "B", "L", "ROSSO"); 
		DataBase.insertInDB(hoodie6);
		DataBase.insertInDB(hoodie6);
		Hoodie hoodie61 = new Hoodie ("10", "C", "S", "GIALLO"); 
		DataBase.insertInDB(hoodie61);
		Hoodie hoodie44 = new Hoodie ("5555", "B", "M", "ROSSO"); 
		DataBase.insertInDB(hoodie44);
		Hoodie hoodie64 = new Hoodie ("210", "B", "L", "GIALLO"); 
		DataBase.insertInDB(hoodie64);
		DataBase.insertInDB(hoodie64);		
		Hoodie hoodie65 = new Hoodie ("5", "A", "M", "ROSSO"); 
		DataBase.insertInDB(hoodie65);
						
	}
}
