package Threads.video168;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
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

    ponerBoton(lamina_botones, "Start!", e -> comienzaJuego());
    ponerBoton(lamina_botones, "Exit", e -> System.exit(0));

    add(lamina_botones, BorderLayout.SOUTH);
  }

  /* Version Compleja para aprender sobre el paso de funciones como argumento */
  private void BD_South_unUsed() {
    JPanel lamina_botones = new JPanel();

    @FunctionalInterface
    interface FuncionGenerica {
      void miFuncion();
    }

    class EventoBoton implements ActionListener {
      FuncionGenerica funcion_generica;

      public EventoBoton(FuncionGenerica miFuncion) {
        this.funcion_generica = miFuncion;
      }

      @Override
      public void actionPerformed(ActionEvent e) {
        funcion_generica.miFuncion();
      }
    }

    ponerBoton(lamina_botones, "Start!", new EventoBoton(() -> comienzaJuego()));
    ponerBoton(lamina_botones, "Exit", new EventoBoton(() -> System.exit(0)));

    add(lamina_botones, BorderLayout.SOUTH);
  }

  private void ponerBoton(Container lamina_botones, String titulo, ActionListener oyente) {
    JButton boton = new JButton(titulo);
    boton.addActionListener(oyente);
    lamina_botones.add(boton);
  }

  public void comienzaJuego() {
    Pelota pelota = new Pelota();
    lamina.add(pelota);
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