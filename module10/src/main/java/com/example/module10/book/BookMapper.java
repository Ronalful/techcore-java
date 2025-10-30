package com.example.module10.book;

import com.example.module10.author.Author;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "author", source = "author")
    Book toBookWithAuthor(CreateBookDto dto, Author author);

    BookDto fromBook(Book book);
}
