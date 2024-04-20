package controller;

import model.Hoodie;


import java.sql.Connection;
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
	public static void insertInDB(Hoodie hoodie, String DB_URL, String tableName) {
		
		
		String sql = "INSERT INTO " + tableName + " VALUES (" + " \"" + hoodie.getId() +
				"\"," + " \"" + hoodie.getModello() + "\"," + " \"" + hoodie.getTaglia() +
				"\"," + " \"" + hoodie.getColore() + "\")" ; 
		
		try {
			Connection conn = DriverManager.getConnection(DB_URL);
			if (conn != null) {
				Statement stmt = conn.createStatement();
				stmt.executeUpdate(sql);
				stmt.close();
				conn.close();
				//System.out.println("Utente inserito con successo");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}


	//Metodo per query sul database 
	public static ArrayList <Hoodie> selectFromTabel(String sql, String DB_URL) throws SQLException {
		

		Connection conn = DriverManager.getConnection(DB_URL);
		Statement stmt = conn.createStatement();
		//System.out.println("Risultati query:");
		ResultSet resultSet = stmt.executeQuery(sql);

		ArrayList <String> listaHoodie = new ArrayList<String>();
		ArrayList <Hoodie> hoodie = new ArrayList<Hoodie>();

		while (resultSet.next()) {

			for (int i = 1; i <= 4; i++) {

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

		return hoodie;
	}
	
	
	
	public static void dropTable(String dbUrl, String tableName) throws SQLException {
	    try (Connection conn = DriverManager.getConnection(dbUrl);
	         Statement stmt = conn.createStatement()) {
	        String sql = "DROP TABLE IF EXISTS " + tableName;
	        stmt.executeUpdate(sql);
	    }
	}

	public static void removeFromDb (Hoodie hoodie, String DB_URL, String tableName) throws SQLException {


		//Prima controllo che la felpa effettivamente si trovi nel db
		//Attenzione: metodo conta non funziona se gli passo una felpa con id null
		int count = DataBase.conta(hoodie, DB_URL, tableName);

		if (count>0) {

			String sql1 = "DELETE FROM " + tableName + " WHERE ROWID = (SELECT ROWID FROM " + tableName + " WHERE ID = " + hoodie.getId() + " LIMIT 1)";
			try {
				Connection conn = DriverManager.getConnection(DB_URL);
				if (conn != null) {
					Statement stmt = conn.createStatement();
					stmt.executeUpdate(sql1);
					stmt.close();
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}

		}else {System.out.println("Felpa non trovata, impossibile eliminare");}

	}


	

	public static void removeAllFromDb (Hoodie hoodie, String DB_URL, String tableName) throws SQLException {


		//Prima controllo che la felpa effettivamente si trovi nel db
		//Attenzione: metodo conta non funziona se gli passo una felpa con id null
		int count = DataBase.conta(hoodie, DB_URL, tableName);

		if (count>0) {

			String sql1 = "DELETE FROM " + tableName + " WHERE ID = " + hoodie.getId();
			try {
				Connection conn = DriverManager.getConnection(DB_URL);
				if (conn != null) {
					Statement stmt = conn.createStatement();
					stmt.executeUpdate(sql1);
					stmt.close();
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}

		}else {System.out.println("Felpa non trovata, impossibile eliminare");}

	}
	
	

	//Metodo che restituisce quantità presente di una felpa desiderata
    public static int conta (Hoodie hoodie, String DB_URL, String tableName) throws SQLException {

        String sql = "SELECT * FROM " + tableName;
        ArrayList <Hoodie> db = DataBase.selectFromTabel(sql, DB_URL);

        int count = 0;

        //attenzione, se entra un id null non funziona!
        for (int i=0; i<db.size(); i++) {

            if(hoodie.getId().equals(db.get(i).getId())) {
                count++;
            }
        }

        return count;
    }

}
