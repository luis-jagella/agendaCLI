package org.example;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Agenda {

    private final List<Contato> contatos;

    public Agenda() {
        contatos = new ArrayList<>();
        carregarContatosDoArquivo();
    }

    private static final String ARQUIVO = "contatos.json";

    public void salvarContatosNoArquivo() {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(ARQUIVO)) {
            gson.toJson(contatos, writer);
        } catch (IOException e) {
            System.out.println("Erro ao salvar contatos: " + e.getMessage());
        }
    }

    public void carregarContatosDoArquivo() {
        Gson gson = new Gson();
        Type listaTipo = new TypeToken<List<Contato>>(){}.getType();
        try (FileReader reader = new FileReader(ARQUIVO)) {
            List<Contato> contatosDoArquivo = gson.fromJson(reader, listaTipo);
            if (contatosDoArquivo != null) {
                contatos.clear();
                contatos.addAll(contatosDoArquivo);
            }
        } catch (IOException e) {
            System.out.println("Nenhum arquivo de contatos encontrado. Começando com a lista vazia.");
        }
    }

    public void adicionarContato(Contato c) {
        contatos.add(c);
        salvarContatosNoArquivo();
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
            contatos.remove(indice - 1);
            salvarContatosNoArquivo();
            System.out.println("Contato removido com sucesso!");
        } else {
            System.out.println("Nenhum contato com este código...");
        }
        System.out.println();
    }

    public void editarContato(int indice, String novoNome, String novoTelefone, String novoEmail) {
        if (indice > 0 && indice <= contatos.size()) {
            Contato c = contatos.get(indice - 1);
            c.setNome(novoNome);
            c.setTelefone(novoTelefone);
            c.setEmail(novoEmail);
            salvarContatosNoArquivo();
            System.out.println("Contato atualizado!");
        } else {
            System.out.println("Nenhum contato com este código!");
        }
    }

    public Contato getContato(int indice) {
        if (indice > 0 && indice <= contatos.size()) {
            return contatos.get(indice - 1);
        }
        return null;
    }
}

