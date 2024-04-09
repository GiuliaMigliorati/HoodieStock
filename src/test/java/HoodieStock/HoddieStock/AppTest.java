package HoodieStock.HoddieStock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;

import org.junit.Before;
import org.junit.Test;

import view.ViewBenvenuto;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
    
    
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
}
