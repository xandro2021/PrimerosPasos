package graficos.video123;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.Date;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

class Marco extends JFrame {
  public Marco() {
    setTitle("Video 123 - 131 Ejercicio Practico Swing");
    setBounds(500, 500, 600, 450);
    BD_Center();
    BD_South();
  }

  private void BD_Center() {
    JPanel lamina_cuadricula = new JPanel(new GridLayout(2, 3));

    String primero[] = { "Mensaje", "Confirmar", "Opción", "Entrada" };
    lamina_tipo = new Lamina_Botones("Tipo", primero);

    lamina_tipo_mensajes = new Lamina_Botones("Tipo de Mensaje", new String[] {
        "ERROR_MESSAGE",
        "INFORMATION_MESSAGE",
        "WARNING_MESSAGE",
        "QUESTION_MESSAGE",
        "PLAIN_MESSAGE"
    });

    lamina_mensaje = new Lamina_Botones("Mensaje", new String[] {
        "Cadena",
        "Icono",
        "Componente",
        "Otros",
        "Object[]"
    });

    lamina_tipo_opcion = new Lamina_Botones("Confirmar", new String[] {
        "DEFAULT_OPTION",
        "YES_NO_OPTION",
        "YES_NO_CANCEL_OPTION",
        "OK_CANCEL_OPTION",
    });

    lamina_opciones = new Lamina_Botones("Opción", new String[] {
        "String[]",
        "Icon[]",
        "Object[]",
    });

    lamina_entrada = new Lamina_Botones("Entrada", new String[] {
        "Campo de Texto",
        "Combo",
    });

    lamina_cuadricula.add(lamina_tipo);
    lamina_cuadricula.add(lamina_tipo_mensajes);
    lamina_cuadricula.add(lamina_mensaje);
    lamina_cuadricula.add(lamina_tipo_opcion);
    lamina_cuadricula.add(lamina_opciones);
    lamina_cuadricula.add(lamina_entrada);

    add(lamina_cuadricula, BorderLayout.CENTER);

  }

  private void BD_South() {

    JPanel lamina_mostrar = new JPanel();
    JButton boton_mostrar = new JButton("Mostrar");

    boton_mostrar.addActionListener(new AccionMostrar());

    lamina_mostrar.add(boton_mostrar);
    add(lamina_mostrar, BorderLayout.SOUTH);

  }

  /*
   * PROPORCIONA EL MENSAJE
   * El mensaje estran representados por
   * los campos globales de la clase
   */
  private Object dameMensaje() {

    String opcion_mensaje = lamina_mensaje.dameSeleccion();

    switch (opcion_mensaje) {

      case "Cadena":
        return cadena_mensaje;

      case "Icono":
        return icono_mensaje;

      case "Componente":
        return componente_mensaje;

      case "Otros":
        return objeto_mensaje;

      case "Object[]":
        return new Object[] {
            cadena_mensaje,
            icono_mensaje,
            componente_mensaje,
            objeto_mensaje
        };

      default:
        return null;
    }

  }

  /*
   * DEVUELVE TIPO ICONO Y Tambien el numero de botones en confirmar
   * Que se mostrara en la ventana de confirmacion
   */
  private int dameTipo(Lamina_Botones lamina) {

    String opciones_seleccionadas = lamina.dameSeleccion();

    switch (opciones_seleccionadas) {

      case "ERROR_MESSAGE":
      case "YES_NO_OPTION":
        return 0;

      case "INFORMATION_MESSAGE":
      case "YES_NO_CANCEL_OPTION":
        return 1;

      case "WARNING_MESSAGE":
      case "OK_CANCEL_OPTION":
        return 2;

      case "QUESTION_MESSAGE":
        return 3;

      case "PLAIN_MESSAGE":
      case "DEFAULT_OPTION":
        return -1;

      default:
        return 0;
    }

  }

  /*
   * Da opciones a la LAMINA OPCION
   * Es la penultima lamina
   * Solo funciona cuando la primera lamina tiene seleccionado Opcion
   */
  private Object[] dameOpciones(Lamina_Botones lamina) {

    String opcion = lamina.dameSeleccion();

    switch (opcion) {

      case "String[]":
        return new String[] { "Amarillo", "Azul", "Rojo" };

      case "Icon[]":
        return new Object[] {
            new ImageIcon("bin/graficos/imagenes/rojo.png"),
            new ImageIcon("bin/graficos/imagenes/azul.png"),
            new ImageIcon("bin/graficos/imagenes/amarillo.png"),
        };

      case "Object[]":
        return new Object[] {
            cadena_mensaje,
            icono_mensaje,
            componente_mensaje,
            objeto_mensaje
        };

      default:
        return null;

    }

  }

  private class AccionMostrar implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

      switch (lamina_tipo.dameSeleccion()) {

        case "Mensaje":
          JOptionPane.showMessageDialog(Marco.this, dameMensaje(), "Título", dameTipo(lamina_tipo_mensajes));
          break;

        case "Confirmar":
          JOptionPane.showConfirmDialog(Marco.this, dameMensaje(), "Título", dameTipo(lamina_tipo_opcion),
              dameTipo(lamina_tipo_mensajes));
          break;

        case "Entrada":

          if (lamina_entrada.dameSeleccion().equals("Campo de Texto")) {
            JOptionPane.showInputDialog(Marco.this, dameMensaje(), "Titulo", dameTipo(lamina_tipo_mensajes));
          } else {
            JOptionPane.showInputDialog(Marco.this, dameMensaje(), "Titulo", dameTipo(lamina_tipo_mensajes), null,
                new String[] { "Amaril", "Azuril", "Rousil" }, "Azuril");
          }
          break;

        case "Opción":
          JOptionPane.showOptionDialog(Marco.this, dameMensaje(), "Titulo", 0, dameTipo(lamina_tipo_mensajes), null,
              dameOpciones(lamina_opciones), null);
          break;

        default:

      }

    }

  }

  private Lamina_Botones lamina_tipo, lamina_tipo_mensajes, lamina_mensaje, lamina_tipo_opcion, lamina_opciones,
      lamina_entrada;
  private String cadena_mensaje = "Mensaje";
  private Icon icono_mensaje = new ImageIcon("bin/graficos/imagenes/rojo.png");
  private Object objeto_mensaje = new Date();
  private Component componente_mensaje = new Lamina_Ejemplo();
}

class Lamina_Ejemplo extends JPanel {
  @Override
  protected void paintComponent(Graphics g) {

    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;

    Rectangle2D rectangulo = new Rectangle2D.Double(0, 0, getWidth(), getHeight());

    g2.setPaint(Color.YELLOW);
    g2.fill(rectangulo);

  }
}