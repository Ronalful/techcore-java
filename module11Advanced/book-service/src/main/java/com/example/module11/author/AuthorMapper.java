package com.example.module11.author;


import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    AuthorDto fromAuthor(Author author);
    Author toAuthor(CreateAuthorDto authorDto);
}
