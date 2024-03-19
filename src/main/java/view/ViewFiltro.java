package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ViewFiltro extends JFrame {

	private ArrayList<JButton> group1Buttons;
    private ArrayList<JButton> group2Buttons;
    private ArrayList<JButton> group3Buttons;
    
    
    public void menu3() {
    	
    	// Imposta le proprietà del JFrame
        setTitle("SCHERMO 3");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 500);
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
        menuPanel.setLayout(new GridLayout(4, 1));

        
        // Crea tasti di selezione
        JButton subMenuButton1 = new JButton("VERDE");
        JButton subMenuButton2 = new JButton("ROSSO");
        JButton subMenuButton3 = new JButton("GIALLO");        

        JButton subButton1 = new JButton("S");
        JButton subButton2 = new JButton("M");
        JButton subButton3 = new JButton("L");        

        JButton sub1 = new JButton("nike");
        JButton sub2 = new JButton("adidas");
        JButton sub3 = new JButton("puma");       

        JButton subMenuButton0 = new JButton("OK");
        JButton backButton = new JButton("Torna al Menu Principale");
        JButton clearButton = new JButton("CLEAR");
        
        // Aggiungi i pulsanti al menu
        menuPanel.add(subMenuButton1);
        menuPanel.add(subMenuButton2);
        menuPanel.add(subMenuButton3);        
        
        menuPanel.add(subButton1);
        menuPanel.add(subButton2);
        menuPanel.add(subButton3);        
        
        menuPanel.add(sub1);
        menuPanel.add(sub2);
        menuPanel.add(sub3);        
        
        menuPanel.add(subMenuButton0);
        menuPanel.add(clearButton);
        menuPanel.add(backButton);

        
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
                System.out.println("Voci selezionate: " + getSelectedItems());
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
	private ArrayList <String> getSelectedItems() {
		ArrayList<String> selectedItems = new ArrayList<>();

		for (JButton button : group1Buttons) {
			if(button.getBackground() == Color.YELLOW) {
				selectedItems.add(button.getText());
				break;
			}
		}
		for (JButton button : group2Buttons) {
			if(button.getBackground() == Color.YELLOW) {
				selectedItems.add(button.getText());
				break;
			}
		}
		for (JButton button : group3Buttons) {
			if(button.getBackground() == Color.YELLOW) {
				selectedItems.add(button.getText());
				break;
			}
		}
		return selectedItems;
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
