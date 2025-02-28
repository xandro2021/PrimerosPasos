package graficos.video97;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class EventoSlidder {
  public static void start() {
    JFrame marco = new Marco();
    marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    marco.setVisible(true);
  }
}

class Marco extends JFrame {
  public Marco() {
    setTitle("Video97 eventos de slidder");
    setBounds(500, 500, 550, 450);
    JPanel lamina = new LaminaSlidder();
    add(lamina);
  }
}

class LaminaSlidder extends JPanel {

  public LaminaSlidder() {
    setLayout(new BorderLayout());
    BL_Centro();
    BL_North();
  }

  private void BL_Centro() {
    rotulo = new JLabel("En un lugar de la mancha cuyo nombre...");
    add(rotulo, BorderLayout.CENTER);
  }

  private void BL_North() {

    control = new JSlider(8, 50, 12);

    control.setMajorTickSpacing(20);
    control.setMinorTickSpacing(5);
    control.setPaintTicks(true);
    control.setPaintLabels(true);
    control.addChangeListener(new EventoSlider());

    control.setFont(new Font("Serif", Font.ITALIC, 10));

    JPanel lamina_slider = new JPanel();
    lamina_slider.add(control);
    add(lamina_slider, BorderLayout.NORTH);

  }

  private class EventoSlider implements ChangeListener {
    @Override
    public void stateChanged(ChangeEvent e) {
      rotulo.setFont(new Font("Serif", Font.PLAIN, control.getValue()));
    }
  }

  private JLabel rotulo;
  private JSlider control;
}