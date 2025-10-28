package com.example.module6advanced.repository;

import com.example.module6advanced.entitiy.ProductReview;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ReviewRepository extends MongoRepository<ProductReview, String> {
    //Task 9
    List<ProductReview> findByProductId(Long productId);
}
