package com.example.labweek5.controller;

//import com.example.labweek5.exception.InvalidApiKeyEx;
import com.example.labweek5.models.Product;
import com.example.labweek5.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.apache.logging.log4j.util.StringBuilders.equalsIgnoreCase;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    private final String API_KEY = "123456";

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    private void apiKeyCheck(String apiKey) {
        if (!apiKey.equals(API_KEY)) {
            throw new RuntimeException("Invalid or missing API-Key!!");
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product createNewProduct(@RequestHeader("API-KEY") String apiKey, @Valid @RequestBody Product product) {
        apiKeyCheck(apiKey);
        return productService.addNewProduct(product);
    }

    @GetMapping
    public List<Product> getAllProducts(@RequestHeader("API-KEY") String apiKey) {
        apiKeyCheck(apiKey);
        return productService.getAllProducts();
    }

    @GetMapping("/{name}")
    public Product getProductByName(@RequestHeader("API-KEY") String apiKey, @Valid @PathVariable String name) {
        apiKeyCheck(apiKey);
        return productService.getProductByName(name);
    }

    @PutMapping("/{name}")
    public Product updateProduct(@RequestHeader("API-KEY") String apiKey, @Valid @PathVariable String name, @RequestBody Product updatedProduct) {
        apiKeyCheck(apiKey);
        return productService.updateProduct(name, updatedProduct);
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deleteProduct(@RequestHeader("API-KEY") String apiKey, @PathVariable String name) {
        apiKeyCheck(apiKey);
        productService.deleteProduct(name);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/category/{category}")
    public List<Product> getByCategory(@RequestHeader("API-KEY") String apiKey, @Valid @PathVariable String category) {
        apiKeyCheck(apiKey);
        return productService.getProductByCategory(category);
    }

    @GetMapping("/price")
    public List<Product> getByPriceRange(@RequestHeader("API-KEY") String apiKey, @Valid @RequestParam long min, @Valid @RequestParam long max) {
        apiKeyCheck(apiKey);
        return productService.getProductsByPriceRange(min, max);
    }

}

