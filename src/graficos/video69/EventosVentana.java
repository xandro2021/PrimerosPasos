package graficos.video69;

import javax.swing.JFrame;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowAdapter;

public class EventosVentana {
  public static void start() {

    MarcoVentana ventana = new MarcoVentana("marco 1", 300, 300, 500, 250);
    ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    MarcoVentana ventana2 = new MarcoVentana("marco 2", 900, 300, 500, 350);
    ventana2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

  }
}

class MarcoVentana extends JFrame {
  public MarcoVentana(String titulo, int x, int y, int ancho, int alto) {
    setVisible(true);

    setTitle("Video69 EventosVentana " + titulo);
    setBounds(x, y, ancho, alto);

    addWindowListener(new M_Ventana());

  }
}

class M_Ventana extends WindowAdapter {

  @Override
  public void windowOpened(WindowEvent arg0) {

    System.out.println("Se abre la ventana");

  }

}