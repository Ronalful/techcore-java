package com.example.module6;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository repository;

    public Book createBook(CreateBookDto request) {
        return repository.save(
                Book.builder()
                        .title(request.title())
                        .year(request.year())
                        .author(request.author())
                        .build()
        );
    }

    public Book updateBook(UpdateBookDto request) {
        var book = repository.findById(request.id())
                .orElseThrow(() -> new BookNotFoundException("Book not found with id " + request.id()));
        book.setTitle(request.title());
        book.setYear(request.year());
        book.setAuthor(request.author());
        return repository.save(book);
    }

    public Book findBookById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found with id " + id));
    }

    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    public void deleteBookById(Long id) {
        var book = repository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found with id " + id));
        repository.delete(book);
    }

    public List<Book> findBookAuthor(String author) {
        return repository.findByAuthor(author);
    }

    public Book findBookByTitleAndAuthor(String title, String author) {
        return repository.findByTitleAndAuthor(title, author)
                .orElseThrow(() -> new BookNotFoundException("Book not found with title " + title + " and author " + author));
    }
}
