package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewBenvenuto extends JFrame{
	
	public ViewBenvenuto() {
		
		// Imposta le proprietà del JFrame
        setTitle("SCHERMATA DI BENVENUTO");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 500);
        setLocationRelativeTo(null);

        // Crea un pannello principale
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        
        // Crea un pannello per il menu di benvenuto
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(1, 1));
        
        // Aggiungi un pulsante per creare un nuovo menu
        JButton createMenuButton0 = new JButton("<html><center>HOODIE<br>STOCK</center></html>");
        createMenuButton0.setForeground(Color.BLACK); 
        int red = 240; // Valore rosso (0-255)
        int green = 240; // Valore verde (0-255)
        int blue = 240; // Valore blu (0-255)
        Color customColor = new Color(red, green, blue);
        createMenuButton0.setBackground(customColor);
        createMenuButton0.setFont(createMenuButton0.getFont().deriveFont(Font.BOLD, 150f));
        
        // Aggiungi il pulsante al pannello del menu
        menuPanel.add(createMenuButton0);
        
        // Aggiungi il pannello del menu al pannello principale
        mainPanel.add(menuPanel, BorderLayout.CENTER);

        // Aggiungi il pannello principale al frame
        add(mainPanel);

        // Rendi il frame visibile
        setVisible(true);
        
        // Reazione al click del tasto
        createMenuButton0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                ViewMenu menu2 = new ViewMenu();
                menu2.menu2();
            }
        });
	}
	
	

}
