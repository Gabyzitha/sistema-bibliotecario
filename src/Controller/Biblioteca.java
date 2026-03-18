package Controller;

import Model.Livro;

import java.util.LinkedList;

// GERENCIAR A LISTA DE LIVROS
public class Biblioteca {

    private String titulo;
    private String autor;
    private int ano;

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

    // Criar método para exibir a lista de livros (toString)
    // verificar se as validações para add a lista esta funcionando





}


