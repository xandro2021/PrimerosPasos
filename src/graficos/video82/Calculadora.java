package graficos.video82;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Calculadora {
  public static void start() {

    JFrame marco = new MarcoCalculadora();
    marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  }
}

class MarcoCalculadora extends JFrame {

  public MarcoCalculadora() {

    setTitle("video82 Calculadora Layouts");
    setBounds(500, 300, 450, 300);

    add(new LaminaCalculadora());

    setVisible(true);

  }

}

class LaminaCalculadora extends JPanel {

  public LaminaCalculadora() {

    setLayout(new BorderLayout());

    JLabel pantalla = new JLabel("0");
    pantalla.setFont(new Font("JetBrains Mono", Font.BOLD, 26));
    pantalla.setHorizontalAlignment(SwingConstants.CENTER);
    pantalla.setVerticalAlignment(SwingConstants.CENTER);
    add(pantalla, BorderLayout.NORTH);

    add(new JPanelTeclado(pantalla));

  }

}

class JPanelTeclado extends JPanel {

  public JPanelTeclado(JLabel pantalla) {
    this.pantalla = pantalla;
    setLayout(new GridLayout(4, 4));
    agregarBotones();
  }

  private void agregarBotones() {

    String rotulo = "789/456*123-0.=+";
    ActionListener insertar = new InsertaNumero();
    ActionListener operacion = new AccionOrden();

    for (int i = 0; i < rotulo.length(); i++) {

      char c = rotulo.charAt(i);
      JButton button = new JButton("" + c);

      if (c != '/' && c != '*' && c != '-' && c != '+' && c != '=') {
        button.addActionListener(insertar);
      } else {
        button.addActionListener(operacion);
      }

      add(button);
    }

  }

  private class InsertaNumero implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {

      if (pantalla_inicial) {
        pantalla.setText("");
        pantalla_inicial = false;
      }

      String texto_nuevo = e.getActionCommand();
      pantalla.setText(pantalla.getText() + texto_nuevo);
    }
  }

  private class AccionOrden implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {

      String operacion = e.getActionCommand();
      calcular(Double.parseDouble(pantalla.getText()));

      ultima_operacion = operacion;

      pantalla_inicial = true;
    }

    private void calcular(double x) {

      if (ultima_operacion.equals("+")) {
        resultado += x;
      }

      else if (ultima_operacion.equals("-")) {
        resultado -= x;
      }

      else if (ultima_operacion.equals("*")) {
        resultado *= x;
      }

      else if (ultima_operacion.equals("/")) {
        resultado /= x;
      }

      else if (ultima_operacion.equals("=")) {
        resultado = x;
      }

      pantalla.setText(Double.toString(resultado));

    }

    private double resultado;
    private String ultima_operacion = "=";
  }

  private JLabel pantalla;
  private boolean pantalla_inicial = true;
}