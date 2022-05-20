import java.io.Serializable;

public class Cliente implements Serializable {
    String matricula;
    String nome;

    public Cliente(String matricula, String nome){

        setMatricula(matricula);
        setNome(nome);
        
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
}
