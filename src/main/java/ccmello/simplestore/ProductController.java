package ccmello.simplestore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProductController {
    @Autowired
    private ProductService service;

    @RequestMapping(method = RequestMethod.GET, value = "/product", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ProductSearchByCategoryResponse searchByCategory(@RequestParam(name = "category") String category) {
        var products = service.searchByCategory(category);

        return ProductSearchByCategoryResponse.builder()
            .elements(products)
            .build();
    }
}
