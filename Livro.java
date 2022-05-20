import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Livro implements Serializable{
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

    public void salvarLivro() {
        try {
            FileOutputStream file = new FileOutputStream("./ArquviosBin/LivrosSalvos.bin");
            ObjectOutputStream out = new ObjectOutputStream(file);
            
            out.writeObject(this);
            out.close();
        }
        catch(IOException e) {
            System.err.println("Erro ao tentar salvar no arquivo LivrosSalvos.bin");
            e.printStackTrace();
        }
    }

    public void lerLivro() {
        
        try {
            FileInputStream file = new FileInputStream("./ArquviosBin/LivrosSalvos.bin");
            ObjectInputStream in = new ObjectInputStream(file);
            Livro livrosLidos = (Livro) in.readObject();
            livrosLidos.exibirLivro();
            in.close();
        }
        catch(IOException e) {
            System.err.println("Erro ao tentar ler o arquivo LivrosSalvos.bin");
            e.printStackTrace();
        }
        catch(ClassNotFoundException e) {
            System.err.println("Classe não foi encontrada");
            e.printStackTrace();
        }
    }

    public void exibirLivro() {
        System.out.println("Livro: "+getTitulo());
    }
}
