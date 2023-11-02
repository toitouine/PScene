package pscene;

import java.util.ArrayList;
import pscene.controllers.Controller;

public abstract class Scene {
  public SApplet sketch;
  protected ArrayList<Controller> controllers = new ArrayList<Controller>();
  protected int width; // Largeur de la fenêtre
  protected int height; // Hauteur de la fenêtre
  private Overlay currentOverlay = null;

  abstract protected void awake(); // Appelée une fois au lancement de la scène
  abstract protected void draw();  // Appelée continuellement si la scène est active

  public void display() {
    draw();
    showControllers();
    showOverlay();
  }

  public void prepare() {
    sketch.getSurface().setSize(width, height);
    awake();
  }

  public void setOverlay(Overlay o) {
    currentOverlay = o;
  }

  private void showControllers() {
    for (Controller c : controllers) {
      if (c.isEnabled()) c.show();
    }
  }

  private void showOverlay() {
    if (currentOverlay !=  null) currentOverlay.display();
  }

  protected int rgb(float r, float g, float b) {
    return sketch.color(r, g, b);
  }

  public void onUserEvent(UserEvent e) {
    if (currentOverlay != null && currentOverlay.contains(e.x, e.y)) {
      currentOverlay.onUserEvent(e);
      return;
    }

    for (Controller c : controllers) {
      if (c.isEnabled()) {
        c.onUserEvent(e);
        if (c.contains(e.x, e.y)) return;
      }
    }

    if (e.mouseMoved()) sketch.cursor(sketch.ARROW);
  }
}
