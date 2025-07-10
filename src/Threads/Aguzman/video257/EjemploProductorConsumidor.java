package Threads.Aguzman.video257;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/*
 * Video 260 Guzman
 */
public class EjemploProductorConsumidor {
  public static void start() throws InterruptedException {

    // El pool debe ser minimo de 2 para que las dos tareas puedan ejecutarse al
    // mismo tiempo y asi evitar el bloqueo
    ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

    System.out.println("Tamanio del pool: " + executor.getPoolSize());
    System.out.println("Cantidad de tareas en cola: " + executor.getQueue().size());

    Panaderia p = new Panaderia();
    Runnable productor  = new Panadero(p);
    Runnable consumidor  = new Consumidor(p);

    // se usa el comodin porque los runnable no devuelven nada
    Future<?> futuro1 = executor.submit(productor);
    Future<?> futuro2 = executor.submit(consumidor);

    System.out.println("Tamanio del pool: " + executor.getPoolSize());
    System.out.println("Cantidad de tareas en cola: " + executor.getQueue().size());
    // Detiene el proceso una vez se hayan completado las tareas
    executor.shutdown();
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