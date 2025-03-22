package ClaseFile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileparteII {
  public static void start() {
    new Creando().run();
  }
}

class Creando {

  public void run() {

    /* File.separator: se puede usar para casos donde no se acepta / */
    File ruta = new File("/home/xandro/Documentos/CREADODESDEJAVAPORCODIGO");
    ruta.mkdir();

    File ruta_nuevo_archivo = new File(ruta, "NuevoArchivo.txt");
    String archivo_destino = ruta_nuevo_archivo.getAbsolutePath();

    try {

      ruta_nuevo_archivo.createNewFile();

    } catch (IOException e) {
      System.out.println("Error " + e.getMessage());
      e.printStackTrace();
    }

    Escribiendo.escribir(archivo_destino);

    /*
     * Eliminar el archivo
     */
    if(JOptionPane.showConfirmDialog(null, "Deseas eliminar el archivo?", "Confirmacion", 0)==0){
      ruta_nuevo_archivo.delete();
      System.out.println("Archivo eliminado con exito");
    }

    if(JOptionPane.showConfirmDialog(null, "Deseas eliminar el directorio vacio?", "Confirmacion", 0)==0){
      ruta.delete();
      System.out.println("directorio eliminado con exito");
    }

  }

}

class Escribiendo {

  public static void escribir(String ruta_archivo) {

    String frase = "ESTO ES UN EJEMPLO";

    try (FileWriter escritura = new FileWriter(ruta_archivo)) {

      for (char letra : frase.toCharArray()) {
        escritura.write(letra);
      }

    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}