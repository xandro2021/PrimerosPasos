package graficos.video95;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComboBoxEJ {
  public static void start() {
    JFrame marco = new Marco();
    marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    marco.setVisible(true);
  }
}

class Marco extends JFrame {
  public Marco() {
    setTitle("Video65 JComboBox");
    setBounds(500, 500, 550, 400);
    JPanel lamina = new LaminaCombo();
    add(lamina);
  }
}

class LaminaCombo extends JPanel {

  public LaminaCombo() {

    setLayout(new BorderLayout());

    texto = new JLabel("En un lugar de la mancha cuyo nombre.......");
    texto.setFont(new Font("Serif", Font.PLAIN, 18));
    add(texto, BorderLayout.CENTER);

    comoBoxNorte();

  }

  private void comoBoxNorte() {

    JPanel lamina_norte = new JPanel();

    lista = new JComboBox<String>();
    lista.setEditable(true);

    lista.addItem("Serif");
    lista.addItem("SansSerif");
    lista.addItem("Monospaced");
    lista.addItem("Dialog");
    lista.addItem("Ubuntu");
    lista.addItem("JetBrains Mono");
    lista.addItem("Arial");

    lista.addActionListener(new Evento_Combo());

    lamina_norte.add(lista);
    add(lamina_norte, BorderLayout.NORTH);

  }

  private class Evento_Combo implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {

      String texto_seleccionado = lista.getSelectedItem().toString();
      texto.setFont(new Font(texto_seleccionado, Font.PLAIN, 18));

    }
  }

  private JLabel texto;
  private JComboBox<String> lista;
}