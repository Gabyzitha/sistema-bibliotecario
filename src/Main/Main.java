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
      System.out.println("a-> Adicionar livro ");
      System.out.println("b-> Listar livros ");
      System.out.println("c-> Verificar a disponibilidade de livro");
      System.out.println("d-> Chamar o próximo da fila");
      System.out.println("e-> Histórico de navegação");
      System.out.println("f-> Recomendação de livros");
      System.out.println("g-> Sair \n");

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
          biblioteca.adicionarAoHistorico(livro);
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
                System.out.print("Digite o seu nome: ");
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

        System.out.println("===============================");
        System.out.println("Agora é a vez de " + proximo);
        System.out.println("===============================\n");

        // OPÇÃO HISTORICO DE NAVEGAÇÃO
      } else if (opcao == 'e') {
        biblioteca.mostrarHistorico();

        // OPCÃO DE RECOMENDAR LIVROS
      } else if (opcao == 'f') {
        System.out.println("\n★★★★★ [RECOMENDAÇÕES DE LIVROS] ★★★★★\n");
        System.out.println("--- OBS: as recomendações são baseadas em um catálogo interno ---\n");
        System.out.print("Digite o título do livro: ");
        String tituloDigitado = sc.nextLine().trim();


        Livro livro = biblioteca.buscarLivroPorTituloNoGrafo(tituloDigitado); // chama o método para buscar o livro pelo titulo

        if (livro == null) { // se o livro for nulo

          System.out.println("\n=============================");
          System.out.println("LIVRO NÃO ENCONTRADO :( ");
          System.out.println("=============================\n");
        } else {

          System.out.println("\n========================");
          System.out.println("LIVRO ENCONTRADO: \n");
          System.out.println(livro);
          biblioteca.adicionarAoHistorico(livro);
          System.out.println("========================\n");

          biblioteca.recomendar(livro);


        }

        // OPÇÃO DE SAIR
      } else if (opcao == 'g') {
        System.out.println("sair");
      }  else {
        System.out.println("\n================================================================");
        System.out.println("      ⚠ Opção inválida. Por favor, escolha 'a', 'b' ou 'c'.");
        System.out.println("=================================================================\n");
      }

    } while(opcao != 'g');

    sc.close();

  }

  public static void main(String[] args){

    System.out.println("==================================================\n");
    System.out.println("        BEM VINDA(E/O) AO ACERVO LÉSBICO\n");
    System.out.println("=================================================\n");

    Biblioteca biblioteca = new Biblioteca(); //cria a biblioteca

    // criando livros (nós)
    Livro l1 = new Livro ("O amor não é obvio", "Elayne Baeta", 2019, false);
    Livro l2 = new Livro("Delilah Green não está nem ai", "Ashley Herring", 2022, true);
    Livro l3 = new Livro("Os sete maridos de Evelyn Hugo", "Taylor Jenkins", 2019, true);
    Livro l4 = new Livro("A noite passsada no Telegraph Club", "Malinda Lo", 2022, false);
    Livro l5 = new Livro("É assim que se perde a guerra do tempo", "Amal El-Mohtar", 201, true);
    Livro l6 = new Livro("Lembre-se de nós", "Alyson Derrick", 2023, true);
    Livro l7 = new Livro("Rebeldes, revoluções e outras coisas que as princesas gostam", "Bruna Salles", 2022, false);
    Livro l8 = new Livro("Conectadas", "Clara Alves", 2019, true);
    Livro l9 = new Livro("Sua alteza real", "Rachel Hawkins", 2020, false);
    Livro l10 = new Livro("Memórias de um amor inesperado", "Ciara Smyth", 2024, true);

    // add no grafo
    biblioteca.adicionarLivroNoGrafo(l1);
    biblioteca.adicionarLivroNoGrafo(l2);
    biblioteca.adicionarLivroNoGrafo(l3);
    biblioteca.adicionarLivroNoGrafo(l4);
    biblioteca.adicionarLivroNoGrafo(l5);
    biblioteca.adicionarLivroNoGrafo(l6);
    biblioteca.adicionarLivroNoGrafo(l7);
    biblioteca.adicionarLivroNoGrafo(l8);
    biblioteca.adicionarLivroNoGrafo(l9);
    biblioteca.adicionarLivroNoGrafo(l10);

    // criando conexões
    biblioteca.adicionarConexao(l1, l8);
    biblioteca.adicionarConexao(l1, l3);
    biblioteca.adicionarConexao(l2, l10);
    biblioteca.adicionarConexao(l2, l1);
    biblioteca.adicionarConexao(l3, l5);
    biblioteca.adicionarConexao(l3, l4);
    biblioteca.adicionarConexao(l4, l1);
    biblioteca.adicionarConexao(l4, l7);
    biblioteca.adicionarConexao(l5, l3);
    biblioteca.adicionarConexao(l5, l7);
    biblioteca.adicionarConexao(l6, l8);
    biblioteca.adicionarConexao(l6, l9);
    biblioteca.adicionarConexao(l7, l3);
    biblioteca.adicionarConexao(l7, l9);
    biblioteca.adicionarConexao(l8, l1);
    biblioteca.adicionarConexao(l8, l6);
    biblioteca.adicionarConexao(l9, l8);
    biblioteca.adicionarConexao(l9, l2);
    biblioteca.adicionarConexao(l10, l2);
    biblioteca.adicionarConexao(l10, l6);


    Menu(biblioteca); // chama o menu





  }
}


