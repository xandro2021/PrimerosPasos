package Threads.Aguzman.video252;

import java.util.concurrent.ThreadLocalRandom;

public class ProductorConsumidorJava8 {
  public static void start() {
    Panaderia p = new Panaderia();

    new Thread(() -> {
      try {

        for (int i = 0; i < 10; i++) {
          p.hornear("Pan nª: " + i);
          Thread.sleep(ThreadLocalRandom.current().nextInt(500, 2000));
        }

      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }).start();

    new Thread(() -> {
      try {

        for (int i = 0; i < 10; i++) {
          p.consumir();
        }

      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }).start();
  }
}