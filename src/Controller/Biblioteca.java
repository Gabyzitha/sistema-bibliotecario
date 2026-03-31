package Controller;

import Model.Livro;

import java.util.LinkedList;

// GERENCIAR A LISTA DE LIVROS
public class Biblioteca {


    LinkedList<Livro> lista = new LinkedList<>(); // cria a linkedList
    private LinkedList<String> listaDeEspera =  new LinkedList<>();


    // método para add livro a biblioteca
    public boolean adicionarLivro(Livro livro){
        for (Livro l : lista) { // para cada livro na lista
            if(l.equals(livro)){ // se l for igual a livro
                System.out.println("O livro " + livro + " ja está cadastrado"); //avisa
                return false; // não cadastra
            }
        }
        lista.add(livro);

        System.out.println("\n==================================");
        System.out.println(" LIVRO ADICIONADO COM SUCESSO!");
        System.out.println("===================================\n");

        return true;
    }

    // método para listar livros
    public void listarLivros(){
        if (lista.isEmpty()) {
            System.out.println("Nenhum livro cadastrado no momento!");
            return;
        }
        System.out.println("\n★★★★★ [LISTAR LIVROS] ★★★★★\n");

        for (Livro l : lista) {
            System.out.println(l);
        }
    }

    // metodo para buscar o livro por titulo
    public Livro buscarLivroPorTitulo (String tituloDigitado) {

        for(Livro l : lista){
            if (l.getTitulo().trim().equalsIgnoreCase(tituloDigitado.trim())) { // se o titulo digitado for igual ao titulo do livro
                return l; // livro encontrado
            }
        }
        return null; //livro não encontrado
    }

    // metodo para colocar na fila (ao final)
    public void addAoFinalDaFila (String nomeUsuario) {
        listaDeEspera.addLast(nomeUsuario);
        System.out.println("\n=========================================");
        System.out.println("Adicionado na lista de espera com sucesso! ");
        System.out.println("===========================================\n");
        System.out.println(listaDeEspera);

    }

    // metodo para chamar o proximo da fila
    public String chamarProximoDaFila(){
        if (!listaDeEspera.isEmpty()){ // se a lista não estiver vazia
            return listaDeEspera.removeFirst(); // remove o primeiro ("chama o proximo)

        } else {
            System.out.println("\n============================");
            System.out.println("Eita, a fila está vazia! ");
            System.out.println("===============================\n");
            return null;
        }

    }


    //método para registrar o historico (pilha)







}


