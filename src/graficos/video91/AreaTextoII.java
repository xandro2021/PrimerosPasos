package graficos.video91;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AreaTextoII {
  public static void start() {

    JFrame marco = new Marco();
    marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    marco.setVisible(true);

  }
}

class Marco extends JFrame {
  public Marco() {

    setLayout(new BorderLayout());
    setTitle("video91 AreaTextoII");
    setBounds(500, 500, 500, 350);

    laminaBotones = new JPanel();

    botonInsertar = new JButton("Insertar");
    botonInsertar.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        areaTexto.append("En un Lugar de la Mancha cuyo nombre no quiero Acordarme....");
      }
    });

    botonSaltoLinea = new JButton("Salto de Linea");
    botonSaltoLinea.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {

        boolean saltar = !areaTexto.getLineWrap();
        areaTexto.setLineWrap(saltar);

        botonSaltoLinea.setText(saltar ? "Quitar Salto" : "Salto Linea");
      }
    });

    laminaBotones.add(botonInsertar);
    laminaBotones.add(botonSaltoLinea);

    areaTexto = new JTextArea(8, 20);
    laminaConBarras = new JScrollPane(areaTexto);

    add(laminaBotones, BorderLayout.SOUTH);
    add(laminaConBarras, BorderLayout.CENTER);
  }

  private JPanel laminaBotones;
  private JButton botonInsertar, botonSaltoLinea;
  private JTextArea areaTexto;
  private JScrollPane laminaConBarras;
}
