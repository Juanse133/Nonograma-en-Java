package interfaz;

import java.awt.GridLayout;
import java.util.Arrays;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class PanelPistas extends JPanel{

    public String[][] pistas;
    private JLabel[][] lblPistas;

    public PanelPistas() {
        System.out.println("PanelPistas...");
        
    }
    public void imprimirPistas(){
        System.out.println(Arrays.toString(pistas[4]));
    }
    public void mostrarPistas(){
        setLayout(new GridLayout(pistas.length, pistas[1].length));
        lblPistas = new JLabel[pistas.length][pistas[1].length];
        for (int i = 0; i < pistas.length; i++) {
            for (int j = 0; j < pistas[1].length; j++) {
                if(pistas[i][j].equals("0")){
                    pistas[i][j]="";
                }
                if(pistas.length==10){
                    pistas[i][j]+="  ";
                }
                
                lblPistas[i][j] = new JLabel(pistas[i][j]);
                
                lblPistas[i][j].setHorizontalAlignment(JLabel.CENTER);
                lblPistas[i][j].setVerticalAlignment(JLabel.CENTER);
                lblPistas[i][j].setEnabled(true);
                add(lblPistas[i][j]);
            }
        }
       
    }
    

}
