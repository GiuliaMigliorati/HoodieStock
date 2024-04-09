package HoodieStock.HoddieStock;



import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.junit.*;

import view.ViewBenvenuto;
import view.ViewFiltro;
import view.ViewMenu;

public class ViewTest {
	
	// Test ViewBenvenuto
	private ViewBenvenuto viewBenvenuto;

    @Before
    public void setUp() {
        viewBenvenuto = new ViewBenvenuto();
    }

    @Test
    public void testTitle() {
        assertEquals("SCHERMATA DI BENVENUTO", viewBenvenuto.getTitle());
    }

    @Test
    public void testDefaultCloseOperation() {
        assertEquals(JFrame.EXIT_ON_CLOSE, viewBenvenuto.getDefaultCloseOperation());
    }

    @Test
    public void testSize() {
        assertEquals(new Dimension(900, 500), viewBenvenuto.getSize());
    }

    

    @Test
    public void testMenuButton() {
        JPanel mainPanel = (JPanel) viewBenvenuto.getContentPane().getComponent(0);
        JPanel menuPanel = (JPanel) mainPanel.getComponent(0);
        JButton createMenuButton0 = (JButton) menuPanel.getComponent(0);

        assertEquals("<html><center>HOODIE<br>STOCK</center></html>", createMenuButton0.getText());
        assertEquals(Color.BLACK, createMenuButton0.getForeground());

        int red = 240;
        int green = 240;
        int blue = 240;
        Color customColor = new Color(red, green, blue);
        assertEquals(customColor, createMenuButton0.getBackground());

        Font expectedFont = createMenuButton0.getFont().deriveFont(Font.BOLD, 150f);
        assertEquals(expectedFont, createMenuButton0.getFont());
    }

    @Test
    public void testMenuButtonAction() {
        JPanel mainPanel = (JPanel) viewBenvenuto.getContentPane().getComponent(0);
        JPanel menuPanel = (JPanel) mainPanel.getComponent(0);
        JButton createMenuButton0 = (JButton) menuPanel.getComponent(0);

        ActionListener[] actionListeners = createMenuButton0.getActionListeners();
        assertEquals(1, actionListeners.length);

        // Simula un clic sul pulsante
        ActionEvent mockEvent = new ActionEvent(createMenuButton0, ActionEvent.ACTION_PERFORMED, "");
        for (ActionListener listener : actionListeners) {
            listener.actionPerformed(mockEvent);
        }
    }
    // Test ViewMenu
    private ViewMenu viewMenu;

    @Before
    public void setUp11() {
        viewMenu = new ViewMenu();
    }

    @Test
    public void testMenuDisplay() {
        // Verifica che la finestra di selezione del menu venga visualizzata correttamente
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                viewMenu.menu2();
                assertTrue(viewMenu.isVisible());

                // Verifica la presenza dei pulsanti nel menu
                Component[] components = viewMenu.getContentPane().getComponents();
                boolean menuButtonsPresent = false;
                for (Component component : components) {
                    if (component instanceof JPanel) {
                        Component[] innerComponents = ((JPanel) component).getComponents();
                        for (Component innerComponent : innerComponents) {
                            if (innerComponent instanceof JButton) {
                                menuButtonsPresent = true;
                                break;
                            }
                        }
                    }
                }
            }
        });
    }
    
    
    // Test ViewFiltro
    private ViewFiltro view;

    @Before
    public void setUp1() {
        view = new ViewFiltro();
    }

    @Test
    public void testFilterSelection() {
        // Simula la selezione di un filtro per ciascuna categoria e verifica che sia selezionato correttamente
        view.menu3();
        // Simuliamo la selezione di un pulsante per ciascuna categoria
        view.group1Buttons.get(0).doClick(); // Selezione del pulsante nella prima categoria
        view.group2Buttons.get(1).doClick(); // Selezione del pulsante nella seconda categoria
        view.group3Buttons.get(2).doClick(); // Selezione del pulsante nella terza categoria

        // Verifica che i pulsanti siano selezionati correttamente
        assertEquals(Color.YELLOW, view.group1Buttons.get(0).getBackground());
        assertEquals(Color.YELLOW, view.group2Buttons.get(1).getBackground());
        assertEquals(Color.YELLOW, view.group3Buttons.get(2).getBackground());
    }

    @Test
    public void testClearFilters() {
        // Simula la selezione di alcuni filtri e poi pulisce i filtri
        view.menu3();
        view.group1Buttons.get(0).doClick(); // Selezione del pulsante nella prima categoria
        view.group2Buttons.get(1).doClick(); // Selezione del pulsante nella seconda categoria
        view.group3Buttons.get(2).doClick(); // Selezione del pulsante nella terza categoria

        // Pulizia dei filtri
        view.clearClickedButtons();

     // Verifica che tutti i pulsanti dei filtri siano tornati al colore predefinito
        int expectedRed = 238;
        int expectedGreen = 238;
        int expectedBlue = 238;
        Color expectedColor = new Color(expectedRed, expectedGreen, expectedBlue);

        for (JButton button : view.group1Buttons) {
            assertEquals(expectedColor, button.getBackground());
        }
        for (JButton button : view.group2Buttons) {
            assertEquals(expectedColor, button.getBackground());
        }
        for (JButton button : view.group3Buttons) {
            assertEquals(expectedColor, button.getBackground());
        }
    }


}


