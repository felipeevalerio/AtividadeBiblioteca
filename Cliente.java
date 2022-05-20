import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Cliente implements Serializable {
    String matricula;
    String nome;

    public Cliente(String matricula, String nome) throws IOException{

        setMatricula(matricula);
        setNome(nome);

        salvarCliente(); //salvando cliente no arquivo binário;
        
    }

    public void setMatricula(String matricula){
        this.matricula = matricula;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }

    public String getMatricula(){
        return matricula;
    }

    private void salvarCliente() throws IOException{
        
        FileOutputStream file = new FileOutputStream("./ArquviosBin/ClientesSalvos.bin", true);
        ObjectOutputStream out = new ObjectOutputStream(file);

        out.writeObject(this);

        out.close();
    }

    public void lerCliente() throws IOException, ClassNotFoundException{
        FileInputStream file = new FileInputStream("./ArquviosBin/ClientesSalvos.bin");
        ObjectInputStream in = new ObjectInputStream(file);
        Cliente clienteLido = (Cliente) in.readObject();
        clienteLido.exibirCliente();

        in.close();
    }

    public void exibirCliente(){
        System.out.println("Cliene: "+this.getNome());

    }
}
