package com.example.module9.book;

import com.example.module9.author.Author;
import com.example.module9.author.AuthorNotFoundException;
import com.example.module9.author.AuthorRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final PagingBookRepository pagingRepository;
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

    public List<BookDto> getBooksBySearchText(String searchText) {
        return bookRepository.findBySearchText(searchText).stream()
                .map(mapper::fromBook)
                .toList();
    }

    @Transactional
    public BookDto createBookWithAuthor(CreateBookDto request) {
        var author = authorRepository.save(Author.builder()
                .name(request.author())
                .build());
        int a = 2 / 0; // Тут будет ошибка
        var book = bookRepository.save(mapper.toBookWithAuthor(request, author));
        return mapper.fromBook(book);
    }

    public Page<BookDto> getAllBooks(Pageable pageable) {
        return pagingRepository.findAll(pageable)
                .map(mapper::fromBook);
    }
}
