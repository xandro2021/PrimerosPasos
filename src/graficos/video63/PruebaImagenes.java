package graficos.video63;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.awt.Graphics;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PruebaImagenes {
  public static void start() {

    marcoVentana ventana = new marcoVentana();
    ventana.setVisible(true);
    ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  }
}

class marcoVentana extends JFrame {

  public marcoVentana() {

    // setBounds(750, 300, 300, 200);
    setSize(750, 450);
    setTitle("video63 PruebaImagenes");

    Lamina miLamina = new Lamina();
    add(miLamina);

  }

}

class Lamina extends JPanel {

  public Lamina() {

    try {

      imagen = ImageIO.read(new File("src/graficos/video63/ballx.png"));

    } catch (IOException e) {
      System.out.println("Mi Error, imagen no encontrada");
      // System.out.println("Error " + e.getMessage());
      // e.printStackTrace();
    }

  }

  @Override
  protected void paintComponent(Graphics g) {

    super.paintComponent(g);

    if (imagen != null) {
      g.drawImage(imagen, 0, 0, null);
      crearMosaico(g);
    }
    else {
      g.drawString("No se pudo cargar la imagen", 20, 20);
    }

  }

  private void crearMosaico(Graphics g) {

    int ancho_imagen = imagen.getWidth(this);
    int alto_imagen = imagen.getHeight(this);

    for (int i = 0; i < 1920; i += ancho_imagen) {
      for (int j = 0; j < 1080; j += alto_imagen) {

        g.copyArea(0, 0, ancho_imagen, alto_imagen, i, j);

      }
    }

  }

  private Image imagen;
}