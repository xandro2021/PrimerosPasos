package graficos.video74;

import java.awt.Graphics;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FocoEvento {
  public static void start() {

    MarcoFoco marco = new MarcoFoco();
    marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  }
}

class MarcoFoco extends JFrame {
  public MarcoFoco() {

    setTitle("Video74 Eventos de Foco I");
    setSize(650, 450);

    add(new LaminaFoco());

    setVisible(true);
  }
}

class LaminaFoco extends JPanel {

  public LaminaFoco() {
    cuadro1 = new JTextField();
    cuadro2 = new JTextField();
  }

  @Override
  protected void paintComponent(Graphics g) {

    super.paintComponent(g);

    setLayout(null);

    cuadro1.setBounds(120, 10, 150, 20);
    cuadro2.setBounds(120, 50, 150, 20);

    FocusListener evento_foco = new LanzaFoco();
    cuadro1.addFocusListener(evento_foco);
    // cuadro2.addFocusListener(new LanzaFoco());

    add(cuadro1);
    add(cuadro2);

  }

  private class LanzaFoco implements FocusListener {

    @Override
    public void focusGained(FocusEvent arg0) {
      // TODO Auto-generated method stub

    }

    @Override
    public void focusLost(FocusEvent arg0) {

      String email = cuadro1.getText();
      boolean comprobacion = false;

      for (int i = 0; i < email.length(); i++) {

        if (email.charAt(i) == '@') {
          comprobacion = true;
        }

      }

      if (comprobacion) {
        System.out.println("Correcto");
      } else {
        System.out.println("malo");
      }

    }

  }

  JTextField cuadro1;
  JTextField cuadro2;
}
