package ProgramacionGenerica.video166;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

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
        new GregorianCalendar(2015, 1, 12),
    };

    /*
     * No puede ser la clase hija Gregorian Calendar porque esta no
     * implementa directamente la interfaz Comparable<GregorianCalendar>
     * si no que fue su clase padre la que la ha implementado quedando la
     * implementacion como Comparable<Calendar> lo cual tiene conflicto con
     * la parameterizacion del metodo generico creado <T extends Comparable<T>>
     */
    GregorianCalendar fechaMenor = (GregorianCalendar) MisMatrices.getElementoMenor(fechas);

    if (fechaMenor != null) {
      SimpleDateFormat formato = new SimpleDateFormat("dd MMMM yyyy", Locale.getDefault());
      System.out.println("La fecha menor es: " + formato.format(fechaMenor.getTime()));
    }

    Empleado[] empleados = {
        new Empleado("Juan", 30, 5000.0),
        new Empleado("Maria", 25, 4000.0),
        new Empleado("Jose", 40, 6000.0),
        new Empleado("Ale", 20, 3000.0),
    };

    Arrays.sort(empleados);
    for (Empleado empleado : empleados) {
      System.out.println(empleado.dameDatos());
    }

    System.out.println("El Empleado con menor salario es: " + MisMatrices.getElementoMenor(empleados).dameDatos());

  }
}

class MisMatrices {

  public static <T> String getElementos(T[] a) {
    return "El array tiene " + a.length + " elementos";
  }

  public static <T extends Comparable<T>> T getElementoMenor(T[] a) {

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