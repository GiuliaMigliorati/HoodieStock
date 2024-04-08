package model;

import controller.Controller;

import java.io.File;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class DataBase {
	
	//Metodo che crea tabella
	public static void createTable(String DB_URL, String sql) {
		try {
			Connection conn = DriverManager.getConnection(DB_URL);
			if (conn != null) {
				Statement stmt = conn.createStatement();
				stmt.executeUpdate(sql);
				stmt.close();
				conn.close();
				System.out.println("Table created successfully");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("finito");
		}
	}
	
	
	//Metodo per insert nel database
	public static void insertInDB(Hoodie hoodie) {
		final String DB_URL = "jdbc:sqlite:sample.db";

		String sql = "INSERT INTO DESCRIZIONE VALUES (" + " \"" + hoodie.getId() +
				"\"," + " \"" + hoodie.getModello() + "\"," + " \"" + hoodie.getTaglia() +
				"\"," + " \"" + hoodie.getColore() + "\")" ; 
		
		try {
			Connection conn = DriverManager.getConnection(DB_URL);
			if (conn != null) {
				Statement stmt = conn.createStatement();
				stmt.executeUpdate(sql);
				stmt.close();
				conn.close();
				System.out.println("Utente inserito con successo");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}


	//Metodo per query sul database 
	public static ArrayList <Hoodie> selectFromTabel(String sql) throws SQLException {
		final String DB_URL = "jdbc:sqlite:sample.db";

		Connection conn = DriverManager.getConnection(DB_URL);
		Statement stmt = conn.createStatement();
		System.out.println("Risultati query:");
		ResultSet resultSet = stmt.executeQuery(sql);

		ArrayList <String> listaHoodie = new ArrayList<String>();
		ArrayList <Hoodie> hoodie = new ArrayList<Hoodie>();

		while (resultSet.next()) {

			for (int i = 1; i <= 4; i++) {
				//System.out.println(resultSet.getString(i) + " °°°°");

				listaHoodie.add(resultSet.getString(i));

			}
		}

		for (int j = 0; j<listaHoodie.size(); j+=4) {

			Hoodie felpa = new Hoodie();
			felpa.setId(listaHoodie.get(j));
			felpa.setModello(listaHoodie.get(j+1));
			felpa.setTaglia(listaHoodie.get(j+2));
			felpa.setColore(listaHoodie.get(j+3));

			hoodie.add(felpa);


		}

		stmt.close();
		conn.close();
		System.out.println("query eseguita con successo");

		return hoodie;
	}
	
	public static void deleteAllRows(String dbUrl, String tableName) throws SQLException {
	    try (Connection conn = DriverManager.getConnection(dbUrl);
	         Statement stmt = conn.createStatement()) {
	        String sql = "DELETE FROM " + tableName;
	        stmt.executeUpdate(sql);
	    }
	}
	
	public static void dropTable(String dbUrl, String tableName) throws SQLException {
	    try (Connection conn = DriverManager.getConnection(dbUrl);
	         Statement stmt = conn.createStatement()) {
	        String sql = "DROP TABLE IF EXISTS " + tableName;
	        stmt.executeUpdate(sql);
	    }
	}

	public static void removeFromDb (Hoodie hoodie) throws SQLException {

		final String DB_URL = "jdbc:sqlite:sample.db";

		//Prima controllo che la felpa effettivamente si trovi nel db
		//Attenzione: metodo conta non funziona se gli passo una felpa con id null
		int count = Controller.conta(hoodie);

		if (count>0) {

			String sql1 = "DELETE FROM DESCRIZIONE WHERE ROWID = (SELECT ROWID FROM DESCRIZIONE WHERE ID = " + hoodie.getId() + " LIMIT 1)";
			try {
				Connection conn = DriverManager.getConnection(DB_URL);
				if (conn != null) {
					Statement stmt = conn.createStatement();
					stmt.executeUpdate(sql1);
					stmt.close();
					conn.close();
					System.out.println("Utente elminato con successo");
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}

		}else {System.out.println("Felpa non trovata, impossibile eliminare");}

	}

	public static void removeAllFromDb (Hoodie hoodie) throws SQLException {

		final String DB_URL = "jdbc:sqlite:sample.db";

		//Prima controllo che la felpa effettivamente si trovi nel db
		//Attenzione: metodo conta non funziona se gli passo una felpa con id null
		int count = Controller.conta(hoodie);

		if (count>0) {

			String sql1 = "DELETE FROM DESCRIZIONE WHERE ID = " + hoodie.getId();
			try {
				Connection conn = DriverManager.getConnection(DB_URL);
				if (conn != null) {
					Statement stmt = conn.createStatement();
					stmt.executeUpdate(sql1);
					stmt.close();
					conn.close();
					System.out.println("Utente elminato con successo");
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}

		}else {System.out.println("Felpa non trovata, impossibile eliminare");}

	}



}
