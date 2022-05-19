import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;

public class Biblioteca{
    //Ler um arquivo txt contendo as informações dos LIVROS (Codigo;Titulo)
    //Ler um arquivo txt contendo as informações dos CLIENTES (Matricula;Nome)
    
    Livro livros[] = new Livro[999];
    int quantidadeLivros = 0;
    Cliente clientes [] = new Cliente[999];
    int quantidadeClientes = 0;
    Emprestimo emprestimos[] = new Emprestimo[999];
    int quantidadeEmprestimos;
    
    public Biblioteca() throws IOException{

        livros = lerLivrosCadastrados();
        clientes = lerClientesCadastrados();

    }

    public void cadastrarEmprestimo(Cliente cliente, Livro[] livrosDesejados){

        LocalDateTime descobreDataAtual = LocalDateTime.now();

        Data dataAtual = new Data(descobreDataAtual.getDayOfMonth(), descobreDataAtual.getMonthValue(), descobreDataAtual.getYear());//descobre data atual

        emprestimos[quantidadeEmprestimos] = new Emprestimo(cliente, livrosDesejados, dataAtual); //passa a data atual, isto é a data que foi feito o emprestimo
    }

    public Livro[] lerLivrosCadastrados() throws IOException{

        Livro[] livrosLidos = new Livro[999];

        String linha;
        BufferedReader br = inicializaLeitor("Livros.txt");


        linha = br.readLine(); 
        while(linha!=null){

            String codigo = linha.substring(0, linha.indexOf(';'));
		    String titulo = linha.substring(linha.lastIndexOf(';') + 1, linha.length());

            livrosLidos[quantidadeLivros] = new Livro(codigo, titulo); 

            quantidadeLivros ++;

            linha = br.readLine();

        }
        
        br.close();

        return livrosLidos;

    }

    public Cliente[] lerClientesCadastrados() throws IOException{
        
        Cliente[] clientesLidos = new Cliente[999];

        String linha;
        BufferedReader br = inicializaLeitor("Clientes.txt");


        linha = br.readLine(); 
        while(linha!=null){

            String matricula = linha.substring(0, linha.indexOf(';'));
		    String nome = linha.substring(linha.lastIndexOf(';') + 1, linha.length());

            clientesLidos[quantidadeClientes] = new Cliente(matricula, nome); 

            quantidadeClientes++;

            linha = br.readLine();

        }
        
        br.close();

        return clientesLidos;
        
    }

    public void atualizarCadastros() throws IOException{ //perfomace baixa!!!

        livros = lerLivrosCadastrados();
        clientes = lerClientesCadastrados();
    
    }

    public BufferedReader inicializaLeitor(String arquivoParaLer) throws FileNotFoundException{
        
        FileInputStream stream = new FileInputStream("./ArquivosTxt/"+arquivoParaLer);//inserir caminho dos dados 
		InputStreamReader reader = new InputStreamReader(stream);
		BufferedReader br = new BufferedReader(reader);

        return br;
    }
}