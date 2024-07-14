package org.example;

import java.util.List;

public interface IArquivo {
    List<String> obterMetadados();
    byte[] baixarArquivo(Usuario usuario);
}
