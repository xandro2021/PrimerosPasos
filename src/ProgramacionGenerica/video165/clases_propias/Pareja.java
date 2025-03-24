package ProgramacionGenerica.video165.clases_propias;

import ProgramacionGenerica.video167.Empleado;

public class Pareja<T> {

  public Pareja() {
    primero = null;
  }

  public void setPrimero(T nuevo_valor) {
    primero = nuevo_valor;
  }

  /* Sintaxis para especificar que acepta Empleado y sus subclases */
  public static void imprimirTrabajador(Pareja<? extends Empleado> p) {
    Empleado primero = p.getPrimero();
    System.out.println(primero);
  }

  public T getPrimero() {
    return primero;
  }

  private T primero;
}