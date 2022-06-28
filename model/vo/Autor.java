package vo;

public class Autor {
  private int codigo;
  private String nome;

  public Autor(int codigo, String nome) {
    this.codigo = codigo;
    this.nome = nome;
  }

  public int getCodigo() {
    return codigo;
  }

  public String getNome() {
    return nome;
  }
}