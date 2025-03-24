package ProgramacionGenerica.video167;

public class Empleado {

  private String nombre;
  private int edad;
  private double salario;

  public Empleado(String nombre, int edad, double salario) {
    this.nombre = nombre;
    this.edad = edad;
    this.salario = salario;
  }

  public String dameDatos() {
    return "nombre: " + nombre + "\tedad: " + edad + "\tsalario: " + salario;
  }

}

class Jefe extends Empleado {

  public Jefe(String nombre, int edad, double salario) {
    super(nombre, edad, salario);
  }

  public double incentivo(double inc) {
    return inc;
  }

}