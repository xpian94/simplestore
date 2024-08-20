package ccmello.simplestore;

import io.cucumber.java.After;
import org.springframework.beans.factory.annotation.Autowired;

public class Hooks {
    @Autowired
    private ProductRepository repo;

    @After
    public void cleanUp() {
        repo.deleteAll();
    }

    // Cucumber supported hooks
    // @Before     => public void init()
    // @After      => public void cleanUp()
    // @BeforeStep => public void beforeStep()
    // @AfterStep  => public void afterStep()
}