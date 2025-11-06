package com.example.module11.author;

import java.io.Serializable;

public record AuthorDto (
        Long id,
        String name
) implements Serializable {
}
