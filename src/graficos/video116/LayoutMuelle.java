package graficos.video116;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Spring;
import javax.swing.SpringLayout;

public class LayoutMuelle {
  public static void start() {
    JFrame marco = new Marco();
    marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    marco.setVisible(true);
  }
}

class Marco extends JFrame{
  public Marco() {
    setTitle("video116 Layouts Muelle");
    setBounds(220, 240, 600, 250);
    add(new Lamina());
  }
}

class Lamina extends JPanel {

  public Lamina() {

    JButton boton1 = new JButton("Boton 1");
    JButton boton2 = new JButton("Boton 2");
    JButton boton3 = new JButton("Boton 3");

    SpringLayout milayout = new SpringLayout();
    setLayout(milayout);

    add(boton1);
    add(boton2);
    add(boton3);

    Spring mimuelle = Spring.constant(0, 10, 100);
    Spring muelle_rigido = Spring.constant(10);

    milayout.putConstraint(SpringLayout.WEST, boton1, mimuelle, SpringLayout.WEST, this);
    milayout.putConstraint(SpringLayout.WEST, boton2, muelle_rigido, SpringLayout.EAST, boton1);
    milayout.putConstraint(SpringLayout.WEST, boton3, muelle_rigido, SpringLayout.EAST, boton2);
    milayout.putConstraint(SpringLayout.EAST, this, mimuelle, SpringLayout.EAST, boton3);

  }

}