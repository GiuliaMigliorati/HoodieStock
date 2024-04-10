package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Hoodie;

public class ControllerViewMenu {

	public Hoodie tastoAggiungi() {
		
		ArrayList <String> codici = new ArrayList <String>(); 
		ArrayList <Hoodie> felpeDB = new ArrayList <Hoodie>(); 
		String sql = "SELECT * FROM DESCRIZIONE";
		try {
			felpeDB = DataBase.selectFromTabel(sql);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(Hoodie felpa : felpeDB) {
			codici.add(felpa.getId());
		}
		Hoodie felpa = new Hoodie();
		felpa = getNewHoodie(codici);
		
		return felpa;
		
	}
	
	public Hoodie tastoElimina() {
		
		ArrayList <String> codici = new ArrayList<String>() ; 
		ArrayList <Hoodie> felpeDB = new ArrayList <Hoodie>(); 
		String sql = "SELECT * FROM DESCRIZIONE";
		try {
			felpeDB = DataBase.selectFromTabel(sql);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(Hoodie felpa : felpeDB) {
			codici.add(felpa.getId());
		}
		Hoodie felpa = new Hoodie();
		
		String codice = "Inserisci il codice della tipologia di felpa da eliminare:";
		felpa = getHoodieStocked(codice, codici);
		
		
		
		
		return felpa;
	}
	
	
	
	public Hoodie tastoModifica() {
		
		ArrayList <String> codici = new ArrayList<String>() ; 
		ArrayList <Hoodie> felpeDB = new ArrayList <Hoodie>(); 
		String sql = "SELECT * FROM DESCRIZIONE";
		try {
			felpeDB = DataBase.selectFromTabel(sql);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(Hoodie felpa : felpeDB) {
			codici.add(felpa.getId());
		}
		
		Hoodie felpa = new Hoodie();
        
        String codice = "Inserisci il codice della tipologia di felpa da MODIFICARE LA QUANTITà:";
        felpa = getHoodieStocked(codice, codici);
        
        
		return felpa;
	}
	
	public int tastoModificaPlus(Hoodie felpaFinale, int[] countWrapper) {
		// Incrementa la quantità della felpa
        // Codice per aumentare la quantità della felpa di 1
    	ArrayList<Hoodie> felpaPlus = new ArrayList <Hoodie>();
    	String sql11 = "SELECT * FROM DESCRIZIONE WHERE ID = " + felpaFinale.getId();
    	try {
			felpaPlus = DataBase.selectFromTabel(sql11);
			if (!felpaPlus.isEmpty()) {
                Hoodie firstHoodie = felpaPlus.get(0); // Prendi il primo elemento
                // Inserisci il primo elemento nel database
                DataBase.insertInDB(firstHoodie);
                countWrapper[0] = DataBase.conta(firstHoodie);
                
		}} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
    	return countWrapper[0];
    	
	}
	
	public int tastoModificaMinus(Hoodie felpaFinale, int[] countWrapper) {		
		try {     
                // Rimuovi la felpa dal database solo se la quantità è maggiore di 0
                DataBase.removeFromDb(felpaFinale);
                // Aggiorna la quantità visualizzata utilizzando la variabile finale locale
                countWrapper[0] = DataBase.conta(felpaFinale);             
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
		return countWrapper[0];	
	}
	
	protected Hoodie getNewHoodie(ArrayList<String> codici) {
		Hoodie felpa = new Hoodie();
		
		String userInput, userInput1, userInput2, userInput3;
		String codice = "Inserisci il codice della tipologia di felpa da aggiungere:";
		String modello = "Inserisci il modello della tipologia di felpa da aggiungere.\nMODELLI POSSIBILI: A - B - C"; 
		String taglia = "Inserisci la taglia della tipologia di felpa da aggiungere.\nTAGLIE POSSIBILI: S - M - L";
		String colore = "Inserisci la colore della tipologia di felpa da aggiungere.\nCOLORI POSSIBILI: ROSSO - VERDE - GIALLO";
		
		// Verifica l'input del codice ID
		do {
	        userInput = getNonEmptyNumericInput(JOptionPane.showInputDialog(codice), codice);
	        if(userInput == null) return null;
	        
	        
	        if (containsStringIgnoreCase(codici, userInput)) {
	            JOptionPane.showMessageDialog(null, "Il codice inserito è già presente.");
	        }
	    } while (containsStringIgnoreCase(codici, userInput));
		// Verifica l'input del modello
		do {
		    userInput1 = getNonEmptyInput(JOptionPane.showInputDialog(modello), modello);
		    if(userInput1 == null) return null;
		    
		    if(!userInput1.equals("A") && !userInput1.equals("B") && !userInput1.equals("C")) {
		        JOptionPane.showMessageDialog(null, "Il modello inserito non esiste.");
		    }
		} while(!userInput1.equals("A") && !userInput1.equals("B") && !userInput1.equals("C"));
		
		// Verifica l'input della taglia
		do {
			userInput2 = getNonEmptyInput(JOptionPane.showInputDialog(taglia), taglia);
	        if(userInput2 == null) return null;
				    
	        if(!userInput2.equals("M") && !userInput2.equals("S") && !userInput2.equals("L")) {
				 JOptionPane.showMessageDialog(null, "La taglia inserita non esiste.");
				    }
		} while(!userInput2.equals("M") && !userInput2.equals("S") && !userInput2.equals("L"));
        
		// Verifica l'input del colore
		do {
			userInput3 = getNonEmptyInput(JOptionPane.showInputDialog(colore), colore);
	        if(userInput3 == null) return null;
						    
			if(!userInput3.equals("ROSSO") && !userInput3.equals("VERDE") && !userInput3.equals("GIALLO")) {
				 JOptionPane.showMessageDialog(null, "Il colore inserito non può essere accettato.");
						    }
		} while(!userInput3.equals("ROSSO") && !userInput3.equals("VERDE") && !userInput3.equals("GIALLO"));
        
        
		
        felpa.id = userInput;
        felpa.modello = userInput1;
        felpa.taglia = userInput2;
        felpa.colore = userInput3;
		
		return felpa;
	
	}
	
	protected Hoodie getHoodieStocked(String codice, ArrayList<String> codici) {
		String userInput = null;
		Hoodie felpa = new Hoodie();
		do {
	        userInput = getNonEmptyNumericInput(JOptionPane.showInputDialog(codice), codice);
	        if(userInput == null) {
	        	return null;
	        }
	     // Verifica se userInput è presente nell'array codici
	        if (!containsStringIgnoreCase(codici, userInput)) {
	            JOptionPane.showMessageDialog(null, "Il codice inserito non è valido.");
	        }
	        felpa.id = userInput;
	    } while (!containsStringIgnoreCase(codici, userInput));
		return felpa;
	}
	
	private String getNonEmptyInput(String message, String question) {
	    String input = message;
	    if(input == null) {
	    	return null;
	    }
	    while (input.trim().isEmpty()) {
	        input = JOptionPane.showInputDialog("Inserimento non valido.\n" + question);
	     // Se l'utente ha annullato, restituisci null
	        if (input == null) {
	            return null;
	        }
	    }
	    
	    return input;
	}
	
	private String getNonEmptyNumericInput(String message, String question) {
	    String input = getNonEmptyInput(message, question);
	    if(input == null) {
	        return null;
	    }
	    while (!input.matches("\\d+")) {
	        input = JOptionPane.showInputDialog("Inserimento non valido. Deve essere un numero.\n" + question);
	        if(input == null) {
	            return null;
	        }
	    }
	    return input;
	}

	private boolean containsStringIgnoreCase(ArrayList<String> codici, String target) {
	    for (String s : codici) {
	        if (s.equalsIgnoreCase(target)) {
	            return true;
	        }
	    }
	    return false;
	}
	
}
