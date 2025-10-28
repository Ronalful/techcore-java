package com.example.module7.book;


import com.example.module7.author.AuthorDto;

public record BookDto(
        Long id,
        String title,
        Integer publicationYear,
        AuthorDto author
) {
}
