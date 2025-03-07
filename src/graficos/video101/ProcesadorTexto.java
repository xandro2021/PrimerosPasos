package graficos.video101;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class ProcesadorTexto {
  public static void start() {
    JFrame marco = new Marco();
    marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    marco.setVisible(true);
  }
}

class Marco extends JFrame {
  public Marco() {
    setTitle("video101-105 Procesador de Texto");
    setBounds(500, 500, 550, 450);
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
  }

  private void Configura_Menu(String rotulo, String menu, String tipo_letra, int estilos, int tam) {

    JMenuItem elem_menu = new JMenuItem(rotulo);

    switch (menu) {
      case "fuente":
        fuente.add(elem_menu);
        break;

      case "estilo":
        estilo.add(elem_menu);
        break;

      case "tamanio":
        tamanio.add(elem_menu);
        break;
    }

    elem_menu.addActionListener(new Gestiona_Eventos(rotulo, tipo_letra, estilos, tam));
  }

  private class Gestiona_Eventos implements ActionListener {
    private String tipo_texto, menu;
    private int estilo_letra, tamanio_letra;

    public Gestiona_Eventos(String elemento, String texto2, int estilo2, int tam_letra) {
      tipo_texto = texto2;
      estilo_letra = estilo2;
      tamanio_letra = tam_letra;
      menu = elemento;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      letras = miarea.getFont();

      if (menu.equals("Arial") || menu.equals("Courier") || menu.equals("Ubuntu")) {
        estilo_letra = letras.getStyle();
        tamanio_letra = letras.getSize();
      }
      else if (menu.equals("Cursiva") || menu.equals("Negrita")) {
        if (letras.getStyle() == 1 || letras.getStyle() == 2) {
          tamanio_letra = 3;
        }
        tipo_texto = letras.getName();
        tamanio_letra = letras.getSize();
      }
      else {
        estilo_letra = letras.getStyle();
        tipo_texto = letras.getName();
      }

      miarea.setFont(new Font(tipo_texto, estilo_letra, tamanio_letra));

      System.out.println("Tipo: " + tipo_texto + "\nEstilo: " + estilo_letra + "\nTamanio: " + tamanio_letra);
    }
  }

  JTextPane miarea;
  JMenu fuente, estilo, tamanio;
  Font letras;
}