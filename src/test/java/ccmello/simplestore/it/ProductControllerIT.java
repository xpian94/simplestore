package ccmello.simplestore.it;

import ccmello.simplestore.Product;
import ccmello.simplestore.ProductController;
import ccmello.simplestore.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class ProductControllerIT {
    @Autowired
    private ProductController controller;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService service;

    @Test
    void shouldCallRequestByCategory() throws Exception {
        var expectedProduct = Product.builder()
            .id(1L)
            .category("acategory")
            .name("aname")
            .quantity(0)
            .available(false)
            .build();

        when(service.searchByCategory("acategory")).thenReturn(List.of(expectedProduct));

        var result = mockMvc
            .perform(get("/product").queryParam("category", "acategory"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andReturn();

        var objectMapper = new ObjectMapper();
        var jsonNode = objectMapper.readTree(result.getResponse().getContentAsString());
        var elements = jsonNode.path("elements");
        var firstElement = elements.get(0);

        assertThat(elements).isNotNull();
        assertThat(elements).hasSize(1);

        assertThat(firstElement.get("id").asLong()).isEqualTo(expectedProduct.getId());
        assertThat(firstElement.get("category").asText()).isEqualTo(expectedProduct.getCategory());
        assertThat(firstElement.get("name").asText()).isEqualTo(expectedProduct.getName());
        assertThat(firstElement.get("quantity").asInt()).isEqualTo(expectedProduct.getQuantity());
        assertThat(firstElement.get("available").asBoolean()).isEqualTo(expectedProduct.getAvailable());

        verify(service).searchByCategory("acategory");
    }
}
