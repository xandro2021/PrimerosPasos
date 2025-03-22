package ProgramacionGenerica.video165.clases_propias;

public class Pareja<T> {

  public Pareja() {
    primero = null;
  }

  public void setPrimero(T nuevo_valor) {
    primero = nuevo_valor;
  }

  public T getPrimero() {
    return primero;
  }

  private T primero;
}