package graficos.video100;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MenuI {
  public static void start() {
    JFrame marco = new Marco();
    marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    marco.setVisible(true);
  }
}

class Marco extends JFrame {
  public Marco() {
    setTitle("Video100 Creacion de Menu I");
    setBounds(500, 500, 550, 450);
    JPanel lamina = new LaminaMenu();
    add(lamina);
  }
}

class LaminaMenu extends JPanel{

  public LaminaMenu() {

    JMenuBar mibarra = new JMenuBar();

    JMenu archivo = new JMenu("Archivo");
    JMenuItem guardar = new JMenuItem("Guardar");
    JMenuItem guardar_como = new JMenuItem("Guardar Como");

    archivo.add(guardar);
    archivo.add(guardar_como);

    JMenu edicion = new JMenu("Edicion");
    JMenuItem cortar = new JMenuItem("Cortar");
    JMenuItem copiar = new JMenuItem("Copiar");
    JMenuItem pegar = new JMenuItem("Pegar");
    JMenu opciones = new JMenu("Opciones");
    JMenuItem opcion1 = new JMenuItem("Opcion 1");
    JMenuItem opcion2 = new JMenuItem("Opcion 2");

    opciones.add(opcion1);
    opciones.add(opcion2);

    edicion.add(cortar);
    edicion.add(copiar);
    edicion.add(pegar);
    edicion.addSeparator();
    edicion.add(opciones);

    JMenu herramientas = new JMenu("Herramientas");
    JMenuItem generales = new JMenuItem("Generales");

    herramientas.add(generales);

    mibarra.add(archivo);
    mibarra.add(edicion);
    mibarra.add(herramientas);

    add(mibarra);

  }

}