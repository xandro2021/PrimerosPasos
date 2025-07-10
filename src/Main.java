import Threads.Aguzman.video257.*;
// import graficos.video119.DisposicionLibreII;

public class Main {
  public static void main(String[] args) {

    try {
      EjemploProductorConsumidor.start();
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    // BancoSinSincronizar.start();
    // VentanasEmergentesI.start();
    // DisposicionLibreII.start();
  }
}
