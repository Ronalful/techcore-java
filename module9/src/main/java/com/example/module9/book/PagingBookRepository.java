package com.example.module9.book;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface PagingBookRepository extends PagingAndSortingRepository<Book, Long> {

}
