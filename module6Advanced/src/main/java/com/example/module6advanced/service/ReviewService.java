package com.example.module6advanced.service;

import com.example.module6advanced.dto.CreateReviewDto;
import com.example.module6advanced.entitiy.ProductReview;
import com.example.module6advanced.repository.ProductRepository;
import com.example.module6advanced.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final ProductService productService;

    public ProductReview addReview(CreateReviewDto request) {
        var product = productService.findById(request.productId());
        return reviewRepository.save(
                ProductReview.builder()
                        .productId(product.getId())
                        .rating(request.rating())
                        .comment(request.comment())
                        .author(request.author())
                        .build()
        );
    }

    public List<ProductReview> getReviewsForProduct(Long productId) {
        var product = productService.findById(productId);
        return reviewRepository.findByProductId(product.getId());
    }
}
