package Main;// ONDE O MENU VAI SER CONTROLADO

import Controller.Biblioteca;
import Model.Livro;

import java.util.LinkedList;
import java.util.Scanner;


public class Main {


  public static void Menu (Biblioteca biblioteca){

    Scanner sc = new Scanner(System.in); // cria o scanner


    char opcao = ' ';

    do {

      // OPCÇÕES MENU
      System.out.println("a-> Adicionar Livro ");
      System.out.println("b-> Listar Livros ");
      System.out.println("c-> Verificar a Disponibilidade de Livro");
      System.out.println("d-> Chamar o Próximo da Fila");
      System.out.println("e-> Histórico de navegação");
      System.out.println("f-> Sair \n");

      System.out.print("Escolha a opção que deseja: ");

      String entrada = sc.nextLine().trim().toLowerCase();


      if(entrada.isEmpty()){
        System.out.println("\n================================================================");
        System.out.println("      ⚠ Opção inválida. Por favor, escolha 'a', 'b' ou 'c'.");
        System.out.println("=================================================================\n");
        continue;

      }

      opcao = entrada.charAt(0);

      // OPÇÃO DE ADD LIVROS
      if (opcao == 'a') {
        System.out.println("\n★★★★★ [ADICIONAR LIVROS] ★★★★★\n");
        System.out.println("Por favor, digite as seguintes informações: ");

        System.out.print("\nTítulo:  ");
        String titulo = sc.nextLine();

        System.out.print("Autor(a):  ");
        String autor = sc.nextLine();

        System.out.print("Ano:  ");
        int ano = Integer.parseInt((sc.nextLine()));

        boolean disponivel;

        while(true){
          System.out.print("Disponibilidade (s/n):  ");
          String resposta = sc.nextLine().trim().toLowerCase();

          if (resposta.equals("s")){
            disponivel = true;
            break;
          } else if (resposta.equals("n")){
            disponivel = false;
            break;
          } else {
            System.out.println("\n================================================================");
            System.out.println("      ⚠ Opção inválida. Por favor, digite 's' ou 'n' !");
            System.out.println("=================================================================\n");
          }

        }

        Livro novoLivro = new Livro(titulo, autor, ano, disponivel);

        biblioteca.adicionarLivro(novoLivro);


        // OPÇAO DE LISTAR LIVROS
      } else if (opcao == 'b') {
        biblioteca.listarLivros();

        // OPÇÃO DE VERIFICAR A DISPONIBILIDADE DE LIVROS (FILA)
      } else if (opcao == 'c'){
        System.out.println("\n★★★★★ [DISPONIBILIDADE DOS LIVROS] ★★★★★\n");
        System.out.print("Digite o título do livro que deseja alugar: ");
        String tituloDigitado = sc.nextLine();


        Livro livro = biblioteca.buscarLivroPorTitulo(tituloDigitado); // chama o método para buscar o livro pelo titulo

        if (livro == null) { // se o livro for nulo

          System.out.println("\n=============================");
          System.out.println("LIVRO NÃO ENCONTRADO :( ");
          System.out.println("=============================\n");
        } else {

          System.out.println("\n========================");
          System.out.println("LIVRO ENCONTRADO: \n");
          System.out.println(livro);
          System.out.println("========================\n");

          System.out.print("Deseja verificar a disponibilidade do livro para alugar(s/n)? ");
          String simOuNao = sc.nextLine();
          if (simOuNao.equals("s")) {
            if (livro.isDisponivel()) {
              System.out.println("\n==================================");
              System.out.println("O LIVRO ESTÁ DISPONÍVEL PARA ALUGAR! ");
              System.out.println("====================================\n");

            } else {
              System.out.println("\n====================================================");
              System.out.println("O LIVRO NÃO ESTÁ DISPONÍVEL PARA ALUGAR NO MOMENTO :( ");
              System.out.println("======================================================\n");

              System.out.print("Deseja entrar na fila de espera (s/n)? ");
              simOuNao = sc.nextLine();

              if (simOuNao.equals("s")) {
                System.out.println("Digite o seu nome: ");
                String nomeUsuario = sc.nextLine();
                biblioteca.addAoFinalDaFila(nomeUsuario);
              }
            }
          }
        }
        // OPÇÃO DE CHAMAR O PROXIMO DA FILA
      } else if (opcao == 'd') {
        System.out.println("\n★★★★★ [CHAMAR O PROXIMO DA FILA] ★★★★★\n");

        String proximo = biblioteca.chamarProximoDaFila();

        System.out.println("\n===============================");
        System.out.println("Agora é a vez de " + proximo);
        System.out.println("===============================\n");

        // OPÇÃO HISTORICO DE NAVEGAÇÃO
      } else if (opcao == 'e') {


      } else if (opcao == 'f') {
        System.out.println("sair");
      }  else {
        System.out.println("\n================================================================");
        System.out.println("      ⚠ Opção inválida. Por favor, escolha 'a', 'b' ou 'c'.");
        System.out.println("=================================================================\n");
      }

    } while(opcao != 'f');

    sc.close();

  }


  public static void main(String[] args){

    System.out.println("==================================================\n");
    System.out.println("        BEM VINDA(E/O) AO ACERVO LÉSBICO\n");
    System.out.println("==================================================\n");

    Biblioteca biblioteca = new Biblioteca(); //cria a biblioteca


    Menu(biblioteca);

  }
}

// o que falta:
// add o metodo de historico de navegação
// estilizar a exibição de listar livros
// estilizar a exibição da lista de espera
