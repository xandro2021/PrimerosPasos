package FlujosArchivos.video152;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Acceso_Fichero {
  public static void start() {
    new LeerFichero().lee();
  }
}

class LeerFichero {

  public void lee() {

    try {

      FileReader entrada = new FileReader("src/recursos/leerArchivo.txt");

      int c = entrada.read();

      /* Leerlo hasta el EOF */
      while (c != -1) {

        /* Leer codigos unicode */
        c = entrada.read();

        char letra = (char) c;
        System.out.print(letra);

      }

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