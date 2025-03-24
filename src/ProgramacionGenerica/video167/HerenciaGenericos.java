package ProgramacionGenerica.video167;

import ProgramacionGenerica.video165.clases_propias.Pareja;

public class HerenciaGenericos {
  public static void start() {

    /*
     * Herencia convencional en Java
     */
    Empleado administrativa = new Empleado("Elena", 45, 1500);
    Jefe directora_comercial = new Jefe("Ana", 27, 3500);
    Empleado nuevo_empleado = directora_comercial;

    /*
     * Herencia en clases genericas
     */
    Pareja<Empleado> Administrativa = new Pareja<>();
    Pareja<Jefe> DirectoraComercial = new Pareja<>();
    /* Error, la herencia en genericos no funciona asi */
    // Pareja<Empleado> nuevoEmpleado = DirectoraComercial;
    Pareja.imprimirTrabajador(Administrativa);
    Pareja.imprimirTrabajador(DirectoraComercial);
  }
}