package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu1 extends JFrame{
	
	public Menu1() {
		
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
        JButton createMenuButton0 = new JButton("<html><center>BENVENUTO<br>A<br>HOODIE STOCK</center></html>");
        createMenuButton0.setBackground(Color.ORANGE); 
        int red = 139; // Valore rosso (0-255)
        int green = 0; // Valore verde (0-255)
        int blue = 139; // Valore blu (0-255)
        Color customColor = new Color(red, green, blue);
        createMenuButton0.setForeground(customColor);
        createMenuButton0.setFont(createMenuButton0.getFont().deriveFont(Font.BOLD, 90f));
        
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
                Menu3 menu3 = new Menu3();
                menu3.menu3();
                Menu2 menu2 = new Menu2();
                menu2.menu2();
            }
        });
	}
	
	

}
