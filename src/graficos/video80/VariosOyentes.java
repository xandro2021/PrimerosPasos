package graficos.video80;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VariosOyentes {
  public static void start() {

    JFrame marco = new MarcoVentana();
    marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  }
}

class MarcoVentana extends JFrame {
  public MarcoVentana() {

    setSize(500, 350);
    setTitle("video80 VariosOyentes");

    add(new Lamina());

    setVisible(true);
  }
}

class Lamina extends JPanel {

  public Lamina() {

    JButton boton_nuevo = new JButton("Nuevo");
    boton_nuevo.addActionListener(new OyenteNuevo());

    boton_cerrar = new JButton("Cerrar Todo");

    add(boton_nuevo);
    add(boton_cerrar);

  }

  private class OyenteNuevo implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

      JFrame marco = new MarcoEmergente(boton_cerrar);

    }

  }

  JButton boton_cerrar;
}

class MarcoEmergente extends JFrame {

  public MarcoEmergente(JButton boton_cerrar) {

    contador++;
    setTitle("Ventana #" + contador);
    setBounds(40 * contador, 40 * contador, 300, 150);
    setVisible(true);

    boton_cerrar.addActionListener(new CierraTodos());

  }

  private class CierraTodos implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

      MarcoEmergente.this.dispose();

    }

  }


  private static int contador = 0;
}