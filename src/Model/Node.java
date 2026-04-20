package Model;

public class Node {

    // atributos
    Livro livro;
    Node esquerda;
    Node direita;

    // construtor
    public Node(Livro livro) {
        this.livro = livro;
        this.esquerda = null;
        this.direita = null;
    }
}
