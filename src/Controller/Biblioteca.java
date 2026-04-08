package Controller;

import Model.Livro;

import java.util.*;

// GERENCIAR A LISTA DE LIVROS
public class Biblioteca {


    LinkedList<Livro> lista = new LinkedList<>(); // cria a linkedList
    private LinkedList<String> listaDeEspera =  new LinkedList<>(); //cria a linked list de apoio para a fila
    private Stack<Livro> historico = new Stack<>(); // cria a pilha
    private HashMap<Livro, Set<Livro>> grafo = new HashMap<>(); // cria  o Hashmap (grafo)


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
            System.out.println("-------------------------------");
            System.out.println(l);
        }
        System.out.println("-------------------------------\n");

    }

    // metodo para buscar o livro por titulo na lista
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
        System.out.println("===========================================");

        System.out.println("\n★★★★★ [LISTA DE ESPERA] ★★★★★\n");

        int posicao = 1;

        for(String nome : listaDeEspera){
            System.out.println(posicao + "º- " + nome);
            posicao++;
        }
        System.out.println("\n===========================================\n");




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


    //método para add o livro pesquisado na pilha - historico (pilha)
    public void adicionarAoHistorico(Livro livro){
        historico.push(livro);
    }

    // método para vizualizar o histórico
    public void mostrarHistorico(){
        if(historico.isEmpty()) { // se o historico estiver vazio
            System.out.println("\n============================");
            System.out.println("Eita, nenhum livro visto ainda! ");
            System.out.println("===============================\n");
            return;
        }

        System.out.println("\n★★★★★ [HISTÓRICO DE LIVROS PESQUISADOS] ★★★★★\n");

        for (int i = historico.size() -1; i>=0; i--){
            System.out.println("============================");
            System.out.println(historico.get(i));
            System.out.println("===============================\n");

        }

    }

    //livro é a chave (nó)
    //new HashSet<>() é o valor (lista de recomendações)

    // método para add os livros no grafo (nós)
    public void adicionarLivroNoGrafo (Livro livro){
        grafo.putIfAbsent(livro, new HashSet<>()); // se o livro não exixstir, cria ele numa lista vazia de recomendações
    }

    // método para criar conexões
    public void adicionarConexao (Livro l1, Livro l2){
        grafo.get(l1).add(l2); // l1 recomenda l2
        grafo.get(l2).add(l1);// l2 recomenda l1
    }

    // método para recomendar
    public void recomendar(Livro livro){

        // pega as recomendações do grafo
        Set<Livro> recomendacoes = grafo.get(livro);

        if (recomendacoes == null || recomendacoes.isEmpty()){
            System.out.println("\n====================================================");
            System.out.println("Eita, esse livro não possui nenhuma outra recomendação! ");
            System.out.println("========================================================\n");
            return;
        }
        System.out.println("Você também pode gostar de: \n");

        for (Livro l:recomendacoes){
            System.out.println("-------------------------------");
            System.out.println(l);
        }
        System.out.println("-------------------------------\n");



    }

    // método de buscar livro no grafo
    public Livro buscarLivroPorTituloNoGrafo (String tituloDigitado) {

        for(Livro l : grafo.keySet()){
            if (l.getTitulo().trim().equalsIgnoreCase(tituloDigitado.trim())) { // se o titulo digitado for igual ao titulo do livro
                return l; // livro encontrado
            }
        }
        return null; //livro não encontrado
    }












}


