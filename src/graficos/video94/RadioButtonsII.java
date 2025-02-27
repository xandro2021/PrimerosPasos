package graficos.video94;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RadioButtonsII {
  public static void start() {
    JFrame marco = new Marco();
    marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    marco.setVisible(true);
  }
}

class Marco extends JFrame {
  public Marco() {
    setTitle("Video94 RadioButtonsII");
    setBounds(500, 500, 500, 350);
    JPanel lamina = new Lamina_Radio();
    add(lamina);
  }
}

class Lamina_Radio extends JPanel {

  public Lamina_Radio() {

    setLayout(new BorderLayout());

    texto = new JLabel("En un lugar de la mancha cuyo nombre...");
    texto.setFont(new Font("Serif", Font.PLAIN, 12));
    add(texto, BorderLayout.CENTER);

    group = new ButtonGroup();
    lamina_botones = new JPanel();
    agregarBoton("Pequeño", false, 10);
    agregarBoton("Mediano", true, 12);
    agregarBoton("Grande", false, 18);
    agregarBoton("Muy Grande", false, 26);

    add(lamina_botones, BorderLayout.SOUTH);
  }

  private void agregarBoton(String nombre, boolean seleccionado, final int tamanio) {

    JRadioButton boton = new JRadioButton(nombre, seleccionado);
    group.add(boton);
    lamina_botones.add(boton);

    boton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        texto.setFont(new Font("Serif", Font.PLAIN, tamanio));
      }
    });

  }

  private JLabel texto;
  private ButtonGroup group;
  private JPanel lamina_botones;
}