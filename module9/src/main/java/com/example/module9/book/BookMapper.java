package com.example.module9.book;

import com.example.module9.author.Author;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "author", source = "author")
    Book toBookWithAuthor(CreateBookDto dto, Author author);

    BookDto fromBook(Book book);
}
