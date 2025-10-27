package com.example.module6advanced.service;

import com.example.module6advanced.dto.ProductDetailsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductDetailsService {
    private final ProductService productService;
    private final ReviewService reviewService;

    public ProductDetailsDto getProductDetails(Long id) {
        var product = productService.findById(id);
        var reviews = reviewService.getReviewsForProduct(id);
        return new ProductDetailsDto(
                id,
                product.getName(),
                product.getPrice(),
                reviews
        );
    }
}
