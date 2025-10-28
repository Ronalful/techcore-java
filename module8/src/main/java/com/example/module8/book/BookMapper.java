package com.example.module8.book;

import com.example.module8.author.Author;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {
    Book toBookWithAuthor(CreateBookDto dto, Author author);

    BookDto fromBook(Book book);
}
