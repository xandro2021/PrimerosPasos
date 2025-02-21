package graficos.video72;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseAdapter;

public class EventosRaton {
  public static void start() {

    MarcoRaton marco = new MarcoRaton();
    marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  }
}

class MarcoRaton extends JFrame {
  public MarcoRaton() {

    setSize(650, 450);
    setTitle("Video72 EventosRaton I");

    // addMouseListener(new EventosDeRaton2());
    addMouseMotionListener(new EventosDeRaton3());

    setVisible(true);
  }
}

class EventosDeRaton implements MouseListener {

  @Override
  public void mouseClicked(MouseEvent arg0) {

    System.out.println("Haz hecho click");

  }

  @Override
  public void mouseEntered(MouseEvent arg0) {

    System.out.println("Acabas de entrar");

  }

  @Override
  public void mouseExited(MouseEvent arg0) {

    System.out.println("Acabas de salir...");

  }

  @Override
  public void mousePressed(MouseEvent arg0) {

    System.out.println("Mouse Pressed");

  }

  @Override
  public void mouseReleased(MouseEvent arg0) {

    System.out.println("Mouse Released");

  }

}

class EventosDeRaton2 extends MouseAdapter {
  @Override
  public void mouseClicked(MouseEvent e) {

    // System.out.println("Coordenada X: " + e.getX());
    // System.out.println("Coordenada Y: " + e.getY());
    // System.out.println(e.getClickCount());

  }

  @Override
  public void mousePressed(MouseEvent e) {

    if (e.getModifiersEx() == MouseEvent.BUTTON1_DOWN_MASK) {
      System.out.println("Haz pulsado el boton izquierdo");
    }

    else if (e.getModifiersEx() == MouseEvent.BUTTON2_DOWN_MASK) {
      System.out.println("Haz pulsado la rueda del raton");
    }

    else if (e.getModifiersEx() == MouseEvent.BUTTON3_DOWN_MASK) {
      System.out.println("Haz pulsado el boton derecho");
    }

  }
}

class EventosDeRaton3 implements MouseMotionListener {

  @Override
  public void mouseDragged(MouseEvent arg0) {

    System.out.println("Estas arrastrando el raton");

  }

  @Override
  public void mouseMoved(MouseEvent arg0) {

    System.out.println("Estas moviendo el raton");

  }

}