package graficos.video96;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class EJSLider {
  public static void start() {
    JFrame marco = new Marco();
    marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    marco.setVisible(true);
  }
}

class Marco extends JFrame {
  public Marco() {
    setTitle("Video96 Ejemplo JSlider");
    setBounds(500, 500, 550, 450);
    JPanel lamina = new LaminaSlider();
    add(lamina);
  }
}

class LaminaSlider extends JPanel {

  public LaminaSlider() {

    JSlider slidder = new JSlider(0,100,50);
    slidder.setMajorTickSpacing(50);
    slidder.setMinorTickSpacing(25);
    slidder.setPaintTicks(true);
    slidder.setPaintLabels(true);

    slidder.setSnapToTicks(true);

    slidder.setFont(new Font("Serif", Font.ITALIC, 12));
    add(slidder);

  }

}