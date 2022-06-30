public class App {
  private Controller controller;

  public App() {
    this.controller = new Controller();
  }

  public static void main(String[] args) {
    App app = new App();

    app.controller.inicializarApp();
  }
}