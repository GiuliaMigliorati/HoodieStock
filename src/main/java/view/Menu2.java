package view;

import java.awt.*;
import javax.swing.*;

public class Menu2 extends JFrame {
	
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
		JButton menuButton3 = new JButton("FILTRA");
		JButton menuButton4 = new JButton("MODIFICA");
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
		
		
		
	}

}
