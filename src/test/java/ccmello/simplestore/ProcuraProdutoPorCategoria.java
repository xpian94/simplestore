package ccmello.simplestore;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

public class ProcuraProdutoPorCategoria {
    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private JsonNode responseAsJsonNode;

    private void findByFieldNameAndValueAndVerify(String fieldName, String fieldValue) {
        var fieldValues = responseAsJsonNode.findValues(fieldName);
        var fieldValuesAsList = fieldValues.stream().map(JsonNode::asText).toList();

        assertThat(fieldValues.size()).isEqualTo(3);
        assertThat(fieldValuesAsList).contains(fieldValue);
    }

    @Quando("o cliente procurar por {string}")
    public void oClienteProcurarPor(String categoria) throws JsonProcessingException {
        var url = "http://localhost:%d/product?category=%s".formatted(port, categoria);
        var response = restTemplate.getForObject(url, String.class);
        responseAsJsonNode = objectMapper.readTree(response);
    }

    @Entao("uma lista de produtos deve aparecer com produtos pertencentes a {string}")
    public void umaListaDeProdutosDeveAparecerComProdutosPertencentesA(String categoria) {
        findByFieldNameAndValueAndVerify("category", categoria);
    }

    @E("cada produto mostrado aparecera com {string}, {string} e {string}")
    public void cadaProdutoMostradoApareceraComE(String nome, String quantidade, String disponivelAVenda) {
        findByFieldNameAndValueAndVerify("name", nome);
        findByFieldNameAndValueAndVerify("quantity", quantidade);
        findByFieldNameAndValueAndVerify("available", String.valueOf(disponivelAVenda.equals("Sim")));
    }
}
