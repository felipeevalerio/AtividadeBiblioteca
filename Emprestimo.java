public class Emprestimo {

    Cliente cliente;
    Livro[] livrosEmprestimo = new Livro[999];
    Data prazoEmprestimo;

    

    Emprestimo(Cliente cliente,Livro[] livros , Data dataAtual){

        this.livrosEmprestimo = livros;
        this.cliente = cliente;
        prazoEmprestimo = descobreDataEmprestimo(dataAtual); //prazoEmprestimo = data atual do pedido+7 dias(prazo definido pelo professor)
        
    }

    public void setCliente(Cliente cliente) {

        this.cliente = cliente;

    }

    public void setLivrosEmprestimo(Livro[] livrosEmprestimo) {

        this.livrosEmprestimo = livrosEmprestimo;

    }

    public Data descobreDataEmprestimo(Data dataAtualEmprestimo) {

        return dataAtualEmprestimo.adcionaDias(7);

    }

    public void renovarPrazoEmprestimo(Data dataAtual){ //atualiza data de emprestimo
        this.prazoEmprestimo = dataAtual.adcionaDias(7);
    }

    public void exibirEmprestimo(){
        System.out.println("Emprestimo de "+ this.cliente.getNome());
        System.out.println("Livros emprestados: ");
        for (Livro livro : livrosEmprestimo){
            System.out.println("Titulo: "+livro.getTitulo()+" //// Codigo: "+livro.getCodigo());
        }
        System.out.print("Prazo emprestimo: ");
        prazoEmprestimo.imprimeData();
    }


}
