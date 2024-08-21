package ccmello.simplestore.it;

import ccmello.simplestore.Product;
import ccmello.simplestore.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ProductRepositoryIT {
    @Autowired
    private ProductRepository repository;

    @BeforeEach
    void setup() {
        var first = Product.builder()
            .category("category")
            .name("name")
            .quantity(0)
            .available(false)
            .build();

        var second = Product.builder()
            .category("category")
            .name("name")
            .quantity(0)
            .available(false)
            .build();

        repository.saveAll(List.of(first, second));
    }

    @Test
    void shouldIdBeIncremented() {
        var products = repository.findByCategory("category");

        assertThat(products.get(0).getId()).isEqualTo(1L);
        assertThat(products.get(1).getId()).isEqualTo(2L);
    }

    @Test
    void shouldSearchByCategory() {
        var products = repository.findByCategory("category");
        var first = products.getFirst();

        assertThat(products).hasSize(2);
        assertThat(products).isInstanceOf(List.class);
        assertThat(first).isInstanceOf(Product.class);

        assertThat(first.getName()).isNotNull();
        assertThat(first.getQuantity()).isNotNull();
        assertThat(first.getAvailable()).isNotNull();
    }
}
