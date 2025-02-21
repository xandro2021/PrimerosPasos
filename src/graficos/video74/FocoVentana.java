package graficos.video74;

import javax.swing.JFrame;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

public class FocoVentana extends JFrame implements WindowFocusListener {

  public static void start() {

    FocoVentana marcoventana = new FocoVentana();
    marcoventana.iniciar();

  }

  public void iniciar() {

    marco1 = new FocoVentana();
    marco2 = new FocoVentana();

    marco1.setBounds(300, 100,600,350);
    marco2.setBounds(1200, 100,600,350);

    marco1.addWindowFocusListener(this);
    marco2.addWindowFocusListener(this);

    marco1.setVisible(true);
    marco2.setVisible(true);

    marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    marco2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  }

  @Override
  public void windowGainedFocus(WindowEvent e) {

    if (e.getSource()==marco1) {
      marco1.setTitle("marco1: Tengo el FOCO!!!");
    }
    else {
      marco2.setTitle("marco2: Tengo el FOCO!!!");
    }

  }

  @Override
  public void windowLostFocus(WindowEvent e) {

    if (e.getSource()==marco1) {
      marco1.setTitle(null);
    }
    else {
      marco2.setTitle(null);
    }

  }

  FocoVentana marco1;
  FocoVentana marco2;
}