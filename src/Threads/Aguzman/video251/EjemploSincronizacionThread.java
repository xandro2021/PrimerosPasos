package Threads.Aguzman.video251;

public class EjemploSincronizacionThread {
  public static void start() throws InterruptedException {

    new Thread(new ImprimirFrases("Hola ", "que tal!")).start();
    new Thread(new ImprimirFrases("Quien eres ", "tu?")).start();

    Thread.sleep(100);

    Thread h3 = new Thread(new ImprimirFrases("Muchas ", "gracias amigo!"));
    h3.start();

    Thread.sleep(100);

    System.out.println(h3.getState());
  }

  public synchronized static void imprimirFrase(String frase1, String frase2) {
    try {
      System.out.println(frase1);
      Thread.sleep(500);
      System.out.println(frase2);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}

class ImprimirFrases implements Runnable {
  private String frase1, frase2;

  public ImprimirFrases(String frase1, String frase2) {
    this.frase1 = frase1;
    this.frase2 = frase2;
  }

  @Override
  public void run() {
    EjemploSincronizacionThread.imprimirFrase(frase1, frase2);
  }
}