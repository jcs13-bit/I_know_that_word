package myProject;

import java.io.*;
import java.util.ArrayList;

public class Archivos  {

    private FileReader fileReader;
    private BufferedReader input;
    private FileWriter fileWriter;
    private BufferedWriter output;

    public ArrayList<String> leerArchivo(String archivo){
        ArrayList<String> lista = new ArrayList<String>();
        String PATH = "src/myProject/recursos/"+archivo;
        try {
            fileReader = new FileReader(PATH);
            input = new BufferedReader(fileReader);
            String linea = input.readLine();
            while (linea != null) {
                lista.add(linea);
                linea = input.readLine();
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
        return lista;

    }


}
