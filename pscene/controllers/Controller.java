/////////////////////////////////////////////////////////////////

// Un controller est un élément de l'interface qui affiche du contenu et
// reçoit les évènements de l'utilisateur (avec onUserEvent)

/////////////////////////////////////////////////////////////////

package pscene.controllers;

import pscene.SApplet;
import pscene.UserEvent;
import java.util.function.BooleanSupplier;

public abstract class Controller<T> {
  protected SApplet sketch;
  protected float x, y, w, h;
  protected BooleanSupplier condition;
  protected T me;

  abstract public void onUserEvent(UserEvent e);
  abstract public void show();

  public boolean contains(int xmouse, int ymouse) {
    return (xmouse >= x-w/2 && xmouse < x+w/2 && ymouse >= y-h/2 && ymouse < y+h/2);
  }

  final public T setCondition(BooleanSupplier c) {
    condition = c;
    return me;
  }

  final public boolean isEnabled() {
    if (condition == null) return true;
    return condition.getAsBoolean();
  }

  protected int rgb(float r, float g, float b) {
    return sketch.color(r, g, b);
  }
}
