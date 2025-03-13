package graficos.video121;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanasEmergentesI {
  public static void start() {
    JFrame marco = new Marco();
    marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    marco.setVisible(true);
  }
}

class Marco extends JFrame {
  public Marco() {
    setTitle("video121 Ventanas Emergentes I");
    setBounds(500, 500, 500, 350);
    add(new Lamina());
  }
}

class Lamina extends JPanel {
  public Lamina() {
    agregarBotones();
  }

  private void agregarBotones() {
    for (int i = 0; i < 4; i++) {
      JButton boton = new JButton("Boton " + (i + 1));
      boton.addActionListener(new Accion_Botones());
      add(boton);
    }
  }

  private class Accion_Botones implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

      String texto_boton = ((JButton) e.getSource()).getText();

      switch (texto_boton) {
        case "Boton 1":
          JOptionPane.showMessageDialog(Lamina.this, "Haz presionado: " + texto_boton, "Error", 0);
          break;
        case "Boton 2":
          JOptionPane.showInputDialog(Lamina.this, "Introduce Nombre", "Introduccion Datos", 1);
          break;
        case "Boton 3":
          JOptionPane.showConfirmDialog(Lamina.this, "Elige la opcion", "Ventana de Confirmacion", 1);
          break;
        default:
          JOptionPane.showOptionDialog(Lamina.this, "Elige una opcion", "OPCIONES", 1, 1, new ImageIcon("bin/graficos/imagenes/rojo.png"), null, null);
      }

    }

  }
}