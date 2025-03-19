package graficos.video150;

import javax.swing.JOptionPane;

public class DebugJava {
  public static void start() {

    int elementos = Integer.parseInt(JOptionPane.showInputDialog("Introduce elementos de la matriz"));

    int num_aleat[] = new int[elementos];

    for (int i = 0; i < num_aleat.length; i++) {

      num_aleat[i] = (int) (Math.random() * 100);

    }

    for (int elem : num_aleat) {
      System.out.println(elem);
    }

  }
}