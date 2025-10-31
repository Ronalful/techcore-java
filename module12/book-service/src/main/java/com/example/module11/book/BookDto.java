package com.example.module11.book;


import com.example.module11.author.AuthorDto;

public record BookDto(
        Long id,
        String title,
        Integer publicationYear,
        AuthorDto author
) {
}
