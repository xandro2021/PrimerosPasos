package graficos.video55;

import java.awt.Frame;
import javax.swing.JFrame;

public class miMarco extends JFrame {

  public miMarco() {
    setSize(250, 250);
    // setLocation(500,300);
    // setBounds(500, 300, 550, 300);
    // setResizable(false);

    // setExtendedState(Frame.MAXIMIZED_BOTH);

    setTitle("Mi Ventana");


    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}