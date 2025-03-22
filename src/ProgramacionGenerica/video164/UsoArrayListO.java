package ProgramacionGenerica.video164;

public class UsoArrayListO {
  public static void start() {

    ArrayListO archivos = new ArrayListO(4);

    archivos.add("Juan");
    archivos.add("Maria");
    archivos.add("Ana");
    archivos.add("Fernando");

    String persona = (String) archivos.get(2);
    System.out.println(persona);

  }
}

class ArrayListO {
  private int i = 0;
  private Object[] datos_elemento;

  public ArrayListO(int z) {
    this.datos_elemento = new Object[z];
  }

  public Object get(int z) {
    return datos_elemento[z];
  }

  public void add(Object o) {
    datos_elemento[i] = o;
    i++;
  }

}