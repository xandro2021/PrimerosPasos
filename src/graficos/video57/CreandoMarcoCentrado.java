package graficos.video57;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.Image;

public class CreandoMarcoCentrado {
  public static void main(String[] args) {

    MarcoCentrado mimarco = new MarcoCentrado();
    mimarco.setVisible(true);
    mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  }
}

class MarcoCentrado extends JFrame {

  public MarcoCentrado() {

    Dimension pantalla = this.getTamanioPantalla();
    setSize(pantalla.width/2, pantalla.height/2);
    setLocation(pantalla.width/4, pantalla.height/4);

    setTitle("Marco Centrado");
    setImageIcon();
  }

  private void setImageIcon() {
    Toolkit recursosSistema = Toolkit.getDefaultToolkit();
    Image miIcono = recursosSistema.getImage("src/graficos/video57/icono.png");
    setIconImage(miIcono);
  }

  private Dimension getTamanioPantalla() {
    Toolkit mipantalla = Toolkit.getDefaultToolkit();
    return mipantalla.getScreenSize();
  }
}