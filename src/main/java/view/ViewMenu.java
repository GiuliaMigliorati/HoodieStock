package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

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
		JButton menuButton2 = new JButton("ELIMINA");
		JButton menuButton3 = new JButton("MODIFICA");
		JButton menuButton4 = new JButton("FILTRA");
		JButton backButton = new JButton("TORNA");
		
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
        	//NECESSARIO CICLO DI CONTROLLO RGUARDANTE I CODICI DELLE FELPE
			@Override
			public void actionPerformed(ActionEvent e) {
				Hoodie felpa = new Hoodie();
				felpa = getNewHoodie();
				if(felpa != null) {
					System.out.println(felpa.toString());
					JOptionPane.showMessageDialog(ViewMenu.this, "FELPA INSERITA CON SUCCESSO");
				} else {
					JOptionPane.showMessageDialog(ViewMenu.this, "Operazione Annullata");
				}				
			}
        	
        });
        
        menuButton2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//NECESSARIO CICLO DI CONTROLLO RGUARDANTE I CODICI DELLE FELPE
				// INSERIMENTO DI UN CODICE, CREAZIONE DELL'OGGETO FELPA CON QUEL CODICE
				
				
			}
        	
        });
        
        menuButton3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//NECESSARIO CICLO DI CONTROLLO RGUARDANTE I CODICI DELLE FELPE
				//INSERIMENTO DI UN CODICE, STAMPA DELLA QUANTITà DI QUEL CODICE
				//OPZ 1: L'UTENTE INSERISCE LA NUOVA QUANTITà E SI SOVRASCRIVE QUELLA VECCHIA
				//OPZ 2: L'UTENTE INSERISCE DI QUANTO VUOLE MODIFICARE QUELLA QUANTITà (+ O -) CON I RELATIVI CONTROLLI
				
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

	protected Hoodie getNewHoodie() {
		Hoodie felpa = new Hoodie();
		
		String userInput, userInput1, userInput2, userInput3;
		String codice = "Inserisci il codice della tipologia di felpa da aggiungere:";
		String modello = "Inserisci il modello della tipologia di felpa da aggiungere:"; 
		String taglia = "Inserisci la taglia della tipologia di felpa da aggiungere:";
		String colore = "Inserisci la colore della tipologia di felpa da aggiungere:";
		
        userInput = getNonEmptyInput(JOptionPane.showInputDialog(codice), codice);
        if(userInput == null) return null;
        userInput1 = getNonEmptyInput(JOptionPane.showInputDialog(modello), modello);
        if(userInput1 == null) return null;
        userInput2 = getNonEmptyInput(JOptionPane.showInputDialog(taglia), taglia);
        if(userInput2 == null) return null;
        userInput3 = getNonEmptyInput(JOptionPane.showInputDialog(colore), colore);
        if(userInput3 == null) return null;
		
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
	    }
	    return input;
	}

}
