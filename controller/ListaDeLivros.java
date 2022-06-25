public class ListaDeLivros {
  private Interface interfaceObj;

  public ListaDeLivros() {
    interfaceObj = new Interface();
  }

  public void mostraInterface() {
    interfaceObj.inicializar();
  }

  public static void main(String[] args) {
    ListaDeLivros listaDeLivros = new ListaDeLivros();

    listaDeLivros.mostraInterface();
  }
}