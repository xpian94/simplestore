package ccmello.simplestore.e2e;

import ccmello.simplestore.ProductRepository;
import io.cucumber.java.After;
import org.springframework.beans.factory.annotation.Autowired;

public class Hooks {
    @Autowired
    private ProductRepository productRepository;

    @After
    public void cleanUp() {
        productRepository.deleteAll();
    }

    // Cucumber supported hooks
    // @Before     => public void init()
    // @After      => public void cleanUp()
    // @BeforeStep => public void beforeStep()
    // @AfterStep  => public void afterStep()
}