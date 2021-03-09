/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo;

/**
 *
 * @author Juan
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import javax.swing.JFileChooser;

public class Nonograma {

    protected String[][] pistasV = new String[5][10];
    protected String[][] pistasH = new String[10][5];
    protected String[][] imagenPura = new String[10][10];
    File archivoEntrada;

    public Nonograma() throws IOException {
        JFileChooser seleccionar1 = new JFileChooser("nonogramas/");
        System.out.println("Nonograma...");
        if (seleccionar1.showDialog(null, "Abrir") == JFileChooser.APPROVE_OPTION) {
            archivoEntrada = seleccionar1.getSelectedFile();
        }

        leerArchivo(archivoEntrada);
    }

    public void leerArchivo(File archivo) throws FileNotFoundException, IOException {

        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);

        for (int i = 0; i < 5; i++) {
            pistasV[i] = b.readLine().split(" ");
            System.out.println(Arrays.toString(pistasV[i]));
        }

        for (int i = 0; i < 10; i++) {
            pistasH[i] = b.readLine().split(" ");
            System.out.println(Arrays.toString(pistasH[i]));
        }
        for (int i = 0; i < 10; i++) {
            imagenPura[i] = b.readLine().split(" ");
            System.out.println(Arrays.toString(imagenPura[i]));
        }
        b.close();
    }

    public boolean isCorrect(int x, int y, String figura) {
        return imagenPura[x][y].equals(figura);
    }

    public String[][] getPistasV() {
        return pistasV;
    }

    public String[][] getPistasH() {
        return pistasH;
    }

    public String[][] getImagenPura() {
        return imagenPura;
    }
}
