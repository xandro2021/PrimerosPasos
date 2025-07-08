package Threads.Aguzman.video252;

import java.util.concurrent.ThreadLocalRandom;

public class ProductorConsumidor {
  public static void start() {
    Panaderia p = new Panaderia();
    new Thread(new Panadero(p)).start();
    new Thread(new Consumidor(p)).start();
  }
}

class Panaderia {
  private String pan;
  private boolean disponible;

  public synchronized void hornear(String masa) throws InterruptedException {

    while (disponible) {
      wait();
    }

    this.pan = masa;
    System.out.println("Panadero hornea: " + this.pan);
    this.disponible = true;

    notify();
  }

  public synchronized String consumir() throws InterruptedException {

    while (!disponible) {
      wait();
    }

    System.out.println("Cliente consume: " + this.pan);
    this.disponible = false;
    notify();

    return pan;
  }

}

class Panadero implements Runnable {
  private Panaderia panaderia;

  public Panadero(Panaderia panaderia) {
    this.panaderia = panaderia;
  }

  @Override
  public void run() {
    try {

      for (int i = 0; i < 10; i++) {
        panaderia.hornear("Pan nª: " + i);
        Thread.sleep(ThreadLocalRandom.current().nextInt(500, 2000));
      }

    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}

class Consumidor implements Runnable {
  private Panaderia panaderia;

  public Consumidor(Panaderia panaderia) {
    this.panaderia = panaderia;
  }

  @Override
  public void run() {
    try {

      for (int i = 0; i < 10; i++) {
        panaderia.consumir();
      }

    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}