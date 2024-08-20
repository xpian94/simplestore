package ccmello.simplestore.e2e;

import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class RecebeAvisoProcuraCategoriaIndisponivel {
    @Quando("o cliente procurar por {string} indisponivel")
    public void oClienteProcurarPorIndisponivel(String categoria) {

    }

    @Entao("mostre a {string} que indique a indisponibilidade da categoria {string}")
    public void mostreAQueIndiqueAIndisponibilidadeDaCategoria(String mensagem, String categoria) {

    }
}
