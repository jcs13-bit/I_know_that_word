package myProject;

public class ModelIKnowThatWord {


    private Integer palabrasMemorizar;
    private Integer aciertosNecesarios;
    private Integer nivelActual;
    private Almacen almacen;

    public ModelIKnowThatWord()
    {
        nivelActual = 1;
        almacen = new Almacen();
    }
    /**
     * Obtiene la lista de palabras segun el nivel
     */
    public void paraMemorizar()
    {

    }

    public void verificarNivel() {
        switch (nivelActual) {
            case 1:
                palabrasMemorizar = 10;
                aciertosNecesarios = 14;
                break;
            case 2:
                palabrasMemorizar = 20;
                aciertosNecesarios = 28;
                break;
            case 3:
                palabrasMemorizar = 25;
                aciertosNecesarios = 38;
                break;
            case 4:
                palabrasMemorizar = 30;
                aciertosNecesarios = 48;
                break;
            case 5:
                palabrasMemorizar = 35;
                aciertosNecesarios = 56;
                break;
            case 6:
                palabrasMemorizar = 40;
                aciertosNecesarios = 68;
                break;
            case 7:
                palabrasMemorizar = 50;
                aciertosNecesarios = 90;
                break;
            case 8:
                palabrasMemorizar = 60;
                aciertosNecesarios = 108;
                break;
            case 9:
                palabrasMemorizar = 70;
                aciertosNecesarios = 133;
                break;
            case 10:
                palabrasMemorizar = 100;
                aciertosNecesarios = 200;
                break;
        }
    }

    public Integer getPalabrasMemorizar()
    {
        return palabrasMemorizar;
    }

    public  String getPalabraMemorizar()
    {
        return almacen.getFrase();
    }
}
