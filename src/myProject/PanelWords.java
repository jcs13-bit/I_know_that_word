package myProject;

import javax.swing.*;
import java.awt.*;

/**
 * Class that shows the words to be memorized
 *
 * @version
 * @autor Johan Castr0
 */

public class PanelWords extends JPanel {
    public static final int WIDTH = 700;
    public static final int HEIGTH = 400;

    private String palabra;

    public PanelWords() {
        palabra = "";
        setPreferredSize(new Dimension(700, 400));
        setLayout(new BorderLayout());
    }

    /**
     * Function that setup variables to a specific value
     */
    public void pintarPalabra(String palabraIngresada) {
        this.palabra = palabraIngresada;

        repaint();
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(232,192,27));
        g.fillRect(0, 0, WIDTH, HEIGTH);

        g.setFont(new Font(Font.DIALOG, Font.BOLD, 30));
        g.setColor(Color.BLACK);
        g.drawString(palabra, WIDTH / 3, HEIGTH / 5);

    }

}
