package FlujosArchivos.video153;

import java.io.FileWriter;
import java.io.IOException;

public class EscribirArchivo {
  public static void start() {
    new Escribiendo().escribir();
  }
}

class Escribiendo {

  public void escribir() {

    String frase = "Esto es una prueba de escritura";

    try {

      /* Se usa el boolean para actualizar el archivo en vez de volver a
       * crearlo, en caso de que el archivo ya existiera */
      FileWriter escritura = new FileWriter("src/recursos/archivoEscritoDesdeJava.txt", true);

      for (int i = 0; i<frase.length(); i++) {
        escritura.write(frase.charAt(i));
      }

      escritura.write("\n");
      escritura.close();

    } catch (IOException e) {
      System.out.println("Error " + e.getMessage());
      e.printStackTrace();
    }

  }

}