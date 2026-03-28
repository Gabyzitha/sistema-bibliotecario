package Controller;

import Model.Livro;

import java.util.LinkedList;

// GERENCIAR A LISTA DE LIVROS
public class Biblioteca {


    LinkedList<Livro> lista = new LinkedList<>(); // cria a linkedList


    // método para add livro a biblioteca
    public boolean adicionarLivro(Livro livro){
        for (Livro l : lista) { // para cada livro na lista
            if(l.equals(livro)){ // se l for igual a livro
                System.out.println("O livro " + livro + " ja está cadastrado"); //avisa
                return false; // não cadastra
            }
        }
        lista.add(livro);
        System.out.println("Livro add com sucesso!");
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

    // Criar método para exibir a lista de livros (toString)
    // verificar se as validações para add a lista esta funcionando





}


