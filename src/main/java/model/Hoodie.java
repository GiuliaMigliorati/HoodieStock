package model;

public class Hoodie {
	
	private String id; 
	private String modello; 
	private String taglia; 
	private String colore;
	
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
	
	
	
	

}
