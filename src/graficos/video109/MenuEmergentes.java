package graficos.video109;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

public class MenuEmergentes {
  public static void star() {
    JFrame marco = new Marco();
    marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    marco.setVisible(true);
  }
}

class Marco extends JFrame {
  public Marco() {
    setTitle("video109 Menu Emergentes");
    setBounds(500, 500, 550, 450);
    add(new Lamina());
  }
}

class Lamina extends JPanel {

  public Lamina() {
    JPopupMenu emergente = new JPopupMenu();
    JMenuItem opcion1 = new JMenuItem("Opcion 1");
    JMenuItem opcion2 = new JMenuItem("Opcion 2");
    JMenuItem opcion3 = new JMenuItem("Opcion 3");
    emergente.add(opcion1);
    emergente.add(opcion2);
    emergente.add(opcion3);
    /* Configurarlo para que funcione con la lamina */
    setComponentPopupMenu(emergente);
  }

}