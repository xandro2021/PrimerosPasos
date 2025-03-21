package Serializacion.video157;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

public class SerializacionI {
  public static void start() {

    Administrador jefe = new Administrador("Juan", 80000, 2005, 12, 15);

    jefe.setIncentivo(5000);

    Empleado[] personal = new Empleado[3];

    personal[0] = jefe;
    personal[1] = new Empleado("Ana", 25000, 2008, 10, 1);
    personal[2] = new Empleado("Luis", 25000, 2012, 9, 15);

    try {

      /*
       * Guardar objeto serializado en un archivo .dat
       */
      ObjectOutputStream escribiendo_fichero = new ObjectOutputStream(
          new FileOutputStream("src/recursos/archivosBytes/empleado.dat", true));

      escribiendo_fichero.writeObject(personal);

      escribiendo_fichero.close();

      /*
       * Leer el archivo serializado e imprimir su valor restaurado
       */
      ObjectInputStream recuperando_fichero = new ObjectInputStream(
          new FileInputStream("src/recursos/archivosBytes/empleado.dat"));

      Empleado[] empleados_recuperados = (Empleado[]) recuperando_fichero.readObject();

      recuperando_fichero.close();

      for (Empleado empleado : empleados_recuperados) {
        System.out.println(empleado);
      }

    } catch (IOException e) {
      System.out.println("Error " + e.getMessage());
      e.printStackTrace();
    } catch (Exception e) {
      System.out.println("Error " + e.getMessage());
      e.printStackTrace();
    }

  }
}

class Empleado implements Serializable {

  private String nombre;
  private double sueldo;
  private Date fechaContrato;

  private static final long serialVersionUID = 1L;

  public Empleado(String n, double s, int agno, int mes, int dia) {

    nombre = n;
    sueldo = s;
    GregorianCalendar calendario = new GregorianCalendar(agno, mes - 1, dia);
    fechaContrato = calendario.getTime();

  }

  public String getNombre() {
    return nombre;
  }

  public double getSueldo() {
    return sueldo;
  }

  public Date getFechaContrato() {
    return fechaContrato;
  }

  public void subirSueldo(double porcentaje) {
    double aumento = sueldo * porcentaje / 100;
    sueldo += aumento;
  }

  @Override
  public String toString() {
    return "Nombre: " + nombre + ", sueldo: " + sueldo + ", fecha de contrato: " + fechaContrato;
  }

}

class Administrador extends Empleado {

  private static final long serialVersionUID = 1L;

  public Administrador(String n, double s, int agno, int mes, int dia) {
    super(n, s, agno, mes, dia);
    incentivo = 0;
  }

  @Override
  public double getSueldo() {
    double sueldo_base = super.getSueldo();
    return sueldo_base + incentivo;
  }

  public void setIncentivo(int incentivo) {
    this.incentivo = incentivo;
  }

  @Override
  public String toString() {
    return super.toString() + " Incentivo: " + incentivo;
  }

  private int incentivo;
}