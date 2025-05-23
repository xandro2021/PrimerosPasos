package graficos.video60;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
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

    Ellipse2D elipse = new Ellipse2D.Double();
    elipse.setFrame(rectangulo);

    g2.draw(elipse);

    g2.draw(new Line2D.Double(100, 100, 300, 250));

    /* Sacar un punto medio en la figura */
    double CentroenX = rectangulo.getCenterX();
    double CentroenY = rectangulo.getCenterY();
    double radio = 150;

    Ellipse2D circulo = new Ellipse2D.Double();

    circulo.setFrameFromCenter(CentroenX, CentroenY, CentroenX + radio, CentroenY + radio);
    g2.draw(circulo);

  }

}