package vo;

public class LivroAutor {
  private int codigoLivro;
  private int codigoAutor;
  
  public LivroAutor(int codigoLivro, int codigoAutor) {
    this.codigoLivro = codigoLivro;
    this.codigoAutor = codigoAutor;
  }
  
  public int getCodigoLivro() {
    return codigoLivro;
  }
  
  public int getCodigoAutor() {
    return codigoAutor;
  }
}