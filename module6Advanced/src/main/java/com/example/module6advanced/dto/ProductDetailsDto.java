package com.example.module6advanced.dto;

import com.example.module6advanced.entitiy.ProductReview;

import java.util.List;

public record ProductDetailsDto(
        Long id,
        String name,
        Double price,
        List<ProductReview> reviews
) {
}
