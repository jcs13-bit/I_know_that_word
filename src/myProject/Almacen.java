package myProject;

import myProject.AdministradorArchivo;

import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

public class Almacen {
    private ArrayList<String> diccionario = new ArrayList<String>();
    private ArrayList<String> palabras_vistas = new ArrayList<String>();

    private ArrayList<String> palabras_preguntar = new ArrayList<String>();
    private ModelIKnowThatWord modelIKnowThatWord;





    public Almacen() {
        AdministradorArchivo fileManager = new AdministradorArchivo();
        diccionario = fileManager.lecturaFile();
    }

    /**
     * Function that get a word randomly from the dictionary
     */
    public String getFrase() {
        Random aleatorio = new Random();
        String palabra = diccionario.get(aleatorio.nextInt(diccionario.size()));

        if (!palabras_vistas.contains(palabra)){
            palabras_vistas.add(palabra);


        }else{
            getFrase();
        }
        System.out.println(palabras_vistas);
        return palabra;


    }

    public ArrayList <String> getPalabras_preguntar(Integer totalAMemorizar){
        palabras_preguntar = new ArrayList<>(palabras_vistas);


        for (int i = 0; i <= totalAMemorizar; i++) {
            Random aleatorio = new Random();
            String palabra = diccionario.get(aleatorio.nextInt(diccionario.size()));
            if (!palabras_vistas.contains(palabra)) {
                palabras_preguntar.add(palabra);
            }else{
                i--;
            }
        }
        Collections.shuffle(palabras_preguntar);
        System.out.println(palabras_preguntar);

        return palabras_preguntar;
    }


    public ArrayList<String> getDiccionario() {
        return diccionario;
    }
    public Boolean validarRespuesta(Boolean repuesta, String palabras_preguntada){
        if (repuesta && palabras_vistas.contains(palabras_preguntada)){
            return true;
        } else if (repuesta && !palabras_vistas.contains(palabras_preguntada)) {
            return false;
        }else if (!repuesta && palabras_vistas.contains(palabras_preguntada)) {
            return false;
        }else if (!repuesta && !palabras_vistas.contains(palabras_preguntada)) {
            return true;
        }
        else{
            return false;
        }
    }

    public void limpiarAlmacen()
    {
        palabras_vistas.clear();
        palabras_preguntar.clear();
    }
}
