package com.example.module11.book;


import com.example.module11.author.AuthorDto;

import java.io.Serializable;

public record BookDto (
        Long id,
        String title,
        Integer publicationYear,
        AuthorDto author
) implements Serializable {
}
