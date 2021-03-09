package interfaz;


import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PanelVidas extends JPanel {

    private static final String corazonRojo = "data\\heart.png";
    private static final String corazonNegro = "data\\blackheart2.png";
    private ImageIcon imgRojo = new ImageIcon(corazonRojo);
    private ImageIcon imgNegro = new ImageIcon(corazonNegro);
    private JLabel label;
    private JLabel label2;
    private JLabel label3;
    protected int vidas = 3;

    public PanelVidas() {

        System.out.println("Panel vidas...");
        label = new JLabel(imgRojo);
        label2 = new JLabel(imgRojo);
        label3 = new JLabel(imgRojo);
        add(label);
        add(label2);
        add(label3);
    }

    public void quitarVida(int x, int y) {
        System.out.println("Pierdes una vida: " + x + " " + y);
        vidas--;
        if (vidas == 2) {
            remove(label3);
            label3 = new JLabel(imgNegro);
            add(label3);
        } else if (vidas == 1) {
            remove(label2);
            label2 = new JLabel(imgNegro);
            add(label2);
        } else if (vidas == 0) {
            remove(label);
            label = new JLabel(imgNegro);
            add(label);
            JOptionPane.showMessageDialog(null, "GAME OVER.");
            System.exit(0);
        }

    }

}
