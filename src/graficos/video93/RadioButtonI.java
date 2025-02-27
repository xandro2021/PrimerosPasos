package graficos.video93;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class RadioButtonI {
  public static void start() {
    JFrame marco = new Marco();
    marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    marco.setVisible(true);
  }
}

class Marco extends JFrame {
  public Marco() {
    setTitle("video93 RadioButtonI");
    setBounds(500, 500, 500, 350);
    add(new LaminaRadioI());
  }
}

class LaminaRadioI extends JPanel {

  public LaminaRadioI() {

    ButtonGroup grupo1 = new ButtonGroup();
    ButtonGroup grupo2 = new ButtonGroup();

    JRadioButton boton1 = new JRadioButton("Azul");
    JRadioButton boton2 = new JRadioButton("Rojo");
    JRadioButton boton3 = new JRadioButton("Verde");

    JRadioButton boton4 = new JRadioButton("Masculino");
    JRadioButton boton5 = new JRadioButton("Femenino");

    grupo1.add(boton1);
    grupo1.add(boton2);
    grupo1.add(boton3);

    grupo2.add(boton4);
    grupo2.add(boton5);

    add(boton1);
    add(boton2);
    add(boton3);
    add(boton4);
    add(boton5);

  }

}