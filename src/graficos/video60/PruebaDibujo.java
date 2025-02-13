package graficos.video60;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

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

    Graphics2D g2 = (Graphics2D) g;
    Rectangle2D rectangulo = new Rectangle2D.Double(100, 100, 200, 150);

    g2.draw(rectangulo);

  }

}