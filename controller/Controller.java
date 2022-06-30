import java.util.ArrayList;

import bo.ListaDeLivros;
import vo.Autor;
import vo.Edicao;
import vo.Livro;
import vo.LivroAutor;

public class Controller {
  private ListaDeLivros listaDeLivros;
  private Interface interfaceObj;


  public Controller() {
    this.listaDeLivros = new ListaDeLivros();
    this.interfaceObj = new Interface();
  }

  public void cadastrarLivro() {
    int codigoLivro = this.listaDeLivros.tamanho();
    ArrayList<Autor> autores = this.listaDeLivros.getAutores();

    Livro livro = this.interfaceObj.novoLivro(codigoLivro);
    Edicao edicao = this.interfaceObj.novaEdicao(codigoLivro);
    int codigoAutor = this.interfaceObj.escolherAutor(autores);

    if (livro != null && edicao != null && codigoAutor != -1) {
      this.listaDeLivros.incluirNoInicio(livro);
      this.listaDeLivros.cadastrarEdicao(edicao);
      this.listaDeLivros.cadastrarLivroAutor(new LivroAutor(codigoLivro, codigoAutor));
    }
  }

  public void removerLivro() {
    if(this.listaDeLivros.tamanho() > 0) {
      this.listaDeLivros.removerDoFim();
      this.interfaceObj.confirmacaoRemocaoLivro();
    } else {
      this.interfaceObj.erroRemocaoLivro();
    }
  }

  public void listarLivros() {
    this.listaDeLivros.ordenar();
    ArrayList<Livro> livros = this.listaDeLivros.getLivros();
    this.interfaceObj.listarLivros(livros);
  }

  public void inicializarApp(){
    int opcaoEscolhida = this.interfaceObj.inicializar();

    switch (opcaoEscolhida){
      case 1:
        this.cadastrarLivro();
        this.inicializarApp();
        break;

      case 2:
        this.removerLivro();
        this.inicializarApp();
        break;

      case 3:
        this.listarLivros();
        this.inicializarApp();
        break;

      case 4:
        System.out.println("4 - Incluir autor");
        this.inicializarApp();
        break;

      case 5:
        System.out.println("\nSaindo...");
        break;

      default:
        System.out.println("\nOpção inválida! Tente novamente.");
        this.inicializarApp();
        break;
    }
  }

  public ArrayList<Livro> retornaLivros() {
    return this.listaDeLivros.getLivros();
  }
}
