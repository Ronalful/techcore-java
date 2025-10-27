package com.example.module6advanced.repository;

import com.example.module6advanced.entitiy.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
