package pscene;

import processing.core.PApplet;
import processing.core.PImage;
import java.util.HashMap;
import java.awt.Frame;
import processing.awt.PSurfaceAWT;
import processing.awt.PSurfaceAWT.SmoothCanvas;

public abstract class SApplet extends PApplet {

  private HashMap<String, Scene> scenes = new HashMap<String, Scene>();
  private Scene currentScene;

  abstract public void setup();

  public void draw() {
    if (currentScene != null) currentScene.display();
  }

  final protected void register(Scene scene, String index) {
    scenes.put(index, scene);
  }

  final public void setScene(String index) {
    try {
      currentScene = scenes.get(index);
      currentScene.prepare();
    }
    catch (Exception e) {
      System.out.println("Scène demandée introuvable.");
    }
  }

  final public void setTitle(String title) {
    surface.setTitle(title);
  }

  final public Frame getFrame() {
    return ( (PSurfaceAWT.SmoothCanvas) ((PSurfaceAWT)surface).getNative()).getFrame();
  }

  public void keyPressed() {
    if (keyCode == ESC) key = 0;

    UserEvent event = new UserEvent(EventType.KeyPressed, keyCode);
    if (currentScene != null) currentScene.onUserEvent(event);
  }

  public void mouseMoved() {
    UserEvent event = new UserEvent(EventType.MouseMoved, mouseX, mouseY);
    if (currentScene != null) currentScene.onUserEvent(event);
  }

  public void mousePressed() {
    UserEvent event = new UserEvent(EventType.MousePressed, mouseX, mouseY);
    if (currentScene != null) currentScene.onUserEvent(event);
  }

  public void mouseReleased() {
    UserEvent event = new UserEvent(EventType.MouseReleased, mouseX, mouseY);
    if (currentScene != null) currentScene.onUserEvent(event);
  }

  public void mouseDragged() {
    UserEvent event = new UserEvent(EventType.MouseDragged, mouseX, mouseY);
    if (currentScene != null) currentScene.onUserEvent(event);
  }
}
