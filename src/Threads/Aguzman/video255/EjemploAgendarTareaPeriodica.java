package Threads.Aguzman.video255;

import java.awt.Toolkit;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public class EjemploAgendarTareaPeriodica {
  public static void start() {
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Timer timer = new Timer();
    AtomicInteger contadorAtomic = new AtomicInteger(3);

    timer.schedule(new TimerTask() {

      @Override
      public void run() {
        int contador = contadorAtomic.getAndDecrement();

        if (contador > 0) {
          toolkit.beep();
          System.out.println(
              "Tarea Periodica #" + contador + " en: " + new Date() + " nombre del Thread: "
                  + Thread.currentThread().getName());
        } else {
          System.out.println("Finaliza el tiempo");
          timer.cancel();
        }
      }
    }, 0, 10000);

    System.out.println("agendamos una tarea inmediata que se repite 3 veces cada 10 segundos");

  }
}