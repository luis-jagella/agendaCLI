package org.example;

public class Contato {
    private final String nome;
    private final String telefone;
    private final String email;

    public Contato(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }
    @Override
    public String toString() {
        return "Nome: " + nome + ", Telefone: " + telefone + ", E-mail: " + email;
    }
}