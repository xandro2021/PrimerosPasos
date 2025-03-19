package graficos.video149;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class ExcepcionesFinal {
  public static void start() {

    int lado, base, altura, radio, figura = 0;
    // Scanner entrada = new Scanner(System.in);

    System.out.println("Elige una opción: ");
    System.out.println("1. Cuadrado");
    System.out.println("2. Rectangulo");
    System.out.println("3. Triangulo");
    System.out.println("4. Circulo");

    try {

      figura = Integer.parseInt(JOptionPane.showInputDialog("ingresa numero menu"));

    } catch (Exception e) {
      System.out.println("Error " + e.getMessage());
      e.printStackTrace();
    } finally {
      // entrada.close();
    }

    switch (figura) {

      case 1:
        System.out.println("Haz elegido Cuadrado");
        lado = Integer.parseInt(JOptionPane.showInputDialog("Introduce el lado"));
        System.out.println("El area del cuadrado es: " + Math.pow(lado, 2));
        break;

      case 2:
        System.out.println("Haz elegido Rectangulo");
        base = Integer.parseInt(JOptionPane.showInputDialog("Introduce la base"));
        altura = Integer.parseInt(JOptionPane.showInputDialog("Introduce la altura"));
        System.out.println("El area del rectangulo es " + (base * altura));
        break;

      case 3:
        System.out.println("Haz elegido Triangulo");
        base = Integer.parseInt(JOptionPane.showInputDialog("Introduce la base"));
        altura = Integer.parseInt(JOptionPane.showInputDialog("Introduce la altura"));
        System.out.println("El area del rectangulo es " + (base * altura) / 2);
        break;

      case 4:
        System.out.println("Haz elegido Circulo");
        radio = Integer.parseInt(JOptionPane.showInputDialog("Introduce el radio"));
        System.out.println("El area del circulo es: ");
        System.out.println(Math.PI * (Math.pow(radio, 2)));
        break;

      default:
        System.out.println("La opcion no es correcta");

    }

    altura = Integer.parseInt(JOptionPane.showInputDialog("Que tan alto eres?"));
    System.out.println("Si eres hombre tu peso ideal es: " + (altura - 110) + " kg");
    System.out.println("Si eres mujer tu peso ideal es: " + (altura - 120) + " kg");

  }

}
