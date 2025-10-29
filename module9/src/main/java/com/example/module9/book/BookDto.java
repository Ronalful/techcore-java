package com.example.module9.book;


import com.example.module9.author.AuthorDto;

public record BookDto(
        Long id,
        String title,
        Integer publicationYear,
        AuthorDto author
) {
}
