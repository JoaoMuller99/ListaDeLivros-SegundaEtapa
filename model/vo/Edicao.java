package vo;

public class Edicao {
  private int codigoLivro;
  private int edicao;
  private int ano;

  public Edicao(int codigoLivro, int edicao, int ano) {
    this.codigoLivro = codigoLivro;
    this.edicao = edicao;
    this.ano = ano;
  }

  public int getCodigoLivro() {
    return codigoLivro;
  }

  public int getEdicao() {
    return edicao;
  }

  public int getAno() {
    return ano;
  }
}