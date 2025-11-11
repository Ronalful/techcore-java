package com.example.module11.book;

import com.example.module11.author.Author;
import com.example.module11.kafka.BookCreatedEvent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "author", source = "author")
    Book toBookWithAuthor(CreateBookDto dto, Author author);

    BookDto fromBook(Book book);
    BookCreatedEvent toBookCreatedEvent(Book book);
}
