package com.microservice.product.controllers;

import com.microservice.product.models.dtos.CreateProductRequest;
import com.microservice.product.models.dtos.ProductResponse;
import com.microservice.product.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductResponse> getAllProducts() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public ProductResponse getProductById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @GetMapping("/category/{categoryId}")
    public List<ProductResponse> getProductsByCategoryId(@PathVariable Long categoryId) {
        return productService.findAllByCategoryId(categoryId);
    }

    @PostMapping
    public ResponseEntity<ProductResponse> saveProduct(@Valid @RequestBody CreateProductRequest createProductRequest) {
        ProductResponse productResponse = productService.save(createProductRequest);
        return ResponseEntity.created(URI.create("/api/v1/products/" + productResponse.getId())).body(productResponse);
    }

    @PutMapping("/{id}")
    public ProductResponse updateProduct(@PathVariable Long id, @Valid @RequestBody CreateProductRequest createProductRequest) {
        return productService.update(id, createProductRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Long id) {
        productService.deleteById(id);
    }
}
