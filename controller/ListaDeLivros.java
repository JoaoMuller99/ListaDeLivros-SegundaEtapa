import view.Interface;

public class ListaDeLivros {
  private Interface interface;

  public ListaDeLivros() {
    interface = new Interface();
  }

  public void mostraInterface() {
    interface.inicializar();
  }

  public static void main(String[] args) {
    ListaDeLivros listaDeLivros = new ListaDeLivros();

    listaDeLivros.mostraInterface();
  }
}