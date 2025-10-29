package com.example.module9.book;

import com.example.module9.author.Author;
import com.example.module9.author.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    //Task 6
    @Test
    void testSaveAndFindBookById() {
        Author author = Author.builder()
                .name("John Doe")
                .build();
        author = authorRepository.save(author);

        Book book = Book.builder()
                .title("test")
                .publicationYear(2025)
                .author(author)
                .build();
        book = bookRepository.save(book);

        Optional<Book> foundBook = bookRepository.findById(book.getId());

        Assertions.assertThat(foundBook).isPresent();
        Assertions.assertThat(foundBook.get().getTitle()).isEqualTo("test");
        Assertions.assertThat(foundBook.get().getPublicationYear()).isEqualTo(2025);
        Assertions.assertThat(foundBook.get().getAuthor().getName()).isEqualTo("John Doe");
    }
}