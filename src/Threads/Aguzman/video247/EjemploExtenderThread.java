package Threads.Aguzman.video247;

public class EjemploExtenderThread {
    public static void start() {
        // new Thread(new ViajeTarea("Isla de Pascua")).start();
        // new Thread(new ViajeTarea("Robinson Crusoe")).start();
        // new Thread(new ViajeTarea("Juan Fernandez")).start();
        // new Thread(new ViajeTarea("Isla Chilow")).start();

        Thread main = Thread.currentThread();
        Runnable viaje = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(i + " - " + Thread.currentThread().getName());
                try {
                    Thread.sleep((long) (Math.random() * 1000));
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            System.out.println("Finalmente me voy de viaje a: " + Thread.currentThread().getName());
            System.out.println(main.getState());
        };

        Thread t1 = new Thread(viaje, "Isla de Pascua");
        Thread t2 = new Thread(viaje, "Robinson Crusoe");
        Thread t3 = new Thread(viaje, "Juan Fernandez");
        Thread t4 = new Thread(viaje, "Isla de Chiloe");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("Continuando ejecucion del MAIN: " + main.getName());
    }
}

class NombreThread extends Thread {

    public NombreThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {

            System.out.println("Se inicia el metodo run del hilo " + getName());

            for (int i = 0; i < 10; i++) {
                Thread.sleep(10);
                System.out.println(this.getName());
            }

            System.out.println("Se finaliza el hilo");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ViajeTarea implements Runnable {
    private String nombre;

    public ViajeTarea(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " - " + nombre);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        System.out.println("Finalmente me voy de viaje a: " + nombre);
    }
}