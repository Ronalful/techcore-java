package com.example.module6advanced.service;

import com.example.module6advanced.dto.CreateProductDto;
import com.example.module6advanced.dto.UpdateProductDto;
import com.example.module6advanced.entitiy.Product;
import com.example.module6advanced.repository.CategoryRepository;
import com.example.module6advanced.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public Product createProduct(CreateProductDto request) {
        var category = categoryRepository.findById(request.categoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));
        return productRepository.save(
                Product.builder()
                        .name(request.name())
                        .price(request.price())
                        .category(category)
                        .build()
        );
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public List<Product> searchProducts(String name, Long categoryId) {
        return productRepository.findByNameLikeAndCategoryId(name, categoryId);
    }

    @Cacheable(value = "products", key = "#id")
    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @CacheEvict(value = "products", key = "#request.id()")
    public Product updateProduct(UpdateProductDto request) {
        var product = productRepository.findById(request.id())
                .orElseThrow(() -> new RuntimeException("Product not found"));
        product.setName(request.name());
        product.setPrice(request.price());
        return productRepository.save(product);
    }

    @CacheEvict(value = "products", key = "#id")
    public void deleteProduct(Long id) {
        var product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        productRepository.delete(product);
    }
}
