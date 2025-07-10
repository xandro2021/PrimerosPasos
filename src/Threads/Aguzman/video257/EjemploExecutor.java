package Threads.Aguzman.video257;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class EjemploExecutor {
  public static void start() {

    ExecutorService executor = Executors.newSingleThreadExecutor();

    Runnable tarea = () -> {
      System.out.println("Inicio de la tarea");

      try {

        System.out.println("Nombre del Thread: " + Thread.currentThread().getName());
        TimeUnit.SECONDS.sleep(5);

      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        e.printStackTrace();
      }

      System.out.println("Final de tarea");
    };

    // Ejecuta tarea
    executor.submit(tarea);
    // Detiene el proceso una vez se hayan completado las tareas
    executor.shutdown();

    System.out.println("Continuando ejecucion del MAIN 1");

    try {

      // Espera dos segundos antes de continuar con la ejecucion del Main
      executor.awaitTermination(2, TimeUnit.SECONDS);

    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    System.out.println("Continuando ejecucion del MAIN 2");

  }
}