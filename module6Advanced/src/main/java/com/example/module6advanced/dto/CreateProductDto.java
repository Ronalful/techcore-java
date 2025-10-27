package com.example.module6advanced.dto;

public record CreateProductDto(
        String name,
        Double price,
        Long categoryId
) {
}