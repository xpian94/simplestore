package ccmello.simplestore;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @GetMapping(value = "/product", produces = MediaType.APPLICATION_JSON_VALUE)
    String searchByCategory(@RequestParam(name = "category") String category) {
        return """
            [
                {
                    "category": "Utensilios",
                    "name": "Kit 12 Facas",
                    "quantity": 3,
                    "available": true
                },
                {
                    "category": "Utensilios",
                    "name": "Colher de Silicone",
                    "quantity": 12,
                    "available": true
                },
                {
                    "category": "Utensilios",
                    "name": "Ralador 4 faces Inox",
                    "quantity": 0,
                    "available": false
                }
            ]
            """;
    }
}
