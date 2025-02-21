package graficos.video70;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;

import javax.swing.JFrame;

public class CambioEstadoVentana {
  public static void start() {

    MarcoEstado marco = new MarcoEstado();
    marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  }
}

class MarcoEstado extends JFrame {
  public MarcoEstado() {

    setVisible(true);
    setTitle("Video70 CambioEstadoVentana");
    setBounds(300, 300, 500, 350);

    addWindowStateListener(new CambiaEstado());

  }
}

/*
 * Clase Usada para detectar cambios en el Marco o Ventana en si
 */
class CambiaEstado implements WindowStateListener {

  @Override
  public void windowStateChanged(WindowEvent e) {

    // System.out.println("La ventana ha cambiado");

    if (e.getNewState() == Frame.MAXIMIZED_BOTH ) {
      System.out.println("ventana maximizada");
    }

    else if (e.getNewState() == Frame.NORMAL ) {
      System.out.println("ventana maximizada");
    }
    else if (e.getNewState() == Frame.ICONIFIED ) {
      System.out.println("ventana maximizada");
    }

  }

}