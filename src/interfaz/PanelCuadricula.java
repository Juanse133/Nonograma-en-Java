package interfaz;

import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.*;
import controlador.Controlador;

public class PanelCuadricula extends JPanel {

    // Constantes
    private static final String BLOCK = "data\\block.jpg";
    private static final String EQUIS = "data\\x.png";

    protected Controlador ctrl;
    protected PanelVidas pnlVidas;
    protected int celdasVacias = 100;
    // Atributos de la clase 		
    private JLabel lblMundo[][];
    private ImageIcon imgCell;
    private ImageIcon imgEquis;

    public PanelCuadricula(Controlador ctrl, PanelVidas pnlVidas) {
        setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 0), new TitledBorder("")));
        setLayout(new GridLayout(10, 10));
        this.imgCell = new ImageIcon(BLOCK);
        this.imgEquis = new ImageIcon(EQUIS);

        this.ctrl = ctrl;
        this.pnlVidas = pnlVidas;

        // Instancia atributos de la clase   
        lblMundo = new JLabel[10][10];

        // Agrega los atributos al panel   
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                lblMundo[i][j] = new JLabel("");
                lblMundo[i][j].setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 0), new TitledBorder("")));
                lblMundo[i][j].setHorizontalAlignment(JLabel.CENTER);
                lblMundo[i][j].setVerticalAlignment(JLabel.CENTER);
                lblMundo[i][j].setEnabled(true);
                lblMundo[i][j].addMouseListener(new LabelClicMouse(i, j, lblMundo[i][j], ctrl, this));
                add(lblMundo[i][j]);
            }
        }

        System.out.println("PanelCuadricula...");
    }

    public void removeLabelClicMouse() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                lblMundo[i][j].removeMouseListener(lblMundo[i][j].getMouseListeners()[0]);
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(8));
        Color colorFeo = new Color(184, 207, 229);
        g2.setColor(colorFeo);
        g2.drawLine(getSize().width / 2, 0, getSize().width / 2, getSize().height - 1);
        g2.drawLine(0, getSize().height / 2, getSize().width - 1, getSize().height / 2);

    }

}

class LabelClicMouse extends MouseAdapter {

    private static final String BLOCK = "data\\block.jpg";
    private static final String EQUIS = "data\\x.png";

    private JLabel label;
    private Controlador ctrl;
    public int x, y;
    private ImageIcon imgCell;
    private ImageIcon imgEquis;
    protected PanelCuadricula pnlCuadricula;

    public LabelClicMouse(int x, int y, JLabel label, Controlador ctrl, PanelCuadricula pnlCuadricula) {
        this.label = label;
        this.ctrl = ctrl;
        this.x = x;
        this.y = y;
        this.imgCell = new ImageIcon(BLOCK);
        this.imgEquis = new ImageIcon(EQUIS);
        this.pnlCuadricula = pnlCuadricula;

    }

    public void mouseClicked(MouseEvent evento) {
        if (evento.isShiftDown()) {
            if (evento.isMetaDown()) // Shif+Boton derecho    	                
            {
            } else // Shift+Boton Izquierdo
            {
            }
        } else {
            if (evento.isMetaDown()) // boton derecho del raton - Pone celulas o Quita celulas
            {
                if ((label.getText()).equals("") && label.getIcon() == null) {
                    label.setIcon(imgCell);
                    System.out.println("Ponen bloque negro: LabelClicMouse(" + x + "," + y + ")");
                    pnlCuadricula.celdasVacias--;
                    if (pnlCuadricula.ctrl.askNonogram(x, y, "0") == false) {
                        System.out.println(pnlCuadricula.pnlVidas.vidas);
                        pnlCuadricula.pnlVidas.quitarVida(x, y);
                        label.setIcon(imgEquis);
                    }
                }
            } else {
                if (evento.isAltDown()) {
                } else // boton izquierdo 
                if ((label.getText()).equals("") && label.getIcon() == null) {
                    label.setIcon(imgEquis);
                    pnlCuadricula.celdasVacias--;
                    System.out.println("Ponen x: LabelClicMouse(" + x + "," + y + ")");
                    if (pnlCuadricula.ctrl.askNonogram(x, y, "X") == false) {
                        System.out.println(pnlCuadricula.pnlVidas.vidas);
                        pnlCuadricula.pnlVidas.quitarVida(x, y);
                        label.setIcon(imgCell);
                    }

                }
            }
        }

        if (pnlCuadricula.celdasVacias == 0) {
            JOptionPane.showMessageDialog(null, "¡GANASTE!.");
            System.exit(0);
        }

    }
}
