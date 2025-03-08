package graficos.video118;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DisposicionLibreI {
  public static void start() {
    JFrame marco = new Marco();
    marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    marco.setVisible(true);
  }
}

class Marco extends JFrame {
  public Marco() {
    setTitle("Video118 DisposicionLibre");
    setBounds(500, 500, 550, 450);
    add(new Lamina());
  }
}

class Lamina extends JPanel {
  public Lamina() {

    setLayout(null);

    JLabel nombre = new JLabel("Nombre:");
    JLabel apellido = new JLabel("Apellido:");

    JTextField c_nombre = new JTextField();
    JTextField c_apellido = new JTextField();

    nombre.setBounds(20, 20, 80, 15);
    c_nombre.setBounds(100, 17, 100, 20);

    apellido.setBounds(20, 60, 80, 15);
    c_apellido.setBounds(100, 55, 100, 20);

    add(nombre);
    add(apellido);
    add(c_nombre);
    add(c_apellido);

  }
}