package graficos.video115;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;

public class LayoutBoxI {
  public static void start() {
    JFrame marco = new Marco();
    marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    marco.setVisible(true);
  }
}

class Marco extends JFrame {
  public Marco() {
    setTitle("Video115 LayoutBoxI");
    setBounds(300, 240, 320, 250);
    add(new Lamina());
  }
}

class Lamina extends JPanel {

  public Lamina() {
    setLayout(new BorderLayout());
    primeraCaja();
    segundaCaja();
    terceraCaja();
    guardarCajas();
  }

  private void primeraCaja(){

    JLabel rotulo1 = new JLabel("Nombre");
    JTextField texto1 = new JTextField(10);
    texto1.setMaximumSize(texto1.getPreferredSize());

    cajaH1 = Box.createHorizontalBox();
    cajaH1.add(rotulo1);
    cajaH1.add(Box.createHorizontalStrut(10));
    cajaH1.add(texto1);

  }

  private void segundaCaja(){

    JLabel rotulo2 = new JLabel("Contraseña");
    JTextField texto2 = new JTextField(10);
    texto2.setMaximumSize(texto2.getPreferredSize());

    cajaH2 = Box.createHorizontalBox();
    cajaH2.add(rotulo2);
    cajaH2.add(Box.createHorizontalStrut(10));
    cajaH2.add(texto2);

  }

  private void terceraCaja() {
    JButton boton1 = new JButton("OK");
    JButton boton2 = new JButton("Cancelar");

    cajaH3 = Box.createHorizontalBox();
    cajaH3.add(boton1);
    cajaH3.add(Box.createGlue());
    cajaH3.add(boton2);
  }

  private void guardarCajas() {
    cajaVertical = Box.createVerticalBox();
    cajaVertical.add(cajaH1);
    cajaVertical.add(cajaH2);
    cajaVertical.add(cajaH3);
    add(cajaVertical, BorderLayout.CENTER);
  }

  private Box cajaH1, cajaH2, cajaH3, cajaVertical;
}