package com.example.module6advanced.controller;

import com.example.module6advanced.dto.CreateCategoryDto;
import com.example.module6advanced.entitiy.Category;
import com.example.module6advanced.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService service;

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody CreateCategoryDto request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.createCategory(request));
    }

    @GetMapping
    public ResponseEntity<List<Category>> findCategories() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.findAll());
    }
}
