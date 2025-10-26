package com.example.task7To10.book;

import com.example.task7To10.author.AuthorDto;

public record BookDto(
        Long id,
        String title,
        Integer publicationYear,
        AuthorDto author
) {
}
