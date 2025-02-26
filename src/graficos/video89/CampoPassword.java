package graficos.video89;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

public class CampoPassword {
  public static void start() {
    JFrame marco = new Marco();
    marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    marco.setVisible(true);
  }
}

class Marco extends JFrame {
  public Marco() {
    setTitle("Video89 TextField Password Verificacion");
    setBounds(500, 500, 550, 400);
    add(new LaminaPassword());
  }
}

class LaminaPassword extends JPanel {
  public LaminaPassword() {

    setLayout(new BorderLayout());

    /*
     * LAMINA SUPERIOR
     */
    JPanel laminaSuperior = new JPanel();
    laminaSuperior.setLayout(new GridLayout(2, 2));

    JLabel etiqueta1 = new JLabel("Usuario");
    JLabel etiqueta2 = new JLabel("Password");

    JTextField c_usuario = new JTextField(15);

    c_password = new JPasswordField(15);

    c_password.getDocument().addDocumentListener(new CompruebaPassword());

    laminaSuperior.add(etiqueta1);
    laminaSuperior.add(c_usuario);
    laminaSuperior.add(etiqueta2);
    laminaSuperior.add(c_password);

    add(laminaSuperior, BorderLayout.NORTH);

    /*
     * LAMINA INFERIOR
     */
    JButton boton = new JButton("Enviar");
    add(boton, BorderLayout.SOUTH);

  }

  private class CompruebaPassword implements DocumentListener {

    @Override
    public void changedUpdate(DocumentEvent e) {
      // TODO Auto-generated method stub

    }

    @Override
    public void insertUpdate(DocumentEvent e) {
      pintarPassword();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
      pintarPassword();
    }

    private void pintarPassword() {
      char[] password = c_password.getPassword();

      if (password.length < 8 || password.length > 12) {
        c_password.setBackground(Color.RED);
      }
      else {
        c_password.setBackground(Color.WHITE);
      }
    }

  }

  private JPasswordField c_password;
}