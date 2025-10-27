package com.example.module6advanced.controller;

import com.example.module6advanced.dto.CreateReviewDto;
import com.example.module6advanced.entitiy.ProductReview;
import com.example.module6advanced.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService service;

    @PostMapping
    public ResponseEntity<ProductReview> addReview(@RequestBody CreateReviewDto request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.addReview(request));
    }

    @GetMapping("/{productId}")
    public ResponseEntity<List<ProductReview>> getReviewsForProduct(@PathVariable Long productId) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.getReviewsForProduct(productId));
    }
}
