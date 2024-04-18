package model;

import controller.DataBase;

public class Data {

	public static void dataList() {
	
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
		
	DataBase.insertInDB(hoodie1);
	DataBase.insertInDB(hoodie1);
	DataBase.insertInDB(hoodie1);
	
	DataBase.insertInDB(hoodie2);
	
	DataBase.insertInDB(hoodie3);
	DataBase.insertInDB(hoodie3);
	
	DataBase.insertInDB(hoodie4);
	
	DataBase.insertInDB(hoodie5);
	
	DataBase.insertInDB(hoodie6);
	DataBase.insertInDB(hoodie6);
	DataBase.insertInDB(hoodie6);
	DataBase.insertInDB(hoodie6);
	
	DataBase.insertInDB(hoodie7);
	
	DataBase.insertInDB(hoodie8);
	DataBase.insertInDB(hoodie8);
	
	DataBase.insertInDB(hoodie9);
	
	DataBase.insertInDB(hoodie10);
	DataBase.insertInDB(hoodie10);
	
	DataBase.insertInDB(hoodie11);
	
	}
}
