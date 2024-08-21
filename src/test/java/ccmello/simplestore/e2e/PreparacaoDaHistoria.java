package ccmello.simplestore.e2e;

import ccmello.simplestore.Product;
import ccmello.simplestore.ProductRepository;
import io.cucumber.java.pt.Dados;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PreparacaoDaHistoria {
    @Autowired
    private ProductRepository repository;

    @Dados("produtos cadastrados na loja")
    public void produtosCadastradosNaLoja() {
        var first = Product.builder()
            .category("Utensilios")
            .name("Kit 12 Facas")
            .quantity(3)
            .available(true)
            .build();

        var second = Product.builder()
            .category("Utensilios")
            .name("Colher de Silicone")
            .quantity(12)
            .available(true)
            .build();

        var third = Product.builder()
            .category("Utensilios")
            .name("Ralador 4 faces Inox")
            .quantity(0)
            .available(false)
            .build();

        repository.saveAll(List.of(first, second, third));
    }
}
