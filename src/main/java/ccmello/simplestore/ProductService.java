package ccmello.simplestore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public List<Object> searchByCategory(String value) {

        return repository.findByCategory(value);
    }
}
