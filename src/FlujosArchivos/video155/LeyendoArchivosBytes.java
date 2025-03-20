package FlujosArchivos.video155;

import java.io.FileInputStream;
import java.io.FileOutputStream;
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

    creaFichero(datos_entrada);

  }

  private static void creaFichero(int[] datos_nuevo_fichero) {

    try {

      FileOutputStream fichero_nuevo = new FileOutputStream("src/recursos/archivosBytes/imagenCopia.jpg");

      for (int i = 0; i < datos_nuevo_fichero.length; i++) {
        fichero_nuevo.write(datos_nuevo_fichero[i]);
      }

      fichero_nuevo.close();

      System.out.println("Se creado la copia del archivo!");

    } catch (IOException e) {
      System.out.println("Error " + e.getMessage());
      e.printStackTrace();
    }

  }

}
