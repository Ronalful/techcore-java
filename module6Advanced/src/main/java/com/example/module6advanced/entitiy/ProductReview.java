package com.example.module6advanced.entitiy;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "reviews")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductReview {
    private String id;
    private Long productId;
    private int rating;
    private String comment;
    private String author;
}
