package io.cucumber.skeleton;

import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class ProcuraProdutoPorCategoria {
    @Quando("o cliente procurar por {string}")
    public void oClienteProcurarPor(String categoria) {

    }

    @Entao("uma lista de produtos deve aparecer com produtos pertencentes a {string}")
    public void umaListaDeProdutosDeveAparecerComProdutosPertencentesA(String categoria) {

    }

    @Entao("cada produto mostrado aparecera com {string}, {string} e {string}")
    public void cadaProdutoMostradoApareceraComE(String nome, String quantidade, String disponivelAVenda) {
    }
}
