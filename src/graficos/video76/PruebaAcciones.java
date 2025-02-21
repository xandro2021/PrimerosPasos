package graficos.video76;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.InputMap;

public class PruebaAcciones {
  public static void start() {
    JFrame marco = new marcoAcciones();
    marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}

class marcoAcciones extends JFrame {

  public marcoAcciones() {

    setSize(650, 450);
    setTitle("video76 PruebaAcciones Eventos varios");

    add(new laminaAcciones());

    setVisible(true);
  }

}

class laminaAcciones extends JPanel {

  public laminaAcciones() {

    AccionColor accionAmarillo = new AccionColor("Amarillo", new ImageIcon("src/graficos/video76/amarillo.png"), Color.YELLOW);
    AccionColor accionRojo = new AccionColor("Rojo", new ImageIcon("src/graficos/video76/rojo.png"), Color.RED);
    AccionColor accionAzul = new AccionColor("Azul", new ImageIcon("src/graficos/video76/azul.png"), Color.BLUE);

    add(new JButton(accionAmarillo));
    add(new JButton(accionRojo));
    add(new JButton(accionAzul));

    InputMap mapa_entrada = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);

    mapa_entrada.put(KeyStroke.getKeyStroke("ctrl A"), "fondo_amarillo");
    mapa_entrada.put(KeyStroke.getKeyStroke("ctrl B"), "fondo_azul");
    mapa_entrada.put(KeyStroke.getKeyStroke("ctrl R"), "fondo_rojo");


    ActionMap mapaAccion = getActionMap();
    mapaAccion.put("fondo_amarillo", accionAmarillo);
    mapaAccion.put("fondo_azul", accionAzul);
    mapaAccion.put("fondo_rojo", accionRojo);

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
      setBackground(c);
      System.out.println("Nombre: "+getValue(Action.NAME)+'\n'+getValue(Action.SHORT_DESCRIPTION));

    }

  }
}
