package com.example.module7.author;

import org.mapstruct.Mapper;

//Task 10
// Этот код был убран и заменен
//@Service
//public class AuthorMapper {
//    public AuthorDto fromAuthor(Author author) {
//        return new AuthorDto(
//                author.getId(),
//                author.getName()
//        );
//    }
//
//    public Author toAuthor(CreateAuthorDto request) {
//        return Author.builder()
//                .name(request.name())
//                .build();
//    }
//}

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    AuthorDto fromAuthor(Author author);
    Author toAuthor(CreateAuthorDto authorDto);
}
