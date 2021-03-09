package controlador;

import interfaz.*;
import java.io.IOException;
import mundo.Nonograma;

public class Controlador {

    private Nonograma nono;
    private PanelCuadricula pnlCuadricula;
    private PanelPistas pnlPistasH, pnlPistasV;

    public Controlador() throws IOException {
        nono = new Nonograma();
        System.out.println("Controlador...");
    }

    public void conectar(PanelCuadricula pnlCuadricula, PanelPistas pnlPistasH, PanelPistas pnlPistasV) {
        this.pnlCuadricula = pnlCuadricula;
        this.pnlPistasH = pnlPistasH;
        this.pnlPistasV = pnlPistasV;

        pnlPistasH.pistas = nono.getPistasH();
        pnlPistasV.pistas = nono.getPistasV();
    }
    public boolean askNonogram(int x, int y, String figura) {
        System.out.println("ctrl: (" + x + "," + y + ") " + figura);
        return nono.isCorrect(x, y, figura);
    }
}
