package com.example.task7To10.author;

import org.springframework.stereotype.Service;

@Service
public class AuthorMapper {
    public AuthorDto fromAuthor(Author author) {
        return new AuthorDto(
                author.getId(),
                author.getName()
        );
    }

    public Author toAuthor(CreateAuthorDto request) {
        return Author.builder()
                .name(request.name())
                .build();
    }
}
