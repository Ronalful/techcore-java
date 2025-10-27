package com.example.module6advanced.dto;

public record CreateReviewDto(
        Long productId,
        int rating,
        String comment,
        String author
) {
}
