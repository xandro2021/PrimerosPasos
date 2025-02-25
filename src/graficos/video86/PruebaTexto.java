package graficos.video86;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

public class PruebaTexto {
  public static void start() {
    JFrame marco = new Marco();
    marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    marco.setVisible(true);
  }
}

class Marco extends JFrame {
  public Marco() {

    setTitle("video86 Prueba de Textos");
    setBounds(600, 300, 600, 350);

    JPanel lamina = new JPanelLaminaTexto();
    setFontRecursive(lamina, new Font("Arial", Font.PLAIN, 15));
    add(lamina);

  }

  private void setFontRecursive(Component c, Font font) {
    c.setFont(font);
    if (c instanceof Container) {
      Container container = (Container) c;
      for (Component child : container.getComponents()) {
        setFontRecursive(child, font);
      }
    }
  }
}

class JPanelLaminaTexto extends JPanel {

  public JPanelLaminaTexto() {

    setLayout(new BorderLayout());

    JPanel lamina2 = new JPanel();

    JLabel email = new JLabel("Email");
    lamina2.add(email);

    campo1 = new JTextField(20);
    lamina2.add(campo1);


    JButton button = new JButton("Agregar");
    button.addActionListener(new AgregarTexto());
    lamina2.add(button);

    add(lamina2, BorderLayout.NORTH);

    resultado = new JLabel("", JLabel.CENTER);
    add(resultado, BorderLayout.CENTER);

  }

  private class AgregarTexto implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {

      String emailstr = campo1.getText().trim();
      boolean valido = Pattern.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", emailstr);

      if (valido) {
        resultado.setText("Correcto");
      }
      else {
        resultado.setText("INVALIDO");
      }

    }
  }

  private JTextField campo1;
  private JLabel resultado;
}