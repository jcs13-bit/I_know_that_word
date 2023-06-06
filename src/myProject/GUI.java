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


    private Timer timerSetWord , timerPreguntas, cambioContexto;
    private Header headerProject;
    private Escucha escucha;
    private EscuchaSetWords escuchaSetWords;
    private EscuchaPreguntas escuchaPreguntas;
    private EscuchaCambioContexto escuchaCambioContexto;
    private EscuchaRespuestas escuchaRespuestas;
    private JButton inicio, guardar_nombre,si , no ;
    private JPanel jugador_name, panelPrincipal, panelInferiorBotones;
    private Jugador jugador;
    private Integer numeroPalabraActual;

    private String jugador_nombre = null;

    private int nivelMaximoSuperado = 1;

    private int nivelActual = 1;

    private TextField nombre;

    private String mensajeContexto= "";

    private PanelWords panelWords;

    private ModelIKnowThatWord modelIKnowThatWord;


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
        escuchaSetWords = new EscuchaSetWords();
        escuchaPreguntas = new EscuchaPreguntas();
        escuchaRespuestas = new EscuchaRespuestas();
        escuchaCambioContexto = new EscuchaCambioContexto();
        jugador = new Jugador();
        modelIKnowThatWord = new ModelIKnowThatWord();
        modelIKnowThatWord.verificarNivel();



        JButton botonAyuda = new JButton("Ayuda");
        inicio = new JButton("Inicio");
        inicio.addActionListener(escucha);
        jugador_name = new JPanel();
        jugador_name.setBackground(Color.CYAN);
        Label label = new Label("Nombre:");
        nombre = new TextField(20);
        guardar_nombre = new JButton("Guardar");
        guardar_nombre.addActionListener(escucha);
        jugador_name.setLayout(new FlowLayout());
        jugador_name.add(label);
        jugador_name.add(nombre);
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
        panelWords= new PanelWords();
        panelWords.setVisible(false);
        panelPrincipal.add(panelWords, BorderLayout.CENTER);
        //this.addKeyListener(escucha);
        setFocusable(true);
        panelWords.pintarPalabra("Nivel: 1");

        timerSetWord = new Timer(5000, escuchaSetWords);
        timerPreguntas = new Timer(7000, escuchaPreguntas);
        cambioContexto = new Timer(5000, escuchaCambioContexto);

        this.add(headerProject,BorderLayout.NORTH); //Change this line if you change JFrame Container's Layout


        // BUTTONS
        si = new JButton("Si");
        no = new JButton("No");
        si.addActionListener(escuchaRespuestas);
        no.addActionListener(escuchaRespuestas);
        si.setSize(100,100);
        no.setSize(100,100);
        panelInferiorBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelInferiorBotones.add(si);
        panelInferiorBotones.add(no);
        panelInferiorBotones.setVisible(false);
        //panelPrincipal.add(panelInferiorBotones, BorderLayout.SOUTH);

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

                jugador_nombre = nombre.getText().replaceAll("\\s", "");

                System.out.println(nombre);
                System.out.println(jugador_nombre);



                if (jugador.validarNombre(jugador_nombre) == true) {
                    if (jugador.validar_registro(jugador_nombre) == true) {
                        JOptionPane.showMessageDialog(null, "El jugador ya existe");
                    }
                    else{
                        jugador.registrarJugador(jugador_nombre, nivelMaximoSuperado);
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "El nombre es muy corto o está vacío");
                }
                Iniciar();
            }  



        }

        public void Iniciar()
        {
            remove(jugador_name);
            add(panelPrincipal);
            panelWords.setVisible(true);
            numeroPalabraActual = 0;
            timerSetWord.start();
            inicio.setVisible(false);
            headerProject = new Header("nivel" + nivelActual, Color.BLACK);
            panelWords.add(headerProject,BorderLayout.NORTH); //Change this line if you change JFrame Container's Layout
            revalidate();
            repaint();
        }
    }

    private class EscuchaSetWords implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            Integer totalAMemorizar = modelIKnowThatWord.getPalabrasMemorizar();
            numeroPalabraActual++;
            panelWords.pintarPalabra(modelIKnowThatWord.getPalabraMemorizar());

            if (numeroPalabraActual == totalAMemorizar)
            {
                timerSetWord.stop();
                mensajeContexto = "Responde si o no";
                panelWords.pintarPalabra(mensajeContexto);
                cambioContexto.start();

            }

        }
        private void preguntar(){
            modelIKnowThatWord.setPalabrasPreguntar();
            numeroPalabraActual= 0;
            timerPreguntas.start();
            panelPrincipal.add(panelInferiorBotones, BorderLayout.SOUTH);
            repaint();
            revalidate();

        }

    }
    private class EscuchaRespuestas implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            panelInferiorBotones.setVisible(false);
            if (e.getSource() == si){
                   modelIKnowThatWord.setRespuesta(true);

            }
            else{
                modelIKnowThatWord.setRespuesta(false);
            }

        }
    }
    private class EscuchaPreguntas implements ActionListener{


        @Override
        public void actionPerformed(ActionEvent e) {
            panelInferiorBotones.setVisible(true);
            panelWords.pintarPalabra(modelIKnowThatWord.getPalabraPreguntar(numeroPalabraActual));
            Integer totalAMemorizar = modelIKnowThatWord.getPalabrasMemorizar();
            numeroPalabraActual++;
            if (numeroPalabraActual == totalAMemorizar*2){
                panelInferiorBotones.setVisible(false);
                numeroPalabraActual= 0;
                timerPreguntas.stop();
                Integer aciertos = modelIKnowThatWord.getAciertos();
                String estadoDeJuego = modelIKnowThatWord.estadoDeJuego();
                if (estadoDeJuego == "ganaste"){
                    panelWords.pintarPalabra("Aciertos " + aciertos);
                    setTimeout(() -> panelWords.pintarPalabra("Felicidades!! Ganaste"), 7000);
                    setTimeout(() -> avanzarNivel(), 14000);
                }else{
                    panelWords.pintarPalabra("Aciertos " + aciertos);
                    setTimeout(() -> panelWords.pintarPalabra("Perdiste... Intentalo de nuevo"), 7000);
                    setTimeout(() -> reiniciarNivel(), 14000);
                }



            }

        }

        public static void setTimeout(Runnable runnable, int delay){
            new Thread(() -> {
                try {
                    Thread.sleep(delay);
                    runnable.run();
                }
                catch (Exception e){
                    System.err.println(e);
                }
            }).start();
        }

        public void avanzarNivel()
        {
            nivelActual++;
            modelIKnowThatWord.avanzarNivel();
            modelIKnowThatWord.verificarNivel();
            headerProject.setText("Nivel: " + nivelActual);
            panelWords.pintarPalabra("Nivel " + nivelActual + ", Preparate");
            setTimeout(() -> timerSetWord.start(), 7000);
        }

        public void reiniciarNivel()
        {
            modelIKnowThatWord.reiniciarNivel();
            modelIKnowThatWord.verificarNivel();
            headerProject.setText("Nivel: " + nivelActual);
            panelWords.pintarPalabra("Nivel " + nivelActual + ", Preparate");
            setTimeout(() -> timerSetWord.start(), 7000);
        }
    }

    private class EscuchaCambioContexto implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            escuchaSetWords.preguntar();
            cambioContexto.stop();
        }
    }



}
