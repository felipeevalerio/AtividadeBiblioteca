public class Livro {
    String codigo;
    String titulo;

    public Livro(String codigo, String titulo){

        setCodigo(codigo);
        setTitulo(titulo);
        
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
