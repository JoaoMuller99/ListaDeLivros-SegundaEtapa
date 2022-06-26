public class App {
  private ListaDeLivros listaDeLivros;
  private Interface interfaceObj;

  public App() {
    listaDeLivros = new ListaDeLivros();
    interfaceObj = new Interface();
  }

  public void mostraInterface(){
    interfaceObj.inicializar();
  }

  public static void main(String[] args) {
    App app = new App();

    app.mostraInterface();
  }
}