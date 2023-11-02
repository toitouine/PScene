import pscene.Overlay;
import pscene.Scene;
import pscene.controllers.TextButton;
import java.util.Collections;

public class SecondOverlay extends Overlay {

  SecondOverlay(Scene scene, float x, float y, int width, int height) {
    this.scene = scene;
    this.sketch = scene.sketch;
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;

    controllers.add(
      new TextButton(sketch, x, y+65, "Disable overlay", 30)
        .setAction( () -> scene.setOverlay(null) )
    );
  }

  protected void draw() {
    sketch.fill(220, 220, 220, 220);
    sketch.rectMode(sketch.CENTER);
    sketch.rect(x, y, width, height);

    sketch.fill(0);
    sketch.textSize(80);
    sketch.textAlign(sketch.CENTER, sketch.CENTER);
    sketch.text("Overlay", x, y - 35);
  }
}
