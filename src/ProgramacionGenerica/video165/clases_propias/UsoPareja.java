package ProgramacionGenerica.video165.clases_propias;

public class UsoPareja {
  public static void start() {

    Pareja<String> una = new Pareja<>();
    una.setPrimero("Juan");
    System.out.println(una.getPrimero());

    Persona persona1 = new Persona("Ana");
    Pareja<Persona> otra = new Pareja<>();

    otra.setPrimero(persona1);
    System.out.println(otra.getPrimero());

  }
}

class Persona {

  public Persona(String nombre) {
    this.nombre = nombre;
  }

  @Override
  public String toString() {
    return "Persona:\t" + nombre;
  }

  private String nombre;
}