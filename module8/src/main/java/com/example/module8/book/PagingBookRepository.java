package com.example.module8.book;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface PagingBookRepository extends PagingAndSortingRepository<Book, Long> {

}
