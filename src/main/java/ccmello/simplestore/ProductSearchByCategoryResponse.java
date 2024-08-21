package ccmello.simplestore;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class ProductSearchByCategoryResponse {
    private List<Product> elements;
}
