package main;

import java.io.File;


import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

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
		//final String DB_REL_FILE = "C:\\Users\\39346\\Desktop\\Prova db\\HoodieProva.db"; // GIULIA
		//final String DB_REL_FILE = "C:\\Users\\hp\\Desktop\\DB\\HoodieProva.db"; //MICHAEL
		//final String DB_URL = "jdbc:sqlite:" + DB_REL_FILE;
		final String DB_URL = "jdbc:sqlite:sample.db";
		
		// Elimina tutte le righe dalla tabella DESCRIZIONE
		//DataBase.deleteAllRows(DB_URL, "DESCRIZIONE");
		
		Connection conn = DriverManager.getConnection(DB_URL);
		DatabaseMetaData meta = conn.getMetaData();
		System.out.println("The driver name is " + meta.getDriverName());
		System.out.println("A new database has been created.");
		
		//System.out.println("il file esiste? " + new File(DB_REL_FILE).exists());
		
		// Elimina la vecchia tabella DESCRIZIONE se esiste
        DataBase.dropTable(DB_URL, "DESCRIZIONE");
		
		
		//Creazione tabella
		String sql = "CREATE TABLE DESCRIZIONE (" + " ID NUMERIC," + " MODELLO TEXT, "
				+ "TAGLIA TEXT, " + "COLORE TEXT)";
		
		DataBase.createTable(DB_URL, sql);
		
		
		//Inserzioni in db
		Hoodie hoodie = new Hoodie ("2", "B", "L", "VERDE"); 
		DataBase.insertInDB(hoodie);
		Hoodie hoodie66 = new Hoodie ("2", "B", "L", "VERDE"); 
		DataBase.insertInDB(hoodie66);
		
		Hoodie hoodie2 = new Hoodie ("1", "A", "L", "VERDE"); 
		DataBase.insertInDB(hoodie2);		
		Hoodie hoodie3 = new Hoodie ("23", "C", "M", "GIALLO"); 
		DataBase.insertInDB(hoodie3);		
		Hoodie hoodie4 = new Hoodie ("12", "B", "S", "VERDE"); 
		DataBase.insertInDB(hoodie4);		
		Hoodie hoodie5 = new Hoodie ("233", "A", "L", "VERDE"); 
		DataBase.insertInDB(hoodie5);		
		Hoodie hoodie6 = new Hoodie ("0", "C", "L", "ROSSO"); 
		DataBase.insertInDB(hoodie6);
		Hoodie hoodie61 = new Hoodie ("0", "C", "L", "ROSSO"); 
		DataBase.insertInDB(hoodie61);
		Hoodie hoodie44 = new Hoodie ("5555", null, null, null); 
		DataBase.insertInDB(hoodie44);
		//Select da tabella che restituisce ArrayList di oggetti Hoodie
		String sql4 = "SELECT * FROM DESCRIZIONE WHERE ID = 0";
		ArrayList <Hoodie> listaHoodie = new ArrayList<Hoodie>();
		
		//Stampa per prova dell'arraylist
				for(Hoodie felpa : listaHoodie) {
					System.out.println(felpa.toString());}
		listaHoodie = DataBase.selectFromTabel(sql4);
		
		DataBase.removeFromDb(hoodie44);
		//Stampa per prova dell'arraylist
		for(Hoodie felpa1 : listaHoodie) {
			System.out.println(felpa1.toString());
		}
		
		
	}

}
