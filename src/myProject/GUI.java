package myProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is used for ...
 * @autor Carlos Felipe Montoya carlos.felipe.montoya@correounivalle.edu.co
 * @version v.1.0.0 date:21/03/2023
 */
public class GUI extends JFrame {

    private Header headerProject;
    private Escucha escucha;
    private JButton inicio, guardar_nombre;
    private JPanel jugador_name, panelPrincipal;


    /**
     * Constructor of GUI class
     */
    public GUI(){
        initGUI();

        //Default JFrame configuration
        this.setTitle("I Know That Word");
        this.setSize(700,500);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * This method is used to set up the default JComponent Configuration,
     * create Listener and control Objects used for the GUI class
     */
    private void initGUI() {
        //Set up JFrame Container's Layout
        //Create Listener Object and Control Object
        //Set up JComponents
        headerProject = new Header("I Know That Word", Color.BLACK);
        escucha = new Escucha();


        JButton botonAyuda = new JButton("Ayuda");
        inicio = new JButton("Inicio");
        inicio.addActionListener(escucha);
        jugador_name = new JPanel();
        jugador_name.setBackground(Color.CYAN);
        Label label = new Label("Nombre:");
        TextField textField = new TextField(20);
        guardar_nombre = new JButton("Guardar");
        guardar_nombre.addActionListener(escucha);
        jugador_name.setLayout(new FlowLayout());
        jugador_name.add(label);
        jugador_name.add(textField);
        jugador_name.add(guardar_nombre);

        jugador_name.setPreferredSize(new Dimension(500, 120));
        this.add(jugador_name, BorderLayout.CENTER);

        // Crear el panel principal con BorderLayout
         panelPrincipal = new JPanel(new BorderLayout());

        // Crear el panel superior
        JPanel panelSuperior = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelSuperior.add(botonAyuda);

        // Crear el panel inferior
        JPanel panelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelInferior.add(inicio);

        panelPrincipal.add(panelSuperior, BorderLayout.NORTH);
        panelPrincipal.add(panelInferior, BorderLayout.SOUTH);

        this.add(panelPrincipal);


        this.add(headerProject,BorderLayout.NORTH); //Change this line if you change JFrame Container's Layout

        botonAyuda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(rootPane, "Se te presentara una secuencia de palabras,una detras de otra. Memorizalas todas. El orden no es relevante ", "Ayuda", JOptionPane.PLAIN_MESSAGE, null);
            }
        });








    }


    /**
     * Main process of the Java program
     * @param args Object used in order to send input data from command line when
     *             the program is execute by console.
     */
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            GUI miProjectGUI = new GUI();
        });
    }

    /**
     * inner class that extends an Adapter Class or implements Listeners used by GUI class
     */
    private class Escucha implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == inicio) {

                remove(panelPrincipal);
                add(jugador_name);
                repaint();
                revalidate();
                System.out.println("adentro de inicio");

            }
            if (e.getSource() == guardar_nombre) {
                System.out.println("adentro de guardar nombre");

            }

        }
    }
}
