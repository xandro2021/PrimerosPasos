package graficos.video65;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PruebaEventos {
  public static void start() {

    marcoEventos mimarco = new marcoEventos();
    mimarco.setVisible(true);
    mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  }
}

class marcoEventos extends JFrame {

  public marcoEventos() {
    setBounds(700, 300, 500, 300);
    setTitle("Video65 PruebaEventos");

    laminaEventos milamina = new laminaEventos();
    add(milamina);
  }

}

class laminaEventos extends JPanel {

  JButton botonAzul = new JButton("Azul");
  JButton botonAmarillo = new JButton("Amarillo");
  JButton botonRojo = new JButton("Rojo");

  public laminaEventos() {

    add(botonAzul);
    add(botonAmarillo);
    add(botonRojo);

    ColorFondo Amarillo = new ColorFondo(Color.YELLOW);
    ColorFondo Azul = new ColorFondo(Color.BLUE);
    ColorFondo Rojo = new ColorFondo(Color.RED);

    botonAzul.addActionListener(Azul);
    botonAmarillo.addActionListener(Amarillo);
    botonRojo.addActionListener(Rojo);

  }

  private class ColorFondo implements ActionListener {

    public ColorFondo(Color c) {
      colorDeFondo = c;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {

      setBackground(colorDeFondo);

    }

    private Color colorDeFondo;
  }
}
