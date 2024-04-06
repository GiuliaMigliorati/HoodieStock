package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;
import java.util.ArrayList;
import model.DataBase;
import model.Hoodie;


public class ViewMenu extends JFrame {
	
	public void menu2() {
		
		// Imposta le proprietà del JFrame
		setTitle("SCHERMO 2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700, 700);
		setLocationRelativeTo(null);
		
		// Crea un panello principale
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		
		// Crea un pannello per il menu di selezione
		JPanel menuPanel = new JPanel();
		menuPanel.setLayout(new GridLayout(5,1));
		
		// Aggiungi i pulsanti di scelta
		JButton menuButton1 = new JButton("AGGIUNGI");
		menuButton1.setFont(menuButton1.getFont().deriveFont(Font.BOLD, 90f));
        menuButton1.setBackground(Color.WHITE); 
		JButton menuButton2 = new JButton("ELIMINA");
		menuButton2.setFont(menuButton2.getFont().deriveFont(Font.BOLD, 90f));
        menuButton2.setBackground(Color.WHITE); 
		JButton menuButton3 = new JButton("MODIFICA");
		menuButton3.setFont(menuButton3.getFont().deriveFont(Font.ITALIC, 90f));
		JButton menuButton4 = new JButton("FILTRA");
		menuButton4.setFont(menuButton4.getFont().deriveFont(Font.PLAIN, 90f));
		JButton backButton = new JButton("TORNA");
		backButton.setFont(backButton.getFont().deriveFont(Font.BOLD, 90f));
		
		//Aggiungi i pulsanti al panello del menu
		menuPanel.add(menuButton1);
		menuPanel.add(menuButton2);
		menuPanel.add(menuButton3);
		menuPanel.add(menuButton4);
		menuPanel.add(backButton);
		
		mainPanel.add(menuPanel, BorderLayout.CENTER);
        add(mainPanel);
        setVisible(true);
        
        
        // Aggiungi gestori di eventi ai pulsanti del menu
        backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);				
			}        	
        });
        
        menuButton1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
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
				if(felpa != null) {
					System.out.println(felpa.toString());
					DataBase.insertInDB(felpa);
					JOptionPane.showMessageDialog(ViewMenu.this, "FELPA INSERITA CON SUCCESSO");
				} else {
					JOptionPane.showMessageDialog(ViewMenu.this, "Operazione Annullata");
				}				
			}
        	
        });
        
        menuButton2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
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
				
				System.out.print(felpa.toString());
				JOptionPane.showMessageDialog(ViewMenu.this, "FELPA ELIMINATA CON SUCCESSO");	
			}
        	
        });
        
        menuButton3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//INSERIMENTO DI UN CODICE, STAMPA DELLA QUANTITà DI QUEL CODICE
				//OPZ 1: L'UTENTE INSERISCE LA NUOVA QUANTITà E SI SOVRASCRIVE QUELLA VECCHIA
				//OPZ 2: L'UTENTE INSERISCE DI QUANTO VUOLE MODIFICARE QUELLA QUANTITà (+ O -) CON I RELATIVI CONTROLLI
				
				ArrayList<String> codici = new ArrayList<>(); // SOSTITUIRE CON L'ARRAY DI CODICI DEL DB !!!!!!!!
				
				Hoodie felpa = new Hoodie();
				
				String codice = "Inserisci il codice della tipologia di felpa da MODIFICARE LA QUANTITà:";
				felpa = getHoodieStocked(codice, codici);
				
				System.out.print(felpa.toString());
				JOptionPane.showMessageDialog(ViewMenu.this, "FELPA MODIFICABILE");
			}
        	
        });
        
        menuButton4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ViewFiltro menu3 = new ViewFiltro();
				menu3.menu3();
			}  	
        });
		
		
		
	}

	protected Hoodie getHoodieStocked(String codice, ArrayList<String> codici) {
		String userInput = null;
		Hoodie felpa = new Hoodie();
		do {
	        userInput = getNonEmptyNumericInput(JOptionPane.showInputDialog(codice), codice);
	        System.out.print("222\n");
	        if(userInput == null) {
	        	JOptionPane.showMessageDialog(ViewMenu.this, "Operazione Annullata");
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
