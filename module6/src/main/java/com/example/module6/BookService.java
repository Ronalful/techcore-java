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

    public Book findBookById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found with id " + id));
    }

    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    public void deleteBook(Long id) {
        repository.deleteById(id);
    }
}
