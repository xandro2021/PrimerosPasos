package Threads.video168;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class UsoThreads {
  public static void start() {

    JFrame marco = new MarcoRebote();
    marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    marco.setVisible(true);

  }
}

class PelotaHilos implements Runnable {
  private Pelota pelota;
  private Component componente;

  public PelotaHilos(Pelota unaPelota, Component unComponente) {
    pelota = unaPelota;
    componente = unComponente;
  }

  @Override
  public void run() {
    System.out.println(Thread.currentThread().isInterrupted());
    // while(!Thread.interrupted()){
    while (!Thread.currentThread().isInterrupted()) {
      pelota.muevePelota(componente.getBounds());
      componente.paint(componente.getGraphics());

      try {
        Thread.sleep(4);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
    }
    System.out.println(Thread.currentThread().isInterrupted());
  }

}

/* Movimiento de la Pelota */
class Pelota {

  private double x, y, dx, dy;
  private static final int TAMX;
  private static final int TAMY;

  static {
    TAMX = 15;
    TAMY = 15;
  }

  public Pelota() {
    this.x = 0;
    this.y = 0;
    this.dx = 1;
    this.dy = 1;
  }

  /* Forma de la pelota en su posicion inicial */
  public Ellipse2D getShape() {
    return new Ellipse2D.Double(x, y, TAMX, TAMY);
  }

  /* Invierte la posicion del movimiento si choca con limites */
  public void muevePelota(Rectangle2D limites) {

    x += dx;
    y += dy;

    if (x < limites.getMinX()) {
      x = limites.getMinX();
      dx = -dx;
    }

    if (x + TAMX >= limites.getMaxX()) {
      x = limites.getMaxX() - TAMX;
      dx = -dx;
    }

    if (y < limites.getMinY()) {
      y = limites.getMinY();
      dy = -dy;
    }

    if (y + TAMY >= limites.getMaxY()) {
      y = limites.getMaxY() - TAMY;
      dy = -dy;
    }

  }

}

class MarcoRebote extends JFrame {
  private LaminaPelota lamina;
  private Thread t1, t2, t3;
  private JButton btn1, btn2, btn3, dtn1, dtn2, dtn3;

  public MarcoRebote() {
    setTitle("Video 168 Threads Rebotes");
    setBounds(600, 400, 550, 450);
    BD_South();
    BD_Center();
  }

  private void BD_Center() {
    lamina = new LaminaPelota();
    add(lamina, BorderLayout.CENTER);
  }

  private void BD_South() {
    JPanel lamina_botones = new JPanel();
    // Boton 1
    btn1 = new JButton("Hilo 1");
    btn1.addActionListener(e -> comienzaJuego(e));
    lamina_botones.add(btn1);

    // Boton 2
    btn2 = new JButton("Hilo 2");
    btn2.addActionListener(e -> comienzaJuego(e));
    lamina_botones.add(btn2);

    // Boton 3
    btn3 = new JButton("Hilo 3");
    btn3.addActionListener(e -> comienzaJuego(e));
    lamina_botones.add(btn3);

    // Boton dtn 1
    dtn1 = new JButton("Detener 1");
    dtn1.addActionListener(e -> detener(e));
    lamina_botones.add(dtn1);

    // Boton dtn 2
    dtn2 = new JButton("Detener 2");
    dtn2.addActionListener(e -> detener(e));
    lamina_botones.add(dtn2);

    // Boton dtn 3
    dtn3 = new JButton("Detener 3");
    dtn3.addActionListener(e -> detener(e));
    lamina_botones.add(dtn3);

    add(lamina_botones, BorderLayout.SOUTH);
  }

  public void comienzaJuego(ActionEvent e) {
    Pelota pelota = new Pelota();
    lamina.add(pelota);

    Runnable r = new PelotaHilos(pelota, lamina);

    if (e.getSource().equals(btn1)) {
      t1 = new Thread(r);
      t1.start();
    }
    else if (e.getSource().equals(btn2)) {
      t2 = new Thread(r);
      t2.start();
    }
    else if (e.getSource().equals(btn3)) {
      t3 = new Thread(r);
      t3.start();
    }

  }

  private void detener(ActionEvent e) {
    System.out.println("DETENTE!");
    if (e.getSource().equals(dtn1)) {
      t1.interrupt();
    }
    else if (e.getSource().equals(dtn2)) {
      t2.interrupt();
    }
    else if (e.getSource().equals(dtn3)) {
      t3.interrupt();
    }
  }

}

class LaminaPelota extends JPanel {
  private ArrayList<Pelota> pelotas;

  public LaminaPelota() {
    pelotas = new ArrayList<>();
  }

  public void add(Pelota b) {
    pelotas.add(b);
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;

    for (Pelota b : pelotas) {
      g2.fill(b.getShape());
    }

  }

}