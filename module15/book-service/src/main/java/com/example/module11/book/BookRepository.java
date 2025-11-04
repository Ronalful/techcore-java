package com.example.module11.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByAuthor_Name(String name);

    Optional<Book> findByTitleAndAuthor_Name(String title, String name);

    @Query("select b from Book b join fetch b.author")
    List<Book> findAllFetch();

    @Query("SELECT b FROM Book b WHERE lower(b.title) LIKE lower(concat('%', :searchText, '%')) ORDER BY b.publicationYear DESC")
    List<Book> findBySearchText(String searchText);
}
