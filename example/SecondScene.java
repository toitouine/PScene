import pscene.Scene;
import pscene.Overlay;
import pscene.SApplet;
import pscene.controllers.TextButton;
import pscene.controllers.Slider;
import processing.core.PSurface;

import java.util.Collections;

public class SecondScene extends Scene {
  private Slider backgroundSlider;
  private Overlay secondOverlay;

  public SecondScene(SApplet sketch) {
    this.sketch = sketch;
    width = 600;
    height = 400;

    secondOverlay = new SecondOverlay(this, width/2 + 100, height/2, width-100, height);

    backgroundSlider = new Slider(sketch, 40, height-100, 40, 150)
                         .setMinimax(0, 255)
                         .setValue(45)
                         .setGraduations(8);

    Collections.addAll(controllers,
      backgroundSlider,

      new TextButton(sketch, width/2, height-100, "First scene", 30)
        .setAction( () -> sketch.setScene("first") ),

      new TextButton(sketch, width-80, height-30, "Display overlay", 20)
        .setAction( () -> setOverlay(secondOverlay) )
    );
  }

  public void awake() {
    PSurface surface = sketch.getSurface();
    surface.setLocation((sketch.displayWidth-width)/2, (sketch.displayHeight-height)/2);
    sketch.setTitle("Second scene");
  }

  protected void draw() {
    sketch.background(backgroundSlider.getValue());
    sketch.textSize(80);
    sketch.textAlign(sketch.CENTER, sketch.CENTER);
    sketch.text("Second scene", width/2, 125);
  }
}
