package bo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import vo.Livro;
import vo.Edicao;
import vo.Autor;
import vo.LivroAutor;

public class ListaDeLivros {
  private ArrayList<Livro> livros = new ArrayList<Livro>();
  private ArrayList<Edicao> edicoes = new ArrayList<Edicao>();
  private ArrayList<Autor> autores = new ArrayList<Autor>();
  private ArrayList<LivroAutor> livrosAutores = new ArrayList<LivroAutor>();

  public ListaDeLivros() {
    this.livros.add(new Livro(1, "Java"));
    this.livros.add(new Livro(2, "C++"));
    this.livros.add(new Livro(3, "C#"));
    this.livros.add(new Livro(4, "Python"));
    this.edicoes.add(new Edicao(1, 1, 2010));
    this.edicoes.add(new Edicao(1, 2, 2011));
    this.edicoes.add(new Edicao(2, 1, 2009));
    this.edicoes.add(new Edicao(2, 2, 2010));
    this.edicoes.add(new Edicao(3, 1, 2008));
    this.edicoes.add(new Edicao(3, 2, 2009));
    this.edicoes.add(new Edicao(4, 1, 2007));
    this.edicoes.add(new Edicao(4, 2, 2008));
    this.autores.add(new Autor(1, "João"));
    this.autores.add(new Autor(2, "Maria"));
    this.autores.add(new Autor(3, "José"));
    this.autores.add(new Autor(4, "Pedro"));
    this.livrosAutores.add(new LivroAutor(1, 1));
    this.livrosAutores.add(new LivroAutor(2, 2));
    this.livrosAutores.add(new LivroAutor(3, 3));
    this.livrosAutores.add(new LivroAutor(4, 4));
  }

  public void incluirNoInicio(Livro livro) {
    this.livros.add(0, livro);
  }

  public void incluirNoFim(Livro livro) {
    this.livros.add(livro);
  }

  public void ordenar() {
    if (this.livros.size() > 0) {
      Collections.sort(this.livros, new Comparator<Livro>() {
          @Override
          public int compare(final Livro object1, final Livro object2) {
              return object1.getTitulo().compareTo(object2.getTitulo());
          }
      });
    }
  }

  public void removerDoFim() {
    if (this.livros.size() > 0) {
      this.livros.remove(this.livros.size() - 1);
    }
  }

  public int tamanho() {
    return this.livros.size();
  }

  public Livro get(int index) {
    return this.livros.get(index);
  }

  public ArrayList<Livro> getLivros() {
    return livros;
  }

  public ArrayList<Edicao> getEdicoes() {
    return edicoes;
  }

  public ArrayList<Autor> getAutores() {
    return autores;
  }

  public ArrayList<LivroAutor> getLivrosAutores() {
    return livrosAutores;
  }
}