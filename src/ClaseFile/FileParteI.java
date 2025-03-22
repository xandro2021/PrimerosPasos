package ClaseFile;

import java.io.File;

public class FileParteI {
  public static void start() {

    FileEjemploII.start();

  }
}

class FileEjemploI {
  public static void start() {

    File archivo = new File("bin");
    System.out.println(archivo.getAbsolutePath());
    System.out.println(archivo.exists());

  }
}

class FileEjemploII {
  public static void start() {

    File ruta = new File("/home/xandro/Documentos/UCR");
    System.out.println(ruta.getAbsolutePath());
    System.out.println("********************");
    // recorridoBasico(ruta);
    recorridoRecursivo(ruta, 0);

  }

  private static void recorridoRecursivo(File ruta, int num_identacion) {

    String[] elementos_hijos = ruta.list();

    if (elementos_hijos == null) {
      return;
    }

    StringBuilder indentacion = new StringBuilder();

    for (int i = 0; i < num_identacion; i++) {
      indentacion.append("    ");
    }

    for (String elemento_hijo : elementos_hijos) {

      System.out.println(indentacion + elemento_hijo);

      File nueva_ruta = new File(ruta, elemento_hijo);

      if (nueva_ruta.isDirectory()) {
        recorridoRecursivo(nueva_ruta, num_identacion + 1);
      }

    }

  }

  private static void recorridoBasico(File ruta) {

    /* Conseguir el contenido listado de la ruta */
    String[] lista_contenido = ruta.list();

    for (String archivo_directorio : lista_contenido) {
      System.out.println(archivo_directorio);
      File elem_actual = new File(ruta.getAbsolutePath(), archivo_directorio);

      if (elem_actual.isDirectory()) {
        String[] archivos_subcarpeta = elem_actual.list();

        for (String hijo : archivos_subcarpeta) {
          System.out.println("  " + hijo);
        }
      }
    }

  }
}