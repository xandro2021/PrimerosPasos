package graficos.video144;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExcepcionesI {
  private static Scanner scanner = new Scanner(System.in);

  public static void start() {

    System.out.println("Que deseas hacer?");
    System.out.println("1. Introducir datos");
    System.out.println("2. Salir del programa");

    try {

      int decision = scanner.nextInt();
      scanner.nextLine();

      if (decision == 1) {
        pedirDatos();
      } else {
        System.out.println("Adios...");
        System.exit(0);
      }

      System.out.println("Ingresa el email");
      String mail = scanner.nextLine();
      ejemploExcepcion2(mail);

    } catch (InputMismatchException e) {

      System.out.println("Debes introducir un numero en la edad");

    } catch (Longitud_mail_erronea e) {

      System.out.println("ERROR PERSONALIZADO");
      System.out.println(e.getMessage());
      System.out.println(e.getClass().getName());

    }

    scanner.close();
  }

  /*
   * El metodo tira un error controlado por lo que el compilador no fuerza el
   * uso del try-catch
   */
  private static void pedirDatos() throws InputMismatchException {

    System.out.println("Introduce tu nombre");
    String nombre_usuario = scanner.nextLine();

    System.out.println("Introduce tu edad");
    int edad_usuario = scanner.nextInt();
    scanner.nextLine();

    System.out.println("Hola " + nombre_usuario + ". El año que viene tendrás " + (edad_usuario + 1) + " años");

  }

  private static void ejemploExcepcion2(String mail) throws Longitud_mail_erronea {

    if (mail.length() <= 3) {
      throw new Longitud_mail_erronea("El email debe ser mayor a tres caracteres");
    }

  }

}

class Longitud_mail_erronea extends Exception {

  public Longitud_mail_erronea() {
  }

  public Longitud_mail_erronea(String msj_error) {

    super(msj_error);

  }

}