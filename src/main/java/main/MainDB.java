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
		Data.dataList();
						
	}
}
