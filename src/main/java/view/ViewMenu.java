package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

import controller.ControllerViewMenu;

import controller.DataBase;
import model.Hoodie;


public class ViewMenu extends JFrame {
	
	public void menu2() {
		final String DB_URL = "jdbc:sqlite:sample.db";
		final String tableName = "DESCRIZIONE";
		
		// Imposta le proprietà del JFrame
		setTitle("SCHERMATA DI SELEZIONE DEL MENU");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(900, 700);
		setLocationRelativeTo(null);
		
		// Crea un panello principale
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		
		// Crea un pannello per il menu di selezione
		JPanel menuPanel = new JPanel();
		menuPanel.setLayout(new GridLayout(5,1));
		
		// Aggiungi i pulsanti di scelta
		JButton menuButton1 = new JButton("AGGIUNGI FELPA");
		menuButton1.setFont(menuButton1.getFont().deriveFont(Font.BOLD, 80f));
		JButton menuButton2 = new JButton("ELIMINA FELPA");
		menuButton2.setFont(menuButton2.getFont().deriveFont(Font.BOLD, 80f));
		JButton menuButton3 = new JButton("MODIFICA QUANTITÀ");
		menuButton3.setFont(menuButton3.getFont().deriveFont(Font.BOLD, 80f));
		JButton menuButton4 = new JButton("FILTRA LE FELPE");
		menuButton4.setFont(menuButton4.getFont().deriveFont(Font.BOLD, 80f));
		JButton backButton = new JButton("TORNA INDIETRO");
		backButton.setFont(backButton.getFont().deriveFont(Font.BOLD, 80f));
		
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
        
        // Tasto Aggiungi
        menuButton1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Hoodie felpa = new Hoodie();
				ControllerViewMenu controller = new ControllerViewMenu();
				felpa = controller.tastoAggiungi();
				
				if(felpa != null) {
					DataBase.insertInDB(felpa, DB_URL, tableName );
					JOptionPane.showMessageDialog(ViewMenu.this, "FELPA INSERITA CON SUCCESSO");
				} else {
					JOptionPane.showMessageDialog(ViewMenu.this, "Operazione Annullata");
				}				
			}       	
        });
        
        // Tasto Elimina
        menuButton2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Hoodie felpa = new Hoodie();
				ControllerViewMenu controller = new ControllerViewMenu();
				felpa = controller.tastoElimina();
				
				if(felpa != null) {
					try {
						DataBase.removeAllFromDb(felpa, DB_URL, tableName);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(ViewMenu.this, "FELPA ELIMINATA CON SUCCESSO");	
				} else {
					JOptionPane.showMessageDialog(ViewMenu.this, "Operazione Annullata");
				}				
			}     	
        });
        
     // Tasto Modifica
        menuButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                                
                Hoodie felpa = new Hoodie();
                ControllerViewMenu controller = new ControllerViewMenu();                
                int count = 0;
                felpa = controller.tastoModifica();
                if(felpa != null) {
                    try {
                        count = DataBase.conta(felpa, DB_URL, tableName);
                    } catch (SQLException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                            
                    int result = JOptionPane.showConfirmDialog(ViewMenu.this, "FELPA MODIFICABILE\nQUANTITÀ ATTUALE: " + count, "Conferma", JOptionPane.OK_CANCEL_OPTION);
                           
                    if (result == JOptionPane.OK_OPTION) {
                        JPanel panel = new JPanel(new BorderLayout());
                            
                        JLabel label = new JLabel("<html>QUANTITÀ ATTUALE: " + count + "<br>Scegli un'azione:</html>");
                        panel.add(label, BorderLayout.NORTH);
                            
                        JPanel buttonPanel = new JPanel(); // Nuovo pannello per contenere i bottoni
                        JButton plusButton = new JButton("+1");
                        JButton minusButton = new JButton("-1");
                        buttonPanel.add(plusButton);
                        buttonPanel.add(minusButton);
                        panel.add(buttonPanel, BorderLayout.CENTER);
                        final Hoodie felpaFinale = felpa;
                        final int[] countWrapper = { count };

                        // Azione per il pulsante -
                        minusButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                // Controlla se la quantità è già 1
                                if (countWrapper[0] <= 1) {
                                    // Mostra un messaggio di avviso se la quantità è già 1
                                    JOptionPane.showMessageDialog(ViewMenu.this, "La quantità è solo 1. Non è possibile diminuire ulteriormente la quantità della felpa."
                                            + " Si prega di usare la funzionalità ELIMINA del menu principale.", "Avviso", JOptionPane.WARNING_MESSAGE);
                                } else {
                                    ControllerViewMenu controller = new ControllerViewMenu();                        	
                                    countWrapper[0] = controller.tastoModificaMinus(felpaFinale, countWrapper);
                                    label.setText("<html>QUANTITÀ ATTUALE: " + countWrapper[0] + "<br>Scegli un'azione:</html>");
                                }
                            }                                            
                        });
                        
                        // Azione per il pulsante +
                        plusButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                ControllerViewMenu controller = new ControllerViewMenu();                        	
                                countWrapper[0] = controller.tastoModificaPlus(felpaFinale, countWrapper);
                                label.setText("<html>QUANTITÀ ATTUALE: " + countWrapper[0] + "<br>Scegli un'azione:</html>");                        	
                            }
                        });
                            
                        JOptionPane.showMessageDialog(null, panel, "Modifica Quantità", JOptionPane.PLAIN_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(ViewMenu.this, "Operazione Annullata");
                }
            }
        });


        // Tasto Filtra
        menuButton4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ViewFiltro menu3 = new ViewFiltro();
				menu3.menu3();
			}  	
        });
		
		
		
	}
}

	