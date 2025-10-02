package org.example;
import java.util.List;
import java.util.ArrayList;

public class Agenda {

    private final List<Contato> contatos;

    public Agenda() {
        contatos = new ArrayList<>();
    }

    public void adicionarContato(Contato c) {
        contatos.add(c);
    }

    public void listarContatos() {
        if (contatos.isEmpty()) {
            System.out.println("Nenhum contato cadastrado...");
        } else {
            System.out.println("\n Lista de Contatos:");
            int i=1;
            for (Contato c : contatos) {
                System.out.println(i + " - " + c);
                i++;
            }
        }
        System.out.println();
    }

    public void buscarContatoPorNome(String nome) {
        boolean encontrado = false;

        for (Contato c : contatos) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                System.out.println("Contato econtrado: " + c);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Nenhum contato com o nome '" + nome + "' foi encontrado.");
        }
        System.out.println();
    }

    public void removerContato(int indice) {
        if (indice > 0 && indice <= contatos.size()) {
            System.out.println("Contato " + indice + " removido com sucesso!" );
            System.out.println();
        } else {
            System.out.println("Nenhum contato com este código...");
            System.out.println();
        }
    }
}

