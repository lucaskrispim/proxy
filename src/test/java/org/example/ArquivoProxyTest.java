package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ArquivoProxyTest {

    @BeforeEach
    void setUp() {
        BD.addArquivo(new Arquivo(1, "Relatório", "pdf", new byte[]{1, 2, 3}));
        BD.addArquivo(new Arquivo(2, "Planilha", "xlsx", new byte[]{4, 5, 6}));
    }

    @Test
    void deveRetornarMetadadosArquivo() {
        ArquivoProxy arquivo = new ArquivoProxy(1);

        assertEquals(Arrays.asList("Relatório", "pdf"), arquivo.obterMetadados());
    }

    @Test
    void deveBaixarArquivo() {
        Usuario usuario = new Usuario("Ana", true);
        ArquivoProxy arquivo = new ArquivoProxy(2);

        assertArrayEquals(new byte[]{4, 5, 6}, arquivo.baixarArquivo(usuario));
    }

    @Test
    void deveRetonarExcecaoUsuarioNaoAutorizadoBaixarArquivo() {
        try {
            Usuario usuario = new Usuario("Joana", false);
            ArquivoProxy arquivo = new ArquivoProxy(2);

            arquivo.baixarArquivo(usuario);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("Usuário não autorizado", e.getMessage());
        }
    }
}