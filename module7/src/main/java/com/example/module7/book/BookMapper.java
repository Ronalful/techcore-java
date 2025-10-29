package com.example.module7.book;

import com.example.module7.author.Author;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


//Task 10
// Этот код был убран и заменен
//@Service
//public class BookMapper {
//    public Book toBookWithAuthor(CreateBookDto request, Author author) {
//        return Book.builder()
//                .title(request.title())
//                .publicationYear(request.publicationYear())
//                .author(author)
//                .build();
//    }
//
//    public BookDto fromBook(Book book) {
//        return new BookDto(
//                book.getId(),
//                book.getTitle(),
//                book.getPublicationYear(),
//                new AuthorDto(
//                        book.getAuthor().getId(),
//                        book.getAuthor().getName()
//                )
//        );
//    }
//}

@Mapper(componentModel = "spring")
public interface BookMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "author", source = "author")
    Book toBookWithAuthor(CreateBookDto dto, Author author);

    BookDto fromBook(Book book);
}
