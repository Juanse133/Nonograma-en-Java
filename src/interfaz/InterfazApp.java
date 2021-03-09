package interfaz;

import java.awt.*;
import java.io.IOException;
import javax.swing.*;
import controlador.Controlador;


public class InterfazApp extends JFrame {
    //Relaciones
    
    private Controlador ctrl;
    private PanelCuadricula pnlCuadricula;
    private PanelPistas pnlPistasH, pnlPistasV;
    private PanelVidas pnlVidas;
    // Atributos   
    private JMenuBar mbrOpciones;
    private JMenu mnuAcerca;
    private JMenu mnuAyuda;
    private JMenuItem mitAcerca;
    private JMenuItem mitAyuda;
    private static final String MANUAL = "data\\manual.png";
    private ImageIcon imgManual = new ImageIcon(MANUAL);
    private JLabel label;
    
    // Constructor
    public InterfazApp(Controlador ctrl) {
        setTitle("Nonograma");        
        getContentPane().setLayout(new GridLayout(3,3));
        // Instancia controles de menu
        mbrOpciones = new JMenuBar();

        // Acerca de..
        mnuAcerca = new JMenu();
        mnuAcerca.setText("About");
        mitAcerca = new JMenuItem();
        mitAcerca.setText("Authors: Juan Sebastián Castaño Ramírez.  Laura Andrea Duarte Pérez.  Juan José Horta Osorio.  Jorge Mateo Lis Peña.");
        mnuAcerca.add(mitAcerca);
        mbrOpciones.add(mnuAcerca);
        
        mnuAyuda = new JMenu();
        mnuAyuda.setText("Help");
        mitAyuda = new JMenuItem();
        mitAyuda.setText("Clic Izquiero para colocar X,    Clic Derecho para colocar un ■.");
        mnuAyuda.add(mitAyuda);
        mbrOpciones.add(mnuAyuda);

        setJMenuBar(mbrOpciones);

        this.ctrl = ctrl;
        pnlVidas = new PanelVidas();
        pnlCuadricula = new PanelCuadricula(ctrl, pnlVidas);
        pnlPistasH = new PanelPistas();
        pnlPistasV = new PanelPistas();

        // Instancia los paneles    
        //pnlCuadricula.setBounds(10, 10, 490, 490);
        //pnlPistasV.setBounds(10, 10, 490, 490);
        // Organizar el panel principal 
        getContentPane().add(new JLabel());
        getContentPane().add(pnlPistasV);
        getContentPane().add(new JLabel());
        
        getContentPane().add(pnlPistasH);
        getContentPane().add(pnlCuadricula);
        getContentPane().add(new JLabel());
        
        label = new JLabel(imgManual);
        getContentPane().add(label);
        getContentPane().add(pnlVidas);
        getContentPane().add(new JLabel());        
        
        ctrl.conectar(pnlCuadricula, pnlPistasH, pnlPistasV);
        pnlPistasV.imprimirPistas();
        pnlPistasV.mostrarPistas();
        pnlPistasH.imprimirPistas();
        pnlPistasH.mostrarPistas();
        setSize(900, 900);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        System.out.println("InterfazApp...");
        setLocationRelativeTo(null);
       

    }

    public static void main(String[] args) throws IOException {
        
        InterfazApp frmMain = new InterfazApp(new Controlador());
        frmMain.setVisible(true);
    }

}
