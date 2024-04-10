package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;


import model.Hoodie;

public class ControllerViewFiltro {

	// Metodo per ottenere le felpe corrispondenti ai criteri selezionati
    public ArrayList<Hoodie> getMatchingHoodies(Hoodie criteria) {
        ArrayList<Hoodie> felpeCorrispondenti = new ArrayList<>(); 
        
        ArrayList<Hoodie> tutteLeFelpe = new ArrayList<>();
        String sql = "SELECT * FROM DESCRIZIONE";
		try {
			tutteLeFelpe = DataBase.selectFromTabel(sql);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
        
        
        for (Hoodie felpa : tutteLeFelpe) {
            if (matchesCriteria(felpa, criteria)) {
                felpeCorrispondenti.add(felpa);
            }
        }
        
        return felpeCorrispondenti;
    }

    public static boolean matchesCriteria(Hoodie hoodie, Hoodie criteria) {
        boolean modelloMatch = (criteria.getModello() == null) || hoodie.getModello().equals(criteria.getModello());
        boolean tagliaMatch = (criteria.getTaglia() == null) || hoodie.getTaglia().equals(criteria.getTaglia());
        boolean coloreMatch = (criteria.getColore() == null) || hoodie.getColore().equals(criteria.getColore());
        
        return modelloMatch && tagliaMatch && coloreMatch;
    }

    public static boolean equals(Hoodie hoodie1, Hoodie hoodie2) {
        return Objects.equals(hoodie1.getId(), hoodie2.getId());
    }
			
	

    
}
