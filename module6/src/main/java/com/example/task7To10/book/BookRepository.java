package com.example.task7To10.book;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByAuthor_Name(String name);

    Optional<Book> findByTitleAndAuthor_Name(String title, String name);
}
