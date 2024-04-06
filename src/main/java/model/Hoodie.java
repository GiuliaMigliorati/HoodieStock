package model;

import java.util.Objects;

public class Hoodie {
	
	public String id; 
	public String modello; 
	public String taglia; 
	public String colore;
	
	public Hoodie(String id, String modello, String taglia, String colore) {
		this.id = id;
		this.modello = modello;
		this.taglia = taglia;
		this.colore = colore;
	}
	
	public Hoodie() {
		this.id = null;
		this.modello = null;
		this.taglia = null;
		this.colore = null;
	}
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public String getTaglia() {
		return taglia;
	}

	public void setTaglia(String taglia) {
		this.taglia = taglia;
	}

	public String getColore() {
		return colore;
	}

	public void setColore(String colore) {
		this.colore = colore;
	}

	@Override
	public String toString() {
		return "Hoodie [id=" + id + ", modello=" + modello + ", taglia=" + taglia + ", colore=" + colore + "]\n";
	} 
	
	/*public boolean matchesCriteria(Hoodie criteria) {
		System.out.print("aaaaa" + criteria.toString());
		System.out.print(this.getModello());
		System.out.print(this.getTaglia());
		
		    
		boolean modelloMatch = (criteria.modello == null) || this.modello.equals(criteria.modello);
		boolean tagliaMatch = (criteria.taglia == null) || this.taglia.equals(criteria.taglia);
		boolean coloreMatch = (criteria.colore == null) || this.colore.equals(criteria.colore);
		    
		return modelloMatch && tagliaMatch && coloreMatch;
		
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hoodie hoodie = (Hoodie) o;
        return Objects.equals(id, hoodie.id);
    }
*/
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
	
	
	
	

}
