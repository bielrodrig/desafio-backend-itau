package org.example.model;

public class Usuario {
    private String nome;
    private String senha;
    private double saldo;
    private boolean autenticado;

    public Usuario(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
        this.saldo = 0.0; // começa com R$ 0,00
        this.autenticado = false;
    }

    public boolean estaAutenticado() {
        return autenticado;
    }

    // Operações financeiras
    public void debitar(double valor) {
        this.saldo -= valor;
    }

    public void creditar(double valor) {
        this.saldo += valor;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Evite ter o getSenha público em app real. Aqui é só pra estudo.
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
