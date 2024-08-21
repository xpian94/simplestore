package ccmello.simplestore.ut;

import ccmello.simplestore.Product;
import ccmello.simplestore.ProductRepository;
import ccmello.simplestore.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
    @InjectMocks
    private ProductService service;

    @Mock
    private ProductRepository repository;

    @Test
    void shouldSearchByCategory() {
        var product = Product.builder().build();

        when(repository.findByCategory("category")).thenReturn(List.of(product));

        var found = service.searchByCategory("category");

        verify(repository).findByCategory("category");

        assertThat(found.size()).isEqualTo(1);
    }
}
