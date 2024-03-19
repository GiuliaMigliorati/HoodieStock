package main;

import java.io.File;


import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import model.*;


public class MainDB {

	public static void main(String[] args) throws SQLException {

		//Creazione DB
		final String DB_REL_FILE = "C:\\Users\\39346\\Desktop\\Prova db\\HoodieProva.db";
		final String DB_URL = "jdbc:sqlite:" + DB_REL_FILE;
		
		Connection conn = DriverManager.getConnection(DB_URL);
		DatabaseMetaData meta = conn.getMetaData();
		System.out.println("The driver name is " + meta.getDriverName());
		System.out.println("A new database has been created.");
		
		System.out.println("il file esiste? " + new File(DB_REL_FILE).exists());
		
		
		//Creazione tabella
		String sql = "CREATE TABLE DESCRIZIONE (" + " ID NUMERIC," + " MODELLO TEXT, "
				+ "TAGLIA TEXT, " + "COLORE TEXT)";
		
		DataBase.createTable(DB_URL, sql);
		
		
		//Inserzioni in db
		Hoodie hoodie = new Hoodie ("1", "B", "L", "VERDE"); 
		DataBase.insertInDB(DB_URL, hoodie);
		DataBase.insertInDB(DB_URL, hoodie);
		
		Hoodie hoodie2 = new Hoodie ("2", "C", "XL", "VERDE"); 
		DataBase.insertInDB(DB_URL, hoodie2);
		
		
		
		//Select da tabella che restituisce ArrayList di oggetti Hoodie
		String sql4 = "SELECT * FROM DESCRIZIONE WHERE ID = 2";
		ArrayList <Hoodie> listaHoodie = new ArrayList<Hoodie>();
		listaHoodie = DataBase.selectFromTabel(DB_URL, sql4);
		
		
		//Stampa per prova dell'arraylist
		for(int i =0; i<listaHoodie.size(); i++ ) {
			System.out.println(listaHoodie.get(i).getId()); 
			System.out.println(listaHoodie.get(i).getModello()); 
			System.out.println(listaHoodie.get(i).getTaglia()); 
			System.out.println(listaHoodie.get(i).getColore()); 
		}
		
		
		
		
	}

}
