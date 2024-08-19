package ccmello.simplestore;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

public class ProcuraProdutoPorCategoria {
    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    private String response;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private JsonNode responseAsJsonNode;

    @Quando("o cliente procurar por {string}")
    public void oClienteProcurarPor(String categoria) throws JsonProcessingException {
        var url = "http://localhost:%d/product?category=%s".formatted(port, categoria);

        response = restTemplate.getForObject(url, String.class);
        responseAsJsonNode = objectMapper.readTree(response);
    }

    @Entao("uma lista de produtos deve aparecer com produtos pertencentes a {string}")
    public void umaListaDeProdutosDeveAparecerComProdutosPertencentesA(String categoria) {
        var fieldValues = responseAsJsonNode.findValues("category");
        var fieldValuesAsList = fieldValues.stream().map(JsonNode::asText).toList();

        assertThat(fieldValues.size()).isEqualTo(3);
        assertThat(fieldValuesAsList).contains(categoria);
    }

    @E("cada produto mostrado aparecera com {string}, {string} e {string}")
    public void cadaProdutoMostradoApareceraComE(String nome, String quantidade, String disponivelAVenda) {

    }
}
