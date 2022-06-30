import java.util.ArrayList;
import java.util.Scanner;

import vo.Edicao;
import vo.Livro;
import vo.Autor;

public class Interface {
  Scanner leitorInt;
  Scanner leitorString;

  public Interface(){
    this.leitorInt = new Scanner(System.in);
    this.leitorString = new Scanner(System.in);
  }

  public int inicializar() {
    System.out.println("--------------------------------------------------");
    System.out.println("Digite o numero da acao que deseja realizar:");
    System.out.println("1 - Incluir livro");
    System.out.println("2 - Remover livro do fim da lista");
    System.out.println("3 - Mostrar lista completa de livros");
    System.out.println("4 - Incluir autor");
    System.out.println("5 - Sair");
    System.out.println("--------------------------------------------------");

    return leitorInt.nextInt();
  }

  public int selecinarNovoCadastro() {
    try {
      System.out.println("--------------------------------------------------");
      System.out.println("Digite o numero da acao que deseja realizar:");
      System.out.println("1 - Cadastrar novo livro");
      System.out.println("2 - Cadastrar nova edicao");
      System.out.println("--------------------------------------------------");

      int opcaoEscolhida = leitorInt.nextInt();

      if (opcaoEscolhida == 1 || opcaoEscolhida == 2) {
        return opcaoEscolhida;
      }

      throw new Exception();
    } catch (Exception e) {
      System.out.println("--------------------------------------------------");
      System.out.println("Opcao invalida!");
      System.out.println("--------------------------------------------------");

      return -1;
    }
  }

  public Livro novoLivro(int codigoLivro) {
    try {
      System.out.println("--------------------------------------------------");
      System.out.println("Digite o nome do livro:");
      String nome = leitorString.nextLine();
      System.out.println("--------------------------------------------------");

      return new Livro(codigoLivro, nome);
    } catch (Exception e) {
      System.out.println("--------------------------------------------------");
      System.out.println("Erro ao cadastrar livro!");
      System.out.println("--------------------------------------------------");

      return null;
    }
  }

  public int selecinarLivro(ArrayList<Livro> livros) {
    try {
      System.out.println("--------------------------------------------------");
      System.out.println("Digite o codigo do livro:");
      for (Livro livro : livros) {
        System.out.println(livro.getCodigo() + " - " + livro.getTitulo());
      }
      System.out.println("--------------------------------------------------");
      int codigoLivro = leitorInt.nextInt();

      for (Livro livro : livros) {
        if (livro.getCodigo() == codigoLivro) {
          return codigoLivro;
        }
      }
      
      throw new Exception();
    } catch (Exception e) {
      System.out.println("--------------------------------------------------");
      System.out.println("Codigo de livro invalido!");
      System.out.println("--------------------------------------------------");
      System.out.println("Pressione um botao para continuar...");
      leitorString.nextLine();

      return -1;
    }
  }

  public Edicao novaEdicao(int codigoLivro) {
    try {
      System.out.println("--------------------------------------------------");
      System.out.println("Digite o numero da edicao do livro:");
      int edicao = leitorInt.nextInt();
      System.out.println("Digite o ano de lancamento do livro:");
      int ano = leitorInt.nextInt();
      System.out.println("--------------------------------------------------");

      return new Edicao(codigoLivro, edicao, ano);
    } catch (Exception e) {
      System.out.println("--------------------------------------------------");
      System.out.println("Erro ao cadastrar edicao!");
      System.out.println("--------------------------------------------------");
      System.out.println("Pressione um botao para continuar...");
      leitorString.nextLine();

      return null;      
    }
  }

  public Autor novoAutor(int codigoAutor) {
    try {
      System.out.println("--------------------------------------------------");
      System.out.println("Digite o nome do autor:");
      String nome = leitorString.nextLine();
      System.out.println("--------------------------------------------------");

      return new Autor(codigoAutor, nome);
    } catch (Exception e) {
      System.out.println("--------------------------------------------------");
      System.out.println("Erro ao cadastrar autor!");
      System.out.println("--------------------------------------------------");
      System.out.println("Pressione um botao para continuar...");
      leitorString.nextLine();

      return null;
    }
  }

  public int escolherAutor(ArrayList<Autor> autores) {
    System.out.println("--------------------------------------------------");
    System.out.println("Digite o codigo do autor:");
    for (Autor autor : autores) {
      System.out.println(autor.getCodigo() + " - " + autor.getNome());
    }
    int codigoAutor = leitorInt.nextInt();
    System.out.println("--------------------------------------------------");

    for (Autor autor : autores) {
      if (codigoAutor == autor.getCodigo()) {
        return codigoAutor;
      }
    }

    System.out.println("--------------------------------------------------");
    System.out.println("Autor nao encontrado!");
    System.out.println("--------------------------------------------------");

    return -1;
  }

  public void confirmacaoRemocaoLivro() {
    System.out.println("--------------------------------------------------");
    System.out.println("Livro removido com sucesso!");
    System.out.println("--------------------------------------------------");
    System.out.println("Pressione um botao para continuar...");
    leitorString.nextLine();
  }

  public void erroRemocaoLivro() {
    System.out.println("--------------------------------------------------");
    System.out.println("Nao ha livros para remover!");
    System.out.println("--------------------------------------------------");
    System.out.println("Pressione um botao para continuar...");
    leitorString.nextLine();
  }

  public void edicaoJaCadastrada(){
    System.out.println("--------------------------------------------------");
    System.out.println("Edicao ja cadastrada!");
    System.out.println("--------------------------------------------------");

    System.out.println("Pressione um botao para continuar...");
    leitorString.nextLine();
  }

  public void listarLivros(ArrayList<Livro> livros) {
    if (livros.size() == 0) {
      System.out.println("--------------------------------------------------");
      System.out.println("Nao ha livros cadastrados!");
      System.out.println("--------------------------------------------------");
    } else {
      System.out.println("--------------------------------------------------");
      for (Livro livro : livros) {
        System.out.println(livro.getCodigo() + " - " + livro.getTitulo());
      }
      System.out.println("--------------------------------------------------");
    }

    System.out.println("Pressione um botao para continuar...");
    leitorString.nextLine();
  }

  public void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }
}