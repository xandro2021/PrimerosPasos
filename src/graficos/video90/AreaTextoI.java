package graficos.video90;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AreaTextoI {
  public static void start() {
    JFrame marco = new Marco();
    marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    marco.setVisible(true);
  }
}

class Marco extends JFrame {
  public Marco() {
    setTitle("video90 AreaTexto I");
    setBounds(500, 500, 500, 350);
    JPanel lamina = new LaminaArea();
    add(lamina);
  }
}

class LaminaArea extends JPanel {

  public LaminaArea() {

    miarea = new JTextArea(8, 20);
    miarea.setLineWrap(true); // Produce salto de linea una vez llega al final

    JScrollPane laminaBarras = new JScrollPane(miarea);
    add(laminaBarras);

    JButton boton = new JButton("Informacion");
    boton.addActionListener(new GestionArea());
    add(boton);

  }

  private class GestionArea implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
      System.out.println(miarea.getText());
    }

  }

  private JTextArea miarea;
}