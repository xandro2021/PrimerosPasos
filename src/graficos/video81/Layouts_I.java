package graficos.video81;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

public class Layouts_I {
  public static void start() {

    JFrame marco = new Marco();
    marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  }
}

class Marco extends JFrame {

  public Marco() {

    setTitle("Video81 Layouts I");
    setBounds(600, 350, 600, 300);

    add(new Lamina(), BorderLayout.NORTH);
    add(new Lamina2(), BorderLayout.SOUTH);

    setVisible(true);

  }

}

class Lamina extends JPanel {

  public Lamina() {

    // setLayout(new FlowLayout(FlowLayout.CENTER, 50, 20));
    setLayout(new FlowLayout(FlowLayout.LEFT));
    // setLayout(new BorderLayout(10,10));

    add(new JButton("Yellow"));
    add(new JButton("Red"));

    setBackground(Color.BLUE);
  }

}

class Lamina2 extends JPanel {

  public Lamina2() {

    setBackground(Color.RED);
    setLayout(new BorderLayout());

    add(new JButton("Blue"), BorderLayout.WEST);
    add(new JButton("Cripton"), BorderLayout.SOUTH);
    add(new JButton("CYAN"), BorderLayout.NORTH);

  }

}