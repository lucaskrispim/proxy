package org.example;

import java.util.HashMap;
import java.util.Map;

public class BD {
    private static Map<Integer, Arquivo> arquivos = new HashMap<>();

    public static Arquivo getArquivo(Integer id) {
        return arquivos.get(id);
    }

    public static void addArquivo(Arquivo arquivo) {
        arquivos.put(arquivo.getId(), arquivo);
    }
}
