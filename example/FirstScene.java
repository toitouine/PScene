import pscene.Scene;
import pscene.SApplet;
import pscene.controllers.TextButton;
import processing.core.PSurface;

public class FirstScene extends Scene {
  public FirstScene(SApplet sketch) {
    this.sketch = sketch;
    width = 600;
    height = 400;

    controllers.add(
      new TextButton(sketch, width/2, height-125, "Second scene", 40)
        .setAction( () -> sketch.setScene("second") )
    );
  }

  public void awake() {
    PSurface surface = sketch.getSurface();
    surface.setLocation((sketch.displayWidth-width)/2, (sketch.displayHeight-height)/2);
    sketch.setTitle("First scene");
  }

  protected void draw() {
    sketch.background(45);
    sketch.textSize(80);
    sketch.textAlign(sketch.CENTER, sketch.CENTER);
    sketch.text("First scene", width/2, 125);
  }
}
