package Threads.Aguzman.video257;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class EjemploExecutorFuture2 {
  public static void start() throws InterruptedException {

    // Una tarea a la vez
    // ExecutorService executor = Executors.newSingleThreadExecutor();
    // Mutiples tareas en paralelo
    ExecutorService executor = Executors.newFixedThreadPool(3);

    Callable<String> tarea = () -> {
      System.out.println("Inicio de la tarea");

      try {

        System.out.println("Nombre del Thread: " + Thread.currentThread().getName());
        TimeUnit.SECONDS.sleep(3);

      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        e.printStackTrace();
      }

      System.out.println("Final de tarea");
      return "Algun resultado importante de la tarea";
    };

    Callable<Integer> tarea2 = () -> {
      System.out.println("Iniciando tarea 2");
      TimeUnit.SECONDS.sleep(3);
      return 10;
    };

    // Ejecuta tarea
    Future<String> resultado = executor.submit(tarea);
    Future<String> resultado2 = executor.submit(tarea);
    Future<Integer> resultado3 = executor.submit(tarea2);
    // Detiene el proceso una vez se hayan completado las tareas
    executor.shutdown();

    System.out.println("Continuando ejecucion del MAIN 1");

    // System.out.println(resultado.isDone());
    /*
     * Se puede bloquear manualmente la ejecucion del programa hasta que
     * termine las tareas
     */
    while (!(resultado.isDone() && resultado2.isDone() && resultado3.isDone())) {
      System.out.println(String.format("resultado1: %s - resultado2: %s - resultado3: %s",
          resultado.isDone() ? "Finalizado" : "En Proceso",
          resultado2.isDone() ? "Finalizado" : "En Proceso",
          resultado3.isDone() ? "Finalizado" : "En Proceso"));
      TimeUnit.MILLISECONDS.sleep(1000);
    }
    System.out.println("Continuamos....");

    try {

      // Solo devuelve algo si es callable en vez de runnable
      // get blockea el metodo main
      // get espera a que finalice y devuelva el resultado
      // System.out.println("Resultado de la tarea: " + resultado.get());

      // Si uso parametros, le doy tiempo dos segundo para obtener el resultado
      // de lo contrario tira time-out exception, evitando bloqueos innecesarios
      System.out.println("Resultado de la tarea: " + resultado.get(5, TimeUnit.SECONDS));
      System.out.println("Resultado de la tarea: " + resultado2.get());
      System.out.println("Resultado de la tarea: " + resultado3.get());

    } catch (InterruptedException | ExecutionException | TimeoutException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    System.out.println("Finaliza la tarea: " + resultado.isDone());
    System.out.println("Finaliza la tarea: " + resultado2.isDone());
    System.out.println("Finaliza la tarea: " + resultado3.isDone());
  }
}