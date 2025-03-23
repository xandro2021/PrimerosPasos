package ProgramacionGenerica.video166;

import java.util.GregorianCalendar;

import ProgramacionGenerica.video161.arraylist.Empleado;

public class MetodosGenericos {
  public static void start() {

    String[] personas = { "Jose", "Maria", "Juan", "Ale" };
    String elementos = MisMatrices.getElementos(personas);
    System.out.println(elementos);

    System.out.println("El elemento menor es: " + MisMatrices.getElementoMenor(personas));

    GregorianCalendar fechas[] = {
        new GregorianCalendar(2015, 07, 12),
        new GregorianCalendar(2015, 05, 12),
        new GregorianCalendar(2015, 04, 12),
        new GregorianCalendar(2015, 17, 12),
    };

    System.out.println("La fecha menor es: " + MisMatrices.getElementoMenor(fechas));

  }
}

class MisMatrices {

  public static <T> String getElementos(T[] a) {
    return "El array tiene " + a.length + " elementos";
  }

  public static <T extends Comparable> T getElementoMenor(T[] a) {

    if (a == null || a.length == 0) {
      return null;
    }

    T elemento_menor = a[0];

    for (int i = 1; i < a.length; i++) {
      if (elemento_menor.compareTo(a[i]) > 0) {

        elemento_menor = a[i];

      }
    }

    return elemento_menor;

  }

}