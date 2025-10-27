package com.example.module6advanced.controller;

import com.example.module6advanced.dto.CreateProductDto;
import com.example.module6advanced.entitiy.Product;
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
}
