package Threads.Aguzman.video255;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class EjemploAgendarTareaTimer {
  public static void start() {
    Timer timer = new Timer();

    timer.schedule(new TimerTask() {
      @Override
      public void run() {
        System.out.println(
            "Tarea Realizada en: " + new Date() + " nombre del Thread: " + Thread.currentThread().getName()
        );

        System.out.println("Finaliza el tiempo");

        // Evita que el codigo se ejecute de forma perpetua
        timer.cancel();
      }
    }, 5000);

    System.out.println("agendamos una tarea para 5 minutos mas");

  }
}