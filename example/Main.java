import processing.core.PApplet;

public class Main {

  public static void main(String[] args) {
    // Démarre l'applet principal
    String[] processingArgs = {"Example"};
    MainApplet mainApplet = new MainApplet();
    PApplet.runSketch(processingArgs, mainApplet);
  }
}
