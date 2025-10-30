package com.example.module10.book;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface PagingBookRepository extends PagingAndSortingRepository<Book, Long> {

}
