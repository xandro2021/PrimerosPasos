package Threads.Aguzman.video257;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class EjemploExecutorFuture {
  public static void start() throws InterruptedException {

    ExecutorService executor = Executors.newSingleThreadExecutor();

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

    // Ejecuta tarea
    Future<String> resultado = executor.submit(tarea);
    // Detiene el proceso una vez se hayan completado las tareas
    executor.shutdown();

    System.out.println("Continuando ejecucion del MAIN 1");

    // System.out.println(resultado.isDone());
    /*
     * Se puede bloquear manualmente la ejecucion del programa hasta que
     * termine las tareas
     */
    while (!resultado.isDone()) {
      System.out.println("Ejecutando tarea");
      TimeUnit.MILLISECONDS.sleep(1500);
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

    } catch (InterruptedException | ExecutionException | TimeoutException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    System.out.println("Finaliza la tarea: " + resultado.isDone());
  }
}