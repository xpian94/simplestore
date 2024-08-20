package ccmello.simplestore;

import io.cucumber.java.pt.Dados;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PreparacaoDaHistoria {
    @Autowired
    private ProductRepository repo;

    @Dados("produtos cadastrados na loja")
    public void produtosCadastradosNaLoja() {
        var first = new Product();
        var second = new Product();
        var third = new Product();

        first.setCategory("Utensilios");
        first.setName("Kit 12 Facas");
        first.setQuantity(3);
        first.setAvailable(true);

        second.setCategory("Utensilios");
        second.setName("Colher de Silicone");
        second.setQuantity(12);
        second.setAvailable(true);

        third.setCategory("Utensilios");
        third.setName("Ralador 4 faces Inox");
        third.setQuantity(0);
        third.setAvailable(false);

        repo.saveAll(List.of(first, second, third));
    }
}
