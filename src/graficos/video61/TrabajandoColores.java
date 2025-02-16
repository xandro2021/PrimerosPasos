package graficos.video61;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.SystemColor;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TrabajandoColores {
  public static void start() {

    MarcoConDibujos mimarco = new MarcoConDibujos();
    mimarco.setVisible(true);
    mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  }
}

class MarcoConDibujos extends JFrame {

  public MarcoConDibujos() {

    setTitle("video61 TrabajandoColores");
    setSize(400, 400);

    LaminaConFiguras milamina = new LaminaConFiguras();
    add(milamina);
    milamina.setBackground(SystemColor.window);

  }
}

class LaminaConFiguras extends JPanel {

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    Graphics2D g2 = (Graphics2D) g;
    Rectangle2D rectangulo = new Rectangle2D.Double(100, 100, 200, 150);
    g2.setPaint(Color.RED);
    g2.fill(rectangulo);

    g2.setPaint(Color.BLACK);
    g2.draw(rectangulo);

    Ellipse2D elipse = new Ellipse2D.Double();
    elipse.setFrame(rectangulo);
    g2.setPaint(new Color(109, 172, 59).brighter());
    g2.fill(elipse);

  }

}