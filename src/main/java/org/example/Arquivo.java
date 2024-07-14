package org.example;

import java.util.Arrays;
import java.util.List;

public class Arquivo implements IArquivo {

    private Integer id;
    private String nome;
    private String tipo;
    private byte[] conteudo;

    public Arquivo(int id) {
        this.id = id;
        Arquivo objeto = BD.getArquivo(id);
        this.nome = objeto.nome;
        this.tipo = objeto.tipo;
        this.conteudo = objeto.conteudo;
    }

    public Arquivo(Integer id, String nome, String tipo, byte[] conteudo) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.conteudo = conteudo;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public List<String> obterMetadados() {
        return Arrays.asList(this.nome, this.tipo);
    }

    @Override
    public byte[] baixarArquivo(Usuario usuario) {
        return this.conteudo;
    }
}