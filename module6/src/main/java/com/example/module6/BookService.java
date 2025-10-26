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
                        .build()
        );
    }

    public Book updateBook(UpdateBookDto request) {
        var book = repository.findById(request.id())
                .orElseThrow(() -> new BookNotFoundException("Book not found with id " + request.id()));
        book.setTitle(request.title());
        book.setYear(request.year());
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
}
