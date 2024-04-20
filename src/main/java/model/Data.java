package model;

import controller.DataBase;

public class Data {

	public static void dataList() {
		
	final String DB_URL = "jdbc:sqlite:sample.db";
	final String tableName = "DESCRIZIONE";
		
	Hoodie hoodie1 = new Hoodie ("2", "B", "L", "VERDE"); 
	Hoodie hoodie2 = new Hoodie ("1", "A", "S", "VERDE"); 
	Hoodie hoodie3 = new Hoodie ("23", "C", "M", "GIALLO");
	Hoodie hoodie4 = new Hoodie ("12", "B", "S", "VERDE"); 
	Hoodie hoodie5 = new Hoodie ("233", "A", "L", "VERDE"); 	
	Hoodie hoodie6 = new Hoodie ("0", "B", "L", "ROSSO"); 
	Hoodie hoodie7 = new Hoodie ("34", "C", "L", "ROSSO"); 
	Hoodie hoodie8 = new Hoodie ("10", "C", "S", "GIALLO"); 
	Hoodie hoodie9 = new Hoodie ("5555", "B", "M", "ROSSO"); 
	Hoodie hoodie10 = new Hoodie ("210", "B", "L", "GIALLO"); 
	Hoodie hoodie11 = new Hoodie ("5", "A", "M", "ROSSO"); 	 
		
	DataBase.insertInDB(hoodie1, DB_URL, tableName);
	DataBase.insertInDB(hoodie1, DB_URL, tableName);
	DataBase.insertInDB(hoodie1, DB_URL, tableName);
	
	DataBase.insertInDB(hoodie2, DB_URL, tableName);
	
	DataBase.insertInDB(hoodie3, DB_URL, tableName);
	DataBase.insertInDB(hoodie3, DB_URL, tableName);
	
	DataBase.insertInDB(hoodie4, DB_URL, tableName);
	
	DataBase.insertInDB(hoodie5, DB_URL, tableName);
	
	DataBase.insertInDB(hoodie6, DB_URL, tableName);
	DataBase.insertInDB(hoodie6, DB_URL, tableName);
	DataBase.insertInDB(hoodie6, DB_URL, tableName);
	DataBase.insertInDB(hoodie6, DB_URL, tableName);
	
	DataBase.insertInDB(hoodie7, DB_URL, tableName);
	
	DataBase.insertInDB(hoodie8, DB_URL, tableName);
	DataBase.insertInDB(hoodie8, DB_URL, tableName);
	
	DataBase.insertInDB(hoodie9, DB_URL, tableName);
	
	DataBase.insertInDB(hoodie10, DB_URL, tableName);
	DataBase.insertInDB(hoodie10, DB_URL, tableName);
	
	DataBase.insertInDB(hoodie11, DB_URL, tableName);
	
	}
}
