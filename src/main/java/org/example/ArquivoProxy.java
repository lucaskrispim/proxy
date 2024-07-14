package org.example;

import java.util.List;

public class ArquivoProxy implements IArquivo {

    private Arquivo arquivo;
    private Integer id;

    public ArquivoProxy(Integer id) {
        this.id = id;
    }

    @Override
    public List<String> obterMetadados() {
        if (this.arquivo == null) {
            this.arquivo = new Arquivo(this.id);
        }
        return this.arquivo.obterMetadados();
    }

    @Override
    public byte[] baixarArquivo(Usuario usuario) {
        if (!usuario.isAdministrador()) {
            throw new IllegalArgumentException("Usuário não autorizado");
        }
        if (this.arquivo == null) {
            this.arquivo = new Arquivo(this.id);
        }
        return this.arquivo.baixarArquivo(usuario);
    }
}
