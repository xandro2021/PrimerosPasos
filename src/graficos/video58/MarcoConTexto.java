package graficos.video58;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MarcoConTexto extends JFrame {

  public MarcoConTexto() {

    setVisible(true);

    setSize(650, 450);
    setMinimumSize(getSize());
    setLocation(10, 10);
    setTitle("Video 58");

    Lamina milamina = new Lamina();
    add(milamina);
  }

}

class Lamina extends JPanel {

  public void paintComponent(Graphics g) {

    super.paintComponent(g);
    g.drawString("Estamos aprendiendo Swing", 100, 100);

  }

}