package graficos.video62;

import java.awt.GraphicsEnvironment;

public class ListaFuentesSystema {
  public static void start() {

    String[] fuentes = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

    for (String fuente : fuentes) {
      System.out.println(fuente);
    }

  }
}