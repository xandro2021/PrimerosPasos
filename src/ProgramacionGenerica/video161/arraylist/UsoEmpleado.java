package ProgramacionGenerica.video161.arraylist;

import java.util.ArrayList;
import java.util.Iterator;

public class UsoEmpleado {
  public static void start() {

    int contador = 0;
    ArrayList<Empleado> listaempleados = new ArrayList<>();

    /*
     * Metodo que se asegura de que el array list va a contener al menos esa
     * cantidad de elementos, de lo contrario se consumira mas recursos cada 10
     * elementos
     */
    listaempleados.ensureCapacity(11);

    listaempleados.add(new Empleado("Ana", 45, 2500));
    listaempleados.add(new Empleado("Antonio", 55, 2000));
    listaempleados.add(new Empleado("Maria", 25, 2600));
    listaempleados.add(new Empleado("Jose", 35, 2200));
    listaempleados.add(new Empleado("Sofia", 30, 2600));

    listaempleados.add(new Empleado("Ana", 45, 2500));
    listaempleados.add(new Empleado("Antonio", 55, 2000));
    listaempleados.add(new Empleado("Maria", 25, 2600));
    listaempleados.add(new Empleado("Jose", 35, 2200));
    listaempleados.add(new Empleado("Sofia", 30, 2600));
    listaempleados.add(new Empleado("Pedro", 22, 2750));

    /* Metodo para eliminar el exceso de memoria no usada */
    // listaempleados.trimToSize();
    listaempleados.set(1, new Empleado("Olga", 22, 2100));

    System.out.println("cantidad elementos: " + listaempleados.size());
    System.out.println("Elemento #4: " + listaempleados.get(4).dameDatos());
    System.out.println("\n#\tnombre\tedad\tsalario");

    // for (Empleado empleado : listaempleados) {
    // System.out.println(++contador + "\t" + empleado.dameDatos());
    // }

    Iterator<Empleado> iterador_empleado = listaempleados.iterator();

    while (iterador_empleado.hasNext()) {

      System.out.println(iterador_empleado.next().dameDatos());

    }
  }
}