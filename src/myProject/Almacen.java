package myProject;

import myProject.AdministradorArchivo;

import java.util.ArrayList;
import java.util.Random;

public class Almacen {
    private ArrayList<String> diccionario = new ArrayList<String>();

    public Almacen() {
        AdministradorArchivo fileManager = new AdministradorArchivo();
        diccionario = fileManager.lecturaFile();
    }

    /**
     * Function that get a word randomly from the dictionary
     */
    public String getFrase() {
        Random aleatorio = new Random();
        return diccionario.get(aleatorio.nextInt(diccionario.size()));
    }

    public ArrayList<String> getDiccionario() {
        return diccionario;
    }
}
