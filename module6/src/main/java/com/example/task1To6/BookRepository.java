package com.example.task1To6;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

//Task 3
public interface BookRepository extends JpaRepository<Book, Long> {

    //Task 6
    List<Book> findByAuthor(String author);

    //Task 6
    Optional<Book> findByTitleAndAuthor(String title, String author);
}
