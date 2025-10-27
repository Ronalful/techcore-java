package com.example.module6advanced.repository;

import com.example.module6advanced.entitiy.ProductReview;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReviewRepository extends MongoRepository<ProductReview, String> {
}
