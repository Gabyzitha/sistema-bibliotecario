package Model;

public class ArvoreBinaria {

    Node raiz;


    // construtor
    public ArvoreBinaria(){
        raiz = null;
    }

    // método de add livro na árvore
    public  void adicionarLivroNaArvore (Livro livro) {
        raiz = addLivroNaArvoreRecursivo(raiz, livro);

    }

    // método de add livro na árvore recursivo
    private Node addLivroNaArvoreRecursivo(Node nodeAtual, Livro livro) {

        if (nodeAtual == null) {
            return new Node(livro);
        }

        //comparar títulos

        if (livro.getTitulo().compareToIgnoreCase(nodeAtual.livro.getTitulo()) < 0) {
            nodeAtual.esquerda = addLivroNaArvoreRecursivo(nodeAtual.esquerda, livro);
        } else if (livro.getTitulo().compareToIgnoreCase(nodeAtual.livro.getTitulo()) > 0) {
            nodeAtual.direita = addLivroNaArvoreRecursivo(nodeAtual.direita, livro);
        }

        return nodeAtual;
    }

    // método de mostrar a estrutura da árvore
    public void mostrarArvore() {
        mostrarArvoreRecursivo(raiz, 0);
    }

    // método de mostrar a estrutura da árvore recursivo
    private void mostrarArvoreRecursivo(Node nodeAtual, int nivel) {

        if (nodeAtual == null) return;

        if (nivel > 0) {
            System.out.print("   ".repeat(nivel - 1) + "+--");
        }

        System.out.println(nodeAtual.livro.getTitulo());

        mostrarArvoreRecursivo(nodeAtual.esquerda, nivel + 1);
        mostrarArvoreRecursivo(nodeAtual.direita, nivel + 1);
    }

    // metodo para listar em ordem alfabética
    public void listarEmOrdem(){
        listarEmOrdemRecursivo(raiz);
    }

    // metodo para listar em ordem alfabética recursivo
    private void listarEmOrdemRecursivo(Node nodeAtual){

        if (nodeAtual == null) return;

        listarEmOrdemRecursivo(nodeAtual.esquerda);
        System.out.println(nodeAtual.livro);
        System.out.println("-------------------------------\n");
        listarEmOrdemRecursivo(nodeAtual.direita);

    }

    //método DFS
    public boolean buscarDFS(String titulo) {
        System.out.println(("\n===== DFS =====\n"));
        return  buscarDFSRecursivo(raiz, titulo);
    }

    private boolean buscarDFSRecursivo(Node nodeAtual, String titulo){

        if (nodeAtual == null) return false;

        //mostra o caminho
        System.out.println("Visitando: " + nodeAtual.livro.getTitulo());

        // verifica se encontrou
        if(nodeAtual.livro.getTitulo().equalsIgnoreCase(titulo)) {
            System.out.println("Encontrado!!!\n");

            return true;
        }

        //procura na esquerda
        if(buscarDFSRecursivo(nodeAtual.esquerda, titulo)){
            return true;
        }

        // na direita

        return  buscarDFSRecursivo(nodeAtual.direita, titulo);
    }

    // método BFS

    public boolean buscarBFS(String titulo) {

        System.out.println(("\n===== BFS =====\n"));

        if (raiz == null) return false;

        java.util.Queue<Node> fila = new java.util.LinkedList<>();
        fila.add(raiz);

        while (!fila.isEmpty()) {


            Node atual = fila.poll();

            // mostra o caminho
            System.out.println("Visitando: " + atual.livro.getTitulo());

            // Verificar se encontrou

            if(atual.livro.getTitulo().equalsIgnoreCase(titulo)){
                System.out.println("Encontrado!!!\n");
                return true;

            }

            //add os filhos na fila
            if (atual.esquerda != null) {
                fila.add(atual.esquerda);
            }

            if(atual.direita != null) {
                fila.add(atual.direita);
            }
        }

        System.out.println(("Livro não encontrado\n"));
        return false;




    }


}
