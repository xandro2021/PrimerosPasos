package Threads.video168;

public class SincronizandoHilos {
  public static void start() {
    HilosVarios hilo1 = new HilosVarios();
    HilosVarios2 hilo2 = new HilosVarios2(hilo1);
    // Orden no importa dado que hilo2 no inicia hasta que termine hilo1
    hilo2.start();
    hilo1.start();

    System.out.println("HOLA DESDE MAIN");
  }
}

class HilosVarios extends Thread {

  @Override
  public void run() {
    for (int i = 0; i < 15; i++) {
      System.out.println("Ejecutando Hilo" + getName());

      try {
        Thread.sleep(300);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }

}

class HilosVarios2 extends Thread {
  private Thread hilo;

  public HilosVarios2(Thread hilo) {
    this.hilo = hilo;
  }

  @Override
  public void run() {

    try {
      hilo.join();
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    for (int i = 0; i < 15; i++) {
      System.out.println("Ejecutando Hilo" + getName());

      try {
        Thread.sleep(300);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }

}