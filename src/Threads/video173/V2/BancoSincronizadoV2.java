package Threads.video173.V2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BancoSincronizadoV2 {
  public static void start() {
    Banco b = new Banco();
    for (int i = 0; i < 100; i++) {
      EjecucionTransferencias r = new EjecucionTransferencias(b, i, 2000);
      Thread t = new Thread(r);
      t.start();
    }
  }
}

class Banco {
  private final double[] cuentas;

  public Banco() {
    cuentas = new double[100];

    for (int i = 0; i < cuentas.length; i++) {
      cuentas[i] = 2000;
    }

  }

  public synchronized void transferencia(int cuentaOrigen, int cuentaDestino, double cantidad) throws InterruptedException {

    while (cuentas[cuentaOrigen] < cantidad) {
      wait();
    }

    System.out.println(Thread.currentThread());

    cuentas[cuentaOrigen] -= cantidad;
    cuentas[cuentaDestino] += cantidad;

    System.out.printf("%10.2f de %d para %d\t", cantidad, cuentaOrigen, cuentaDestino);

    System.out.printf("Saldo Total: %10.2f%n", getSaldoTotal());

    notifyAll();

  }

  public double getSaldoTotal() {

    double suma_cuentas = 0;

    for (double a : cuentas) {
      suma_cuentas += a;
    }

    return suma_cuentas;
  }

}

class EjecucionTransferencias implements Runnable {
  private Banco banco;
  private int deLaCuenta;
  private double cantidadMax;

  public EjecucionTransferencias(Banco banco, int deLaCuenta, double cantidadMax) {
    this.banco = banco;
    this.deLaCuenta = deLaCuenta;
    this.cantidadMax = cantidadMax;
  }

  @Override
  public void run() {

    try {
      while (true) {
        int paraLaCuenta = (int) (100 * Math.random());
        double cantidad = cantidadMax * Math.random();

        banco.transferencia(deLaCuenta, paraLaCuenta, cantidad);

        Thread.sleep((int) (Math.random() * 10));
      }
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

}