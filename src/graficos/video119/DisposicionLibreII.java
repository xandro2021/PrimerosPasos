package graficos.video119;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DisposicionLibreII {
  public static void start() {
    JFrame marco = new Marco();
    marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    marco.setVisible(true);
  }
}

class Marco extends JFrame {
  public Marco() {
    setTitle("Video119 DisposicionLibre II");
    setBounds(500, 500, 550, 450);
    add(new Lamina());
  }
}

class Lamina extends JPanel {
  public Lamina() {

    setLayout(new EnColumnas());

    JLabel nombre = new JLabel("Nombre:");
    JLabel apellido = new JLabel("Apellido:");
    JLabel edad = new JLabel("Edad:");
    JLabel telefono = new JLabel("Telefono:");

    JTextField c_nombre = new JTextField();
    JTextField c_apellido = new JTextField();
    JTextField c_edad = new JTextField();
    JTextField c_telefono = new JTextField();

    add(nombre);
    add(c_nombre);
    add(apellido);
    add(c_apellido);
    add(edad);
    add(c_edad);
    add(telefono);
    add(c_telefono);

  }
}

class EnColumnas implements LayoutManager {

  private int x; // Posición inicial en x
  private int y; // Posición inicial en y

  @Override
  public void addLayoutComponent(String e, Component arg1) {
    // No se necesita hacer nada aquí
  }

  @Override
  public void layoutContainer(Container micontenedor) {
    int ancho_padre = micontenedor.getWidth();
    int contador = 0;
    int numero_componentes = micontenedor.getComponentCount();

    // Reiniciar las variables x e y
    x = ancho_padre / 2;
    y = 20;

    for (int i = 0; i < numero_componentes; i++) {
      contador++;
      Component component = micontenedor.getComponent(i);
      component.setBounds(x - 100, y, 100, 20);

      // Incrementar x para el siguiente componente
      x += 100;

      if (contador % 2 == 0) {
        x = ancho_padre / 2;
        y += 40;
      }
    }
  }

  @Override
  public Dimension minimumLayoutSize(Container e) {
    return null;
  }

  @Override
  public Dimension preferredLayoutSize(Container e) {
    return null;
  }

  @Override
  public void removeLayoutComponent(Component e) {
    // No se necesita hacer nada aquí
  }
}