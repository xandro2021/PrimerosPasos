package graficos.video59;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PruebaDibujo {
  public static void start() {

    MarcoConDibujos mimarco = new MarcoConDibujos();
    mimarco.setVisible(true);
    mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  }
}

class MarcoConDibujos extends JFrame {

  public MarcoConDibujos() {

    setTitle("video59 Prueba de Dibujo");
    setSize(400, 400);

    LaminaConFiguras milamina = new LaminaConFiguras();
    add(milamina);

  }
}

class LaminaConFiguras extends JPanel {

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    // g.drawRect(50, 50, 200, 200);
    // g.drawLine(100, 100, 300, 200);
    g.drawArc(50, 100, 100, 200, 120, 150);
  }

}