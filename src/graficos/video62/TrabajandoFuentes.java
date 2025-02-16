package graficos.video62;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TrabajandoFuentes {
  public static void start() {

    MarcoConDibujos mimarco = new MarcoConDibujos();
    mimarco.setVisible(true);
    mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  }
}

class MarcoConDibujos extends JFrame {

  public MarcoConDibujos() {

    setTitle("video62 TrabajandoFuentes");
    setSize(400, 400);

    LaminaConFiguras milamina = new LaminaConFiguras();
    milamina.setBackground(SystemColor.window);
    milamina.setForeground(Color.RED);
    add(milamina);

  }
}

class LaminaConFiguras extends JPanel {

  @Override
  protected void paintComponent(Graphics g) {

    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;

    Font mifuente = new Font("JetBrains Mono", Font.BOLD, 26);
    g2.setFont(mifuente);
    // g2.setColor(Color.BLUE);
    g2.drawString("Hola Mundo", 100, 100);

    g2.setFont(new Font("Ubuntu mono", Font.ITALIC, 24));
    // g2.setColor(new Color(44, 123, 0));
    g2.drawString("Este es mi parrafo", 100, 150);

  }

}