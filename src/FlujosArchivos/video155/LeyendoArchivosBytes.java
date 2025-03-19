package FlujosArchivos.video155;

import java.io.FileInputStream;
import java.io.IOException;

public class LeyendoArchivosBytes {
  public static void start() {

    int datos_entrada[] = new int[29834];
    int contador = 0;

    try {

      FileInputStream archivo_lectura = new FileInputStream("src/recursos/imagen.jpg");

      boolean final_archivo = false;

      do {

        int byte_entrada = archivo_lectura.read();

        if (byte_entrada != -1) {
          datos_entrada[contador] = byte_entrada;
        } else {
          final_archivo = true;
        }

        System.out.println(datos_entrada[contador]);

        contador++;

      } while (!final_archivo);

      System.out.println("El archivo tiene: #" + contador + " lineas de bytes");
      archivo_lectura.close();

    } catch (IOException e) {
      System.out.println("Error " + e.getMessage());
      e.printStackTrace();
    }

  }
}
