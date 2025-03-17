package graficos.video144;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExcepcionesI {
  public static void start() {

    System.out.println("Que deseas hacer?");
    System.out.println("1. Introducir datos");
    System.out.println("2. Salir del programa");

    Scanner scanner = new Scanner(System.in);

    try {

      int decision = scanner.nextInt();

      if (decision == 1) {
        System.out.println("Datos solicitados");
        pedirDatos();
      } else {
        System.out.println("Adios...");
        System.exit(0);
      }

    } catch (InputMismatchException e) {
      System.out.println("Debes introducir un numero en la edad");
    }

    scanner.close();

  }

  private static void pedirDatos() throws InputMismatchException {

    Scanner scanner = new Scanner(System.in);

    System.out.println("Introduce tu nombre");
    String nombre_usuario = scanner.nextLine();

    System.out.println("Introduce tu edad");
    int edad_usuario = scanner.nextInt();

    System.out.println("Hola " + nombre_usuario + ". El año que viene tendrás " + (edad_usuario + 1) + " años");

    scanner.close();

    System.out.println("Hemos terminado");

  }

}
