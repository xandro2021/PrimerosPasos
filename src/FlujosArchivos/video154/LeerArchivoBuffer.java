package FlujosArchivos.video154;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeerArchivoBuffer {
  public static void start() {
    new LeerFichero().lee();
  }
}

class LeerFichero {

  public void lee() {

    try {

      FileReader entrada = new FileReader("src/recursos/leerArchivo.txt");

      BufferedReader mibuffer = new BufferedReader(entrada);

      String linea = "";

      /* Leerlo hasta el EOF */
      do {

        /* Leer linea */
        linea = mibuffer.readLine();

        System.out.println(linea);


      } while (linea != null);

      entrada.close();

    } catch (FileNotFoundException e) {
      System.out.println("Archivo no encontrado");
      System.out.println("Error " + e.getMessage());
      e.printStackTrace();
    } catch (IOException e) {
      System.out.println("Error " + e.getMessage());
      e.printStackTrace();
    }

  }

}