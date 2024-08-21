package ccmello.simplestore.e2e;

import io.cucumber.java.After;

public class Hooks {
    @After
    public void cleanUp() {}

    // Cucumber supported hooks
    // @Before     => public void init()
    // @After      => public void cleanUp()
    // @BeforeStep => public void beforeStep()
    // @AfterStep  => public void afterStep()
}