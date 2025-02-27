package graficos.video92;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JCheckBox;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PruebaCheckBox {
  public static void start() {
    JFrame marco = new Marco();
    marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    marco.setVisible(true);
  }
}

class Marco extends JFrame {
  public Marco() {
    setTitle("video92 PruebaCheckBox");
    setBounds(500, 500, 500, 350);
    add(new JPaneCheckBox());
  }
}

class JPaneCheckBox extends JPanel {

  public JPaneCheckBox() {

    setLayout(new BorderLayout());

    Font font = new Font("Serif", Font.PLAIN, 24);

    texto = new JLabel("En un lugar de la mancha de cuyo nombre...");
    texto.setFont(font);

    JPanel laminatexto = new JPanel();
    laminatexto.add(texto);
    add(laminatexto, BorderLayout.CENTER);

    checkBox1 = new JCheckBox("Negrita");
    checkBox2 = new JCheckBox("Cursiva");

    ActionListener evento_check = new ManejaChecks();
    checkBox1.addActionListener(evento_check);
    checkBox2.addActionListener(evento_check);

    JPanel lamina_checks = new JPanel();
    lamina_checks.add(checkBox1);
    lamina_checks.add(checkBox2);
    add(lamina_checks, BorderLayout.SOUTH);

  }

  private class ManejaChecks implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {

      int tipo = 0;

      if (checkBox1.isSelected()) tipo += Font.BOLD;
      if (checkBox2.isSelected()) tipo += Font.ITALIC;

      texto.setFont(new Font("Serif", tipo, 24));

    }
  }

  private JLabel texto;
  private JCheckBox checkBox1, checkBox2;
}