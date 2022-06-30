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
    int tipoCadastro = this.interfaceObj.selecinarNovoCadastro();

    if (tipoCadastro == 1) {
      int max = 1000;
      int min = this.listaDeLivros.tamanho();
      int codigoLivro = (int)(Math.random() * ((max - min) + 1)) + min;
      ArrayList<Autor> autores = this.listaDeLivros.getAutores();

      Livro livro = this.interfaceObj.novoLivro(codigoLivro);
      Edicao edicao = this.interfaceObj.novaEdicao(codigoLivro);
      int codigoAutor = this.interfaceObj.escolherAutor(autores);    

      if (livro != null && edicao != null && codigoAutor != -1) {
        this.listaDeLivros.incluirNoInicio(livro);
        this.listaDeLivros.cadastrarEdicao(edicao);
        this.listaDeLivros.cadastrarLivroAutor(new LivroAutor(codigoLivro, codigoAutor));
      }
    } else if (tipoCadastro == 2) {
      int codigoLivro = this.interfaceObj.selecinarLivro(this.listaDeLivros.getLivros());

      if (codigoLivro != -1) {
        Edicao edicao = this.interfaceObj.novaEdicao(codigoLivro);

        if (edicao != null) {
          for (Edicao _edicao : this.listaDeLivros.getEdicoes()) {
            if (_edicao.getCodigoLivro() == codigoLivro && _edicao.getEdicao() == edicao.getEdicao()) {
              this.interfaceObj.edicaoJaCadastrada();
              return;
            }
          }

          this.listaDeLivros.cadastrarEdicao(edicao);
        }
      }
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

  public void cadastrarAutor() {
    int max = 1000;
    int min = this.listaDeLivros.tamanho();
    int codigoAutor = (int)(Math.random() * ((max - min) + 1)) + min;
    Autor autor = this.interfaceObj.novoAutor(codigoAutor);

    if (autor != null) {
      this.listaDeLivros.cadastrarAutor(autor);
    }
  }

  public void inicializarApp(){
    int opcaoEscolhida = this.interfaceObj.inicializar();

    switch (opcaoEscolhida){
      case 1:
        this.interfaceObj.clearScreen();
        this.cadastrarLivro();
        this.interfaceObj.clearScreen();
        this.inicializarApp();
        break;

      case 2:
        this.interfaceObj.clearScreen();
        this.removerLivro();
        this.interfaceObj.clearScreen();
        this.inicializarApp();
        break;

      case 3:
        this.interfaceObj.clearScreen();
        this.listarLivros();
        this.interfaceObj.clearScreen();
        this.inicializarApp();
        break;

      case 4:
        this.interfaceObj.clearScreen();
        this.cadastrarAutor();
        this.interfaceObj.clearScreen();
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
