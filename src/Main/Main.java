package Main;// ONDE O MENU VAI SER CONTROLADO

import Controller.Biblioteca;
import Model.Livro;

import java.awt.*;
import java.util.LinkedList;
import java.util.Scanner;




public class Main {




  public static void Menu (Biblioteca biblioteca){

    Scanner sc = new Scanner(System.in); // cria o scanner



    char opcao = ' ';

    do {

      System.out.println("a-> Adicionar livro ");
      System.out.println("b-> listar livros ");
      System.out.println("c-> sair \n");
      System.out.println("Escolha a opção que deseja: ");

      String entrada = sc.nextLine();


      if(entrada.isEmpty()){
        System.out.println("\n================================================================");
        System.out.println("      ⚠ Opção inválida. Por favor, escolha 'a', 'b' ou 'c'.");
        System.out.println("=================================================================\n");
        continue;

      }

      opcao = entrada.charAt(0);

      if (opcao == 'a') {
        System.out.println("\n★★★★★ [ADICIONAR LIVROS] ★★★★★\n");
        System.out.println("Por favor, digite as seguintes informações: \n");

        System.out.print("Título:  ");
        String titulo = sc.nextLine();

        System.out.print("Autor(a):  ");
        String autor = sc.nextLine();

        System.out.print("Ano:  ");
        int ano = Integer.parseInt((sc.nextLine()));

        Livro novoLivro = new Livro(titulo, autor, ano);

        biblioteca.adicionarLivro(novoLivro);



      } else if (opcao == 'b') {
        biblioteca.listarLivros();

      } else if (opcao == 'c'){
        System.out.println("sair");
      } else {
        System.out.println("\n================================================================");
        System.out.println("      ⚠ Opção inválida. Por favor, escolha 'a', 'b' ou 'c'.");
        System.out.println("=================================================================\n");
      }

    } while(opcao != 'c');

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

