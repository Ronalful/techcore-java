package com.example.module11.book;

import com.example.module11.author.Author;
import com.example.module11.author.AuthorDto;
import com.example.module11.author.AuthorRepository;
import com.example.module11.notification.NotificationClient;
import com.example.module11.notification.NotificationClientOpenFeign;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;
    @Mock
    private PagingBookRepository pagingRepository;
    @Mock
    private AuthorRepository authorRepository;
    @Mock
    private BookMapper mapper;
    @Mock
    private NotificationClient notificationClient;
    @Mock
    NotificationClientOpenFeign notificationClientOpenFeign;

    private Book testBook;
    private BookDto testBookDto;
    private Author testAuthor;


    @BeforeEach
    void setUp() {
        bookService = new BookService(
                bookRepository,
                pagingRepository,
                authorRepository,
                mapper,
                notificationClient,
                notificationClientOpenFeign
        );

        testAuthor = Author.builder()
                .id(1L)
                .name("John Doe")
                .build();

        testBook = Book.builder()
                .id(1L)
                .title("Test Book")
                .publicationYear(2025)
                .author(testAuthor)
                .build();

        testBookDto = new BookDto(
                1L,
                "Test Book",
                2025,
                new AuthorDto(
                        testAuthor.getId(),
                        testAuthor.getName()
                )
        );
    }

    //Task 3
    @Test
    public void testFindBookById() {
        Mockito.when(bookRepository.findById(1L)).thenReturn(Optional.of(testBook));
        Mockito.when(mapper.fromBook(testBook)).thenReturn(testBookDto);

        var result = bookService.findBookById(1L);

        Assertions.assertEquals(testBookDto, result);
    }
}