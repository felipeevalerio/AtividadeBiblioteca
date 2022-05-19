import java.time.LocalDateTime;

public class Aplicacao {
    public static void main(String []args){
        try{
            
            LocalDateTime descobreDataAtual = LocalDateTime.now();

            Data dataAtual = new Data(descobreDataAtual.getDayOfMonth(), descobreDataAtual.getMonthValue(), descobreDataAtual.getYear());//descobre data atual

            Biblioteca b = new Biblioteca();

            System.out.println("Clientes:");
            for (int i = 0; i < b.quantidadeClientes; i++) {
                System.out.print("Matricula:"+ b.clientes[i].getMatricula()); //Demonstrando o recebimento de todos clientes cadastrados no "database"
                System.out.println(" //// Nome:"+ b.clientes[i].getNome());
            }

            System.out.println("==================================================");

            System.out.println("Livros:");
            for (int i = 0; i < b.quantidadeLivros; i++) {
                System.out.print("Codigo:"+ b.livros[i].getCodigo());
                System.out.println(" //// Titulo:"+ b.livros[i].getTitulo()); //Demonstrando o recebimento de todos livros cadastrados no "database"
            }       

            System.out.println("==================================================");


            Livro[] livrosDesejados = new Livro[2];

            livrosDesejados[0] = b.livros[2];
            livrosDesejados[1] = b.livros[1];

            b.cadastrarEmprestimo(b.clientes[1],livrosDesejados);  //Demonstrando o registro do emprestimo de 2 livros associado a 1 prazo e um cliente

            Emprestimo emprestimoTeste = b.emprestimos[0];

            emprestimoTeste.exibirEmprestimo();


            System.out.println("\n==================================================");

            System.out.println("ATUALIZANDO DATA DE EMPRESTIMO!");

            Data dataAposPassarTempo = dataAtual.adcionaDias(5); //Para demonstracao considera-se que passaram #5# dias desde o emprestimo!

            emprestimoTeste.renovarPrazoEmprestimo(dataAposPassarTempo);  //Demonstrando a renovacao do emprestimo -> Adcionando +7 à "data apos 5 dias"(ler linha 46)

            System.out.println("Emprestimo Atualizado: ");

            emprestimoTeste.exibirEmprestimo(); 
            
            

        }catch(Exception e){

            System.out.println(e);

        }

    }
}
