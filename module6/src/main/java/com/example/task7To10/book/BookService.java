package com.example.task7To10.book;

import com.example.task7To10.author.AuthorNotFoundException;
import com.example.task7To10.author.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final BookMapper mapper;

    public BookDto createBook(CreateBookDto request) {
        var author = authorRepository.findByName(request.author())
                .orElseThrow(() -> new AuthorNotFoundException("Author not found"));
        var book = bookRepository.save(
                mapper.toBookWithAuthor(request, author)
        );
        return mapper.fromBook(book);
    }

    public BookDto updateBook(UpdateBookDto request) {
        var book = bookRepository.findById(request.id())
                .orElseThrow(() -> new BookNotFoundException("Book not found with id " + request.id()));
        var author = authorRepository.findByName(request.author())
                .orElseThrow(() -> new AuthorNotFoundException("Author not found"));
        book.setTitle(request.title());
        book.setPublicationYear(request.publicationYear());
        book.setAuthor(author);
        return mapper.fromBook(book);
    }

    public BookDto findBookById(Long id) {
        var book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found with id " + id));
        return mapper.fromBook(book);
    }

    public List<BookDto> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(mapper::fromBook)
                .toList();
    }

    public void deleteBookById(Long id) {
        var book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found with id " + id));
        bookRepository.delete(book);
    }

    public List<BookDto> findBookAuthor(String author) {
        return bookRepository.findByAuthor_Name(author).stream()
                .map(mapper::fromBook)
                .toList();
    }

    public BookDto findBookByTitleAndAuthor(String title, String author) {
        var book = bookRepository.findByTitleAndAuthor_Name(title, author)
                .orElseThrow(() -> new BookNotFoundException("Book not found with title " + title + " and author " + author));
        return mapper.fromBook(book);
    }

    public List<BookDto> getBooksIncorrect() {
        var books = bookRepository.findAll();
        for (var book : books) {
            System.out.println(book.getAuthor().getName());
        }
        return books.stream()
                .map(mapper::fromBook)
                .toList();
    }

    public List<BookDto> getBooksCorrect() {
        var books = bookRepository.findAllFetch();
        for (var book : books) {
            System.out.println(book.getAuthor().getName());
        }
        return books.stream()
                .map(mapper::fromBook)
                .toList();
    }
}
