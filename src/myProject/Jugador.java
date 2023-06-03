package myProject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Jugador {
    private FileWriter fileWriter;
    private BufferedWriter output;
    private String usuario;
    public int nivel, puesto;
    public ArrayList<String> listaJugadores = new ArrayList<String>();
    public ArrayList<String> listaNiveles = new ArrayList<String>();

    public Jugador() {
        Archivos fileManager = new Archivos();
        listaJugadores = fileManager.leerArchivo("jugadores.txt");
        listaNiveles = fileManager.leerArchivo("niveles.txt");
        puesto = 0;
        usuario = "";
        nivel = 1;
    }

    public boolean validar_registro(String nombre) {
        if (listaJugadores.contains(nombre)) {
            puesto = listaJugadores.indexOf(nombre);
            return true;
        } else {
            return false;
        }
    }
    public int getNivel() {
        nivel = Integer.parseInt(listaNiveles.get(puesto));
        return nivel;
    }
    public boolean validarNombre(String nombre) {
        if (nombre == null || nombre == "") {
            return false;
        } else {
            return true;
        }
    }
    public void registrarJugador(String nombre, int nivelSuperado) {
        try {
            fileWriter = new FileWriter("src/myProject/recursos/jugadores.txt", true);//True=conservar, False=Borrar
            output = new BufferedWriter(fileWriter);
            output.newLine();
            output.write(nombre);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            fileWriter = new FileWriter("src/myProject/recursos/niveles.txt", true);//True=conservar, False=Borrar
            output = new BufferedWriter(fileWriter);
            output.newLine();
            output.write(String.valueOf(nivelSuperado));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Actualiza el nivel maxino en Niveles.txt del usuario
     */
    public void actualizarUsuario(String nombre, int nivelSuperado) {



        int indexAGuardar = listaJugadores.indexOf(nombre);

        String valorActualizar = String.valueOf(nivelSuperado);

        listaNiveles.set(indexAGuardar, valorActualizar);

        try {
            fileWriter = new FileWriter("src/myProject/myProject.recursos/niveles.txt", false);//True=conservar, False=Borrar
            output = new BufferedWriter(fileWriter);
            for (int i = 0; i < listaNiveles.toArray().length; i++) {
                output.write(String.valueOf(listaNiveles.get(i)));
                if ((i + 1) < listaNiveles.toArray().length) {
                    output.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



}
