package graficos.video111;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.InputMap;

public class BarraHerramientas {
  public static void start() {
    JFrame marco = new marcoAcciones();
    marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    marco.setVisible(true);
  }
}

class marcoAcciones extends JFrame {

  public marcoAcciones() {
    setBounds(300, 240, 350, 250);
    setTitle("video111 BarraHerramientas");
    add(new laminaAcciones());
  }

}

class laminaAcciones extends JPanel {

  public laminaAcciones() {
    setLayout(new BorderLayout());
    Action accionAmarillo = new AccionColor("Amarillo", new ImageIcon("bin/graficos/imagenes/amarillo.png"), Color.YELLOW);
    Action accionRojo = new AccionColor("Rojo", new ImageIcon("bin/graficos/imagenes/rojo.png"), Color.RED);
    Action accionAzul = new AccionColor("Azul", new ImageIcon("bin/graficos/imagenes/azul.png"), Color.BLUE);

    Action accionSalir = new AbstractAction("Salir", new ImageIcon("bin/graficos/imagenes/exit2.png")){
      @Override
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }
    };

    JMenu menu = new JMenu("Color");
    menu.add(accionAmarillo);
    menu.add(accionRojo);
    menu.add(accionAzul);

    JMenuBar barra_menu = new JMenuBar();
    barra_menu.add(menu);
    add(barra_menu, BorderLayout.NORTH);

    /*
     * Construccion de la barra de herramientas
     * Se crea un lamina_aplicacion dado que ya la lamina actual tiene ocupada
     * el BorderLayout.NORTH, asi que la lamina_aplicacion va a ocupar el resto
     * de la aplicacion y a su vez va a tener su propio border layout para
     * hubicar la barra de herramientas donde quiera. De lo contrario hubiera
     * tenido que hacer la barra de menu en el JFrame y usar el metodo
     * setJMenuBar(barra_menu)
     */
    JToolBar barra_herramientas = new JToolBar();
    barra_herramientas.add(accionAmarillo);
    barra_herramientas.add(accionRojo);
    barra_herramientas.add(accionAzul);

    barra_herramientas.addSeparator();
    barra_herramientas.add(accionSalir);

    lamina_aplicacion = new JPanel(new BorderLayout());
    lamina_aplicacion.add(barra_herramientas, BorderLayout.NORTH);
    add(lamina_aplicacion, BorderLayout.CENTER);
  }

  /*
   * AbastractAction, otro metodo para eventos
   * putValue para guardar un valor del evento (key,value)
   * getValue para rescatar un valor guardado del evento (key,value)
   */
  private class AccionColor extends AbstractAction {

    public AccionColor(String nombre, Icon icono, Color color_boton) {

      putValue(Action.NAME, nombre);
      putValue(Action.SMALL_ICON, icono);
      putValue(Action.SHORT_DESCRIPTION, "Poner la lamina de color " + nombre);
      putValue("color_de_fondo", color_boton);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

      Color c = (Color) getValue("color_de_fondo");
      lamina_aplicacion.setBackground(c);
      System.out.println("Nombre: " + getValue(Action.NAME) + '\n' + getValue(Action.SHORT_DESCRIPTION));

    }

  }

  JPanel lamina_aplicacion;
}
