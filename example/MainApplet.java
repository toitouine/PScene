import pscene.SApplet;

final public class MainApplet extends SApplet {

  public MainApplet() {
  }

  public void setup() {
    register(new FirstScene(this), "first");
    register(new SecondScene(this), "second");

    setScene("first");
  }
}
