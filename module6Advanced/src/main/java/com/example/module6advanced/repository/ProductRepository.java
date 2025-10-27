package com.example.module6advanced.repository;

import com.example.module6advanced.entitiy.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("select p from Product p where lower(p.name) like lower(concat('%', :name, '%')) " +
            "and p.category.id = :categoryId")
    List<Product> findByNameLikeAndCategoryId(String name, Long categoryId);
}
