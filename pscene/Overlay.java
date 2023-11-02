// Scène particulière qui s'affiche par dessus une autre scène
// Empêche les controllers inaccessibles d'être activé par des events

package pscene;

public abstract class Overlay extends Scene {
  protected Scene scene;
  protected float x, y;

  public boolean contains(int xmouse, int ymouse) {
    return (xmouse >= x-width/2 && xmouse < x+width/2 && ymouse >= y-height/2 && ymouse < y+height/2);
  }

  final public void prepare() {
    System.out.println("Impossible d'appeler prepare() sur un overlay");
  }

  final public void awake() {
    System.out.println("Impossible d'appeler awake() sur un overlay");
  }
}
