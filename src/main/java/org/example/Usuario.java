package org.example;

public class Usuario {
    private String nome;
    private boolean administrador;

    public Usuario(String nome, boolean administrador) {
        this.setNome(nome);
        this.setAdministrador(administrador);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isAdministrador() {
        return administrador;
    }

    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }
}
