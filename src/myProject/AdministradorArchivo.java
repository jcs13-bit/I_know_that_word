package myProject;

import java.io.*;
import java.util.ArrayList;

public class AdministradorArchivo {
    public static final String PATH = "src/myProject/recursos/wordStore.txt";

    public static final String PATH_NIVELES = "src/myProject/recursos/niveles.txt";

    public static final String PATH_NOMBRES = "src/myProject/recursos/jugadores.txt";


    private FileReader fileReader;
    private BufferedReader input;
    private FileWriter fileWriter;
    private BufferedWriter output;

    /**
     * Function that read a 'txt' and put it in an arraylist (dictionary)
     */
    public ArrayList<String> lecturaFile() {
        ArrayList<String> frases = new ArrayList<String>();

        try {
            fileReader = new FileReader(PATH);
            input = new BufferedReader(fileReader);
            String line = input.readLine();
            while (line != null) {
                frases.add(line);
                line = input.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return frases;
    }
    public ArrayList<String> lecturaNombres() {
        ArrayList<String> nombres = new ArrayList<String>();

        try {
            fileReader = new FileReader(PATH_NOMBRES);
            input = new BufferedReader(fileReader);
            String line = input.readLine();
            while (line != null) {
                nombres.add(line);
                line = input.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return nombres;
    }

    public ArrayList<String> lecturaNiveles() {
        ArrayList<String> niveles = new ArrayList<String>();

        try {
            fileReader = new FileReader(PATH_NIVELES);
            input = new BufferedReader(fileReader);
            String line = input.readLine();
            while (line != null) {
                niveles.add(line);
                line = input.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return niveles;
    }
    public void actualizarNivel(String linea) {
        try {
            fileWriter = new FileWriter("src/myProject/recursos/niveles.txt", false);
            output = new BufferedWriter(fileWriter);
            output.write(linea);
            output.newLine();
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
