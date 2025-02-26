package graficos.video88;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

public class TextoFieldEventos {
  public static void start() {
    JFrame marco = new Marco();
    marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    marco.setVisible(true);
  }
}

class Marco extends JFrame {
  public Marco() {

    setTitle("Video88 Eventos de Text Field");
    setBounds(700, 300, 500, 350);

    add(new JPanelLamina());

  }
}

class JPanelLamina extends JPanel {

  public JPanelLamina() {

    micampo = new JTextField(20);
    micampo.getDocument().addDocumentListener(new EscuchaTexto());
    add(micampo);

  }

  private class EscuchaTexto implements DocumentListener {

    @Override
    public void changedUpdate(DocumentEvent e) {
      // TODO Auto-generated method stub

    }

    @Override
    public void insertUpdate(DocumentEvent e) {


    }

    @Override
    public void removeUpdate(DocumentEvent e) {
      System.out.println(micampo.getText());
    }

  }

  private JTextField micampo;
}