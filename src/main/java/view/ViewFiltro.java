package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

import model.*;



public class ViewFiltro extends JFrame {

	private ArrayList<JButton> group1Buttons;
    private ArrayList<JButton> group2Buttons;
    private ArrayList<JButton> group3Buttons;
    
    public void menu3() {
    	
    	// Imposta le proprietà del JFrame
    	setTitle("SELEZIONA I FILTRI DESIDERATI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setLocationRelativeTo(null);

        // Crea ArrayList per categoria di tasti
        group1Buttons = new ArrayList<>();
        group2Buttons = new ArrayList<>();
        group3Buttons = new ArrayList<>();

        // Crea un pannello principale
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Crea un pannello per il menu di selezione
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(0, 1));

        // Crea un Border per i titoli delle categorie
        Border categoryBorder = BorderFactory.createLineBorder(Color.BLACK);

        // Aggiungi il pannello per la prima categoria di pulsanti
        JPanel group1Panel = new JPanel();
        group1Panel.setLayout(new GridLayout(1, 0)); // Utilizza GridLayout con una singola riga per i pulsanti
        group1Panel.setBorder(BorderFactory.createTitledBorder(categoryBorder, "Categoria: MODELLO"));

        // Crea tasti di selezione per la prima categoria
        JButton subMenuButton1 = new JButton("A");
        subMenuButton1.setFont(subMenuButton1.getFont().deriveFont(Font.BOLD, 90f));
        JButton subMenuButton2 = new JButton("B");
        subMenuButton2.setFont(subMenuButton2.getFont().deriveFont(Font.BOLD, 90f));
        JButton subMenuButton3 = new JButton("C");
        subMenuButton3.setFont(subMenuButton3.getFont().deriveFont(Font.BOLD, 90f));

        group1Panel.add(subMenuButton1);
        group1Panel.add(subMenuButton2);
        group1Panel.add(subMenuButton3);

        // Aggiungi il pannello della prima categoria al pannello del menu
        menuPanel.add(group1Panel);

        // Aggiungi il pannello per la seconda categoria di pulsanti
        JPanel group2Panel = new JPanel();
        group2Panel.setLayout(new GridLayout(1, 0)); // Utilizza GridLayout con una singola riga per i pulsanti
        group2Panel.setBorder(BorderFactory.createTitledBorder(categoryBorder, "Categoria: TAGLIA"));

        // Crea e aggiungi i pulsanti per la seconda categoria
        JButton subButton1 = new JButton("S");
        subButton1.setFont(subButton1.getFont().deriveFont(Font.BOLD, 90f));
        JButton subButton2 = new JButton("M");
        subButton2.setFont(subButton2.getFont().deriveFont(Font.BOLD, 90f));
        JButton subButton3 = new JButton("L");
        subButton3.setFont(subButton3.getFont().deriveFont(Font.BOLD, 90f));

        group2Panel.add(subButton1);
        group2Panel.add(subButton2);
        group2Panel.add(subButton3);

        // Aggiungi il pannello della seconda categoria al pannello del menu
        menuPanel.add(group2Panel);

        // Aggiungi il pannello per la terza categoria di pulsanti
        JPanel group3Panel = new JPanel();
        group3Panel.setLayout(new GridLayout(1, 0)); // Utilizza GridLayout con una singola riga per i pulsanti
        group3Panel.setBorder(BorderFactory.createTitledBorder(categoryBorder, "Categoria: COLORE"));

        // Crea e aggiungi i pulsanti per la terza categoria
        JButton sub1 = new JButton("ROSSO");
        sub1.setFont(sub1.getFont().deriveFont(Font.BOLD, 50f));
        JButton sub2 = new JButton("VERDE");        
        sub2.setFont(sub2.getFont().deriveFont(Font.BOLD, 50f));
        JButton sub3 = new JButton("GIALLO");
        sub3.setFont(sub3.getFont().deriveFont(Font.BOLD, 50f));

        group3Panel.add(sub1);
        group3Panel.add(sub2);
        group3Panel.add(sub3);
        
     // Aggiungi il pannello della terza categoria al pannello del menu
        menuPanel.add(group3Panel);
        
     // Aggiungi il pannello per la terza categoria di pulsanti
        JPanel group4Panel = new JPanel();
        group4Panel.setLayout(new GridLayout(1, 0)); // Utilizza GridLayout con una singola riga per i pulsanti
        group4Panel.setBorder(BorderFactory.createTitledBorder(categoryBorder, "Categoria 4"));
        
        JButton subMenuButton0 = new JButton("OK");
        subMenuButton0.setFont(subMenuButton0.getFont().deriveFont(Font.BOLD, 90f));
        JButton backButton = new JButton("Torna al Menu Principale");
        JButton clearButton = new JButton("CLEAR");
        clearButton.setFont(clearButton.getFont().deriveFont(Font.BOLD, 60f));
        
        group4Panel.add(subMenuButton0);
        group4Panel.add(clearButton);
        group4Panel.add(backButton);
        
        menuPanel.add(group4Panel);

        mainPanel.add(menuPanel, BorderLayout.CENTER);
        add(mainPanel);
        setVisible(true);
        
        // Aggiungi i pulsanti ai rispettivi gruppi
        group1Buttons.add(subMenuButton1);
        group1Buttons.add(subMenuButton2);
        group1Buttons.add(subMenuButton3);
        
        group2Buttons.add(subButton1);
        group2Buttons.add(subButton2);
        group2Buttons.add(subButton3);
        
        group3Buttons.add(sub1);
        group3Buttons.add(sub2);
        group3Buttons.add(sub3);
        
     
        // Aggiungi gestori di eventi ai pulsanti del menu
        backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);				
			}        	
        });
        
        subMenuButton0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	Hoodie felpa = new Hoodie();
            	felpa = getSelectedItems();
            	
            	System.out.print(felpa.toString());
            	
            	ArrayList <Hoodie> felpeCorrispondenti = getMatchingHoodies(felpa);
            	
            	if(felpeCorrispondenti.isEmpty()) {
            		JOptionPane.showMessageDialog(null, "Nessuna felpa trovata", "Ricerca senza risultati", JOptionPane.INFORMATION_MESSAGE);
                } else {
                	StringBuilder message = new StringBuilder("Felpe corrispondenti:\n");
                	for(Hoodie hoodie : felpeCorrispondenti) {
                		message.append(hoodie.toString()).append("\n");                		
                	}
                    JOptionPane.showMessageDialog(null, message.toString(), "Risultati della ricerca", JOptionPane.PLAIN_MESSAGE);         
                }                
            }			
        });
        
        clearButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clearClickedButtons();
			}       	
        });
        
        ActionListener itemSelectionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton sourceButton = (JButton) e.getSource();
				String selectedItems = sourceButton.getText();
				
				if(group1Buttons.contains(sourceButton)) {
					toggleSelection(group1Buttons, sourceButton);
				}else if(group2Buttons.contains(sourceButton)) {
					toggleSelection(group2Buttons, sourceButton);
				}else if(group3Buttons.contains(sourceButton)) {
					toggleSelection(group3Buttons, sourceButton);
				}
			}        	
        };
        
        subMenuButton1.addActionListener(itemSelectionListener);
        subMenuButton2.addActionListener(itemSelectionListener);
        subMenuButton3.addActionListener(itemSelectionListener);

        subButton1.addActionListener(itemSelectionListener);
        subButton2.addActionListener(itemSelectionListener);
        subButton3.addActionListener(itemSelectionListener);

        sub1.addActionListener(itemSelectionListener);
        sub2.addActionListener(itemSelectionListener);
        sub3.addActionListener(itemSelectionListener);

        
    }

    
    // Metodo per ottenere le felpe corrispondenti ai criteri selezionati
    private ArrayList<Hoodie> getMatchingHoodies(Hoodie criteria) {
        ArrayList<Hoodie> felpeCorrispondenti = new ArrayList<>(); //MODIFICARE CON L'ARRAY SELEZIONATO DAL DB
        // Supponiamo che il metodo getHoodies() restituisca un elenco di tutte le felpe disponibili
        //ArrayList<Hoodie> tutteLeFelpe = getHoodies();
        Hoodie hoodie1 = new Hoodie("12","A", "S", "ROSSO");
        Hoodie hoodie2 = new Hoodie("1", "A", "M", "VERDE");
        ArrayList<Hoodie> tutteLeFelpe = new ArrayList<>();
        tutteLeFelpe.add(hoodie2);
        tutteLeFelpe.add(hoodie1);
        //System.out.print(criteria.toString());
        for(Hoodie felp : tutteLeFelpe) {
        	System.out.print(felp.toString());
        }
        
        for (Hoodie felpa : tutteLeFelpe) {
            if (felpa.matchesCriteria(criteria)) {
                felpeCorrispondenti.add(felpa);
            }
        }
        for(Hoodie felp : felpeCorrispondenti) {
        	System.out.print(felp.toString());
        }
        return felpeCorrispondenti;
    }


	// Metodo per azionare la selezione dei filtri
    private void toggleSelection(ArrayList<JButton> buttonGroup, JButton clickedButton) {
		if(buttonGroup.contains(clickedButton)) {
			for(JButton button : buttonGroup) {
				if(button.equals(clickedButton)) {
					if(button.getBackground() == Color.YELLOW) {
						button.setBackground(null);
					}else {
						button.setBackground(Color.YELLOW);
					}
				}else {
					button.setBackground(null);
				}
			}
		}		
	}

    
	// Metodo per ottenere i filtri desiderati
	private Hoodie getSelectedItems() {
		Hoodie felpa = new Hoodie();
		for (JButton button : group1Buttons) {
			if(button.getBackground() == Color.YELLOW) {
				felpa.modello = button.getText();
				break;
			}
		}
		for (JButton button : group2Buttons) {
			if(button.getBackground() == Color.YELLOW) {
				felpa.taglia = button.getText();
				break;
			}
		}
		for (JButton button : group3Buttons) {
			if(button.getBackground() == Color.YELLOW) {				
				felpa.colore = button.getText();
				break;
			}
		}
		return felpa;
	}
	
	// Metodo per pulire i filtri scelti
	private void clearClickedButtons() {
		for(JButton button : group1Buttons) {
			button.setBackground(null);
		}
		for(JButton button : group2Buttons) {
			button.setBackground(null);
		}
		for(JButton button : group3Buttons) {
			button.setBackground(null);
		}
	}
	
	
}
