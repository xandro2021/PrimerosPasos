package graficos.video71;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class EventosTeclado {
  public static void start() {

    MarcoConTeclas marcoConTeclas = new MarcoConTeclas();
    marcoConTeclas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  }
}

class MarcoConTeclas extends JFrame {
  public MarcoConTeclas() {

    setVisible(true);
    setSize(700, 450);
    setTitle("Video71 Eventos de teclado");

    addKeyListener(new EventoDeTeclado());

  }
}

class EventoDeTeclado implements KeyListener {

  @Override
  public void keyPressed(KeyEvent e) {

    // int codigo = e.getKeyCode();
    // System.out.println(codigo);

  }

  @Override
  public void keyReleased(KeyEvent e) {
    // TODO Auto-generated method stub

  }

  @Override
  public void keyTyped(KeyEvent e) {

    char letra = e.getKeyChar();
    System.out.println(letra);

  }

}