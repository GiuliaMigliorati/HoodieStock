package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Menu3 extends JFrame {

	private ArrayList<JButton> group1Buttons;
    private ArrayList<JButton> group2Buttons;
    private ArrayList<JButton> group3Buttons;
    
    
    public void menu3() {
    	
    	// Imposta le proprietà del JFrame
        setTitle("SCHERMATA DI BENVENUTO");
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
        JButton subMenuButton1 = new JButton("GIALLO");
        JButton subMenuButton2 = new JButton("ROSSO");
        JButton subMenuButton3 = new JButton("NERO");
        JButton subMenuButton4 = new JButton("BLU");

        JButton subButton1 = new JButton("S");
        JButton subButton2 = new JButton("M");
        JButton subButton3 = new JButton("L");
        JButton subButton4 = new JButton("XL");

        JButton sub1 = new JButton("nike");
        JButton sub2 = new JButton("adidas");
        JButton sub3 = new JButton("puma");
        JButton sub4 = new JButton("givova");

        JButton subMenuButton5 = new JButton("OK");
        JButton backButton = new JButton("Torna al Menu Principale");
        
        // Aggiungi i pulsanti al menu
        menuPanel.add(subMenuButton1);
        menuPanel.add(subMenuButton2);
        menuPanel.add(subMenuButton3);
        menuPanel.add(subMenuButton4);
        
        menuPanel.add(subButton1);
        menuPanel.add(subButton2);
        menuPanel.add(subButton3);
        menuPanel.add(subButton4);
        
        menuPanel.add(sub1);
        menuPanel.add(sub2);
        menuPanel.add(sub3);
        menuPanel.add(sub4);
        
        menuPanel.add(subMenuButton5);
        menuPanel.add(backButton);

        mainPanel.add(menuPanel, BorderLayout.CENTER);
        add(mainPanel);
        setVisible(true);
        
    }
	
}
