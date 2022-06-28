package vo;

public class Livro {
  private int codigo;
  private String titulo;

  public Livro(int codigo, String titulo) {
    this.codigo = codigo;
    this.titulo = titulo;
  }

  public int getCodigo() {
    return codigo;
  }

  public String getTitulo() {
    return titulo;
  }
}