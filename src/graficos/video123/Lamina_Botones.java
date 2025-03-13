package graficos.video123;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

class Lamina_Botones extends JPanel {

  public Lamina_Botones(String titulo, String[] opciones) {

    setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), titulo));

    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

    agregarBotones(opciones);

  }

  private void agregarBotones(String[] opciones) {
    grupo = new ButtonGroup();
    int i = 0;

    for (String opcion : opciones) {

      JRadioButton boton = new JRadioButton(opcion);
      boton.setActionCommand(opcion);

      grupo.add(boton);
      add(boton);

      boton.setSelected(i == 0);
      i++;

    }
  }

  public String dameSeleccion() {
    return grupo.getSelection().getActionCommand();
  }

  private ButtonGroup grupo;
}