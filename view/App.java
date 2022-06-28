import bo.ListaDeLivros;
import vo.Livro;

public class App {
  private ListaDeLivros listaDeLivros;
  private Interface interfaceObj;

  public App() {
    this.listaDeLivros = new ListaDeLivros();
    this.interfaceObj = new Interface();
  }

  public void mostraInterface(){
    this.interfaceObj.inicializar();
  }

  public static void main(String[] args) {
    App app = new App();

    System.out.println("Lista de livros:");
    for (Livro livro : app.listaDeLivros.getLivros()) {
      System.out.println(livro.getCodigo() + " - " + livro.getTitulo());
    }

    app.mostraInterface();
  }
}