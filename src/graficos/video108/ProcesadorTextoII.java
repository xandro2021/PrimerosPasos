package graficos.video108;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.InputEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.text.StyledEditorKit;

public class ProcesadorTextoII {
  public static void start() {
    JFrame marco = new Marco();
    marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    marco.setVisible(true);
  }
}

class Marco extends JFrame {
  public Marco() {
    setTitle("video108 ProcesadorTexto III");
    setBounds(300, 240, 350, 250);
    // setBounds(500, 500, 550, 450);
    JPanel lamina = new LaminaProcesador();
    add(lamina);
  }
}

class LaminaProcesador extends JPanel {

  public LaminaProcesador() {
    setLayout(new BorderLayout());
    BD_North();
    BD_Center();
  }

  private void BD_North() {

    JPanel lamina_menu = new JPanel();

    JMenuBar mibarra = new JMenuBar();

    /* ****************************/
    fuente = new JMenu("Fuente");
    estilo = new JMenu("Estilo");
    tamanio = new JMenu("Tamaño");

    Configura_Menu("Arial", "fuente", "Arial", 9, 10);
    Configura_Menu("Courier", "fuente", "Courier", 9, 10);
    Configura_Menu("Ubuntu", "fuente", "Ubuntu", 9, 10);

    /* ****************************/
    group_tamanio = new ButtonGroup();
    emergente = new JPopupMenu();

    Configura_Menu("Negrita", "estilo", "", Font.BOLD, 1);
    Configura_Menu("Cursiva", "estilo", "", Font.ITALIC, 1);

    /* ****************************/
    Configura_Menu("12", "tamanio", "", 9, 12);
    Configura_Menu("16", "tamanio", "", 9, 16);
    Configura_Menu("20", "tamanio", "", 9, 20);
    Configura_Menu("24", "tamanio", "", 9, 24);

    mibarra.add(fuente);
    mibarra.add(estilo);
    mibarra.add(tamanio);

    lamina_menu.add(mibarra);
    add(lamina_menu, BorderLayout.NORTH);

  }

  private void BD_Center() {
    miarea = new JTextPane();
    add(miarea, BorderLayout.CENTER);
    miarea.setComponentPopupMenu(emergente);
  }

  private void Configura_Menu(String rotulo, String menu, String tipo_letra, int estilos, int tam) {

    JMenuItem elem_menu = agregarIconoMenu(rotulo);

    switch (menu) {
      case "fuente":
        fuente.add(elem_menu);
        elem_menu.addActionListener(new StyledEditorKit.FontFamilyAction("cambia_letra", tipo_letra));
        break;

      case "estilo":
        estilo.add(elem_menu);

        if (estilos == Font.BOLD) {
          elem_menu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
          elem_menu.addActionListener(new StyledEditorKit.BoldAction());
        } else if (estilos == Font.ITALIC) {
          elem_menu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, InputEvent.CTRL_DOWN_MASK));
          elem_menu.addActionListener(new StyledEditorKit.ItalicAction());
        }

        emergente.add(clonarMenuItem(elem_menu));
        break;

      case "tamanio":
        group_tamanio.add(elem_menu);
        tamanio.add(elem_menu);
        elem_menu.addActionListener(new StyledEditorKit.FontSizeAction("cambia_tamanio", tam));
        break;
    }

  }

  private JMenuItem clonarMenuItem(JMenuItem menuItem) {
    JCheckBoxMenuItem menuItemClonado = new JCheckBoxMenuItem(menuItem.getText());
    menuItemClonado.setIcon(menuItem.getIcon());
    menuItemClonado.setAccelerator(menuItem.getAccelerator());
    menuItemClonado.setEnabled(menuItem.isEnabled());
    menuItemClonado.addActionListener(menuItem.getActionListeners()[0]);
    coordinarEstadosMenuItems((JCheckBoxMenuItem) menuItem, menuItemClonado);
    return menuItemClonado;
  }

  private void coordinarEstadosMenuItems(JCheckBoxMenuItem menuItem, JCheckBoxMenuItem menuItemClonado) {
    ItemListener coordinar_estados = new ItemListener() {
      @Override
      public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == menuItem) {
          menuItemClonado.setState(e.getStateChange() == ItemEvent.SELECTED);
        } else {
          menuItem.setState(e.getStateChange() == ItemEvent.SELECTED);
        }
      }
    };

    menuItem.addItemListener(coordinar_estados);
    menuItemClonado.addItemListener(coordinar_estados);
  }

  private JMenuItem agregarIconoMenu(String rotulo) {
    JMenuItem elem_menu;

    switch (rotulo) {
      case "Negrita":
        elem_menu = new JCheckBoxMenuItem(rotulo);
        elem_menu.setIcon(new ImageIcon("bin/graficos/imagenes/rojo.png"));
        break;
      case "Cursiva":
        elem_menu = new JCheckBoxMenuItem(rotulo, new ImageIcon("bin/graficos/imagenes/azul.png"));
        elem_menu.setHorizontalTextPosition(SwingConstants.LEFT);
        break;

      default:
        elem_menu = isNumber(rotulo) ? new JRadioButtonMenuItem(rotulo) : new JMenuItem(rotulo);
    }

    return elem_menu;
  }

  private boolean isNumber(String rotulo) {

    try {
      byte b = Byte.parseByte(rotulo);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }

  }

  private JTextPane miarea;
  private JMenu fuente, estilo, tamanio;
  private ButtonGroup group_tamanio;
  private JPopupMenu emergente;
}