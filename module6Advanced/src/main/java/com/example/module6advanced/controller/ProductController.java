package com.example.module6advanced.controller;

import com.example.module6advanced.dto.CreateProductDto;
import com.example.module6advanced.dto.ProductDetailsDto;
import com.example.module6advanced.dto.UpdateProductDto;
import com.example.module6advanced.entitiy.Product;
import com.example.module6advanced.service.ProductDetailsService;
import com.example.module6advanced.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;
    private final ProductDetailsService productDetailsService;

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody CreateProductDto request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.createProduct(request));
    }

    @GetMapping
    public ResponseEntity<List<Product>> findProducts() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.findAll());
    }

    //Task 2
    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchProducts(
            @RequestParam String name,
            @RequestParam Long categoryId
    ) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.searchProducts(name, categoryId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.findById(id));
    }

    @PutMapping
    public ResponseEntity<Product> updateProduct(@RequestBody UpdateProductDto request) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.updateProduct(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        service.deleteProduct(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    //Task 10
    @GetMapping("/{id}/details")
    public ResponseEntity<ProductDetailsDto> getProductDetails(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(productDetailsService.getProductDetails(id));
    }
}
