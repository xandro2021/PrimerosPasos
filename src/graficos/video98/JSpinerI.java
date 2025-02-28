package graficos.video98;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;

public class JSpinerI {
  public static void start() {
    JFrame marco = new Marco();
    marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    marco.setVisible(true);
  }
}

class Marco extends JFrame {
  public Marco() {
    setTitle("Video98 JSpinerI");
    setBounds(500, 500, 550, 450);
    add(new LaminaSpinner());
  }
}

class LaminaSpinner extends JPanel {

  public LaminaSpinner() {

    // JSpinner spinner = new JSpinner(new SpinnerDateModel());
    // String lista[] =
    // GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
    // JSpinner spinner = new JSpinner(new SpinnerListModel(lista));
    // JSpinner spinner = new JSpinner(new SpinnerNumberModel(5, 0, 10, 1));
    JSpinner spinner = new JSpinner(new MiModeloJSpinner());
    spinner.setPreferredSize(new Dimension(200, 20));
    add(spinner);

  }

  private class MiModeloJSpinner extends SpinnerNumberModel {

    public MiModeloJSpinner() {
      super(5, 0, 10, 1);
    }

    @Override
    public Object getNextValue() {
        return super.getPreviousValue();
    }

    @Override
    public Object getPreviousValue() {
        return super.getNextValue();
    }

  }

}