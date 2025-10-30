package com.example.module10.book;


import com.example.module10.author.AuthorDto;

public record BookDto(
        Long id,
        String title,
        Integer publicationYear,
        AuthorDto author
) {
}
