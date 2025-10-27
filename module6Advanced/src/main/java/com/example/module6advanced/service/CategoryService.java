package com.example.module6advanced.service;

import com.example.module6advanced.dto.CreateCategoryDto;
import com.example.module6advanced.entitiy.Category;
import com.example.module6advanced.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository repository;

    public Category createCategory(CreateCategoryDto request) {
        return repository.save(
                Category.builder()
                        .name(request.name())
                        .build()
        );
    }

    public List<Category> findAll() {
        return repository.findAll();
    }
}
