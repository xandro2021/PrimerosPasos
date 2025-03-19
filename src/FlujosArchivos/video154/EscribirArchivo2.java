package FlujosArchivos.video154;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EscribirArchivo2 {
  public static void start() {
    new Escribiendo().escribir();
  }
}

class Escribiendo {

  public void escribir() {

    String frase = "Esto es una prueba de escritura mediante buffer";

    try {

      /*
       * Se usa el boolean para actualizar el archivo en vez de volver a
       * crearlo, en caso de que el archivo ya existiera
       */
      FileWriter escritura = new FileWriter("src/recursos/archivoEscritoDesdeJava.txt", true);
      BufferedWriter mibuffer = new BufferedWriter(escritura);

      for (int i = 0; i < 10; i++) {
        mibuffer.write(frase);
        mibuffer.newLine();
        mibuffer.flush();
      }

      mibuffer.close();
      escritura.close();

    } catch (IOException e) {
      System.out.println("Error " + e.getMessage());
      e.printStackTrace();
    }

  }

}