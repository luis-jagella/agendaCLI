package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        boolean rodando=true;
        Agenda agenda = new Agenda();

        do {
            mostrarMenu();
            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome:");
                    String nome = sc.nextLine();
                    System.out.println("Digite o telefone:");
                    String telefone = sc.nextLine();
                    System.out.println("Digite o e-mail:");
                    String email = sc.nextLine();
                    Contato contato = new Contato(nome, telefone, email);
                    agenda.adicionarContato(contato);
                    System.out.println("Contato adicionado com sucesso!");
                    System.out.println();
                    break;
                case 2:
                    agenda.listarContatos();
                    System.out.print("Digite o código de qual destes quer excluir: ");

                    int sequenciaExclusao = sc.nextInt();
                    agenda.removerContato(sequenciaExclusao);
                    break;
                case 3:
                    System.out.println("Digite o nome desejado: ");
                    String busca = sc.nextLine();

                    agenda.buscarContatoPorNome(busca);
                    break;
                case 4:
                    agenda.listarContatos();
                    break;
                case 5:
                    System.out.print("Deseja mesmo sair? Seus dados serão perdidos! (S/N): ");
                    String confirmacao = sc.nextLine().trim().toUpperCase();

                    if (confirmacao.equals("S")) {
                        System.out.println("Saindo do programa...");
                        rodando = false;
                    } else {
                        System.out.println("Operação cancelada. Voltando ao menu...");
                    }
                    break;
                default:
                    System.out.println("Opção inválida, favor escolher outra!");
            }
        } while (rodando);
        sc.close();
    }
        public static void mostrarMenu() {
        System.out.println("---- Agenda de Contatos -------------");
        System.out.println("1- Adicionar novo contato");
        System.out.println("2- Remover contato");
        System.out.println("3- Buscar contato por nome");
        System.out.println("4- Listar todos os contatos");
        System.out.println("5- Fechar");
        System.out.println("-------------------------------------");
    }
}

