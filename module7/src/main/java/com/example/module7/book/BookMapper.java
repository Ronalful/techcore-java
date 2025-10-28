package com.example.module7.book;

import com.example.module7.author.Author;
import com.example.module7.author.AuthorDto;
import org.springframework.stereotype.Service;

@Service
public class BookMapper {
    public Book toBookWithAuthor(CreateBookDto request, Author author) {
        return Book.builder()
                .title(request.title())
                .publicationYear(request.publicationYear())
                .author(author)
                .build();
    }

    public BookDto fromBook(Book book) {
        return new BookDto(
                book.getId(),
                book.getTitle(),
                book.getPublicationYear(),
                new AuthorDto(
                        book.getAuthor().getId(),
                        book.getAuthor().getName()
                )
        );
    }
}
