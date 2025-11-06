package com.example.module11.book;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CreateBookDto(
        @NotNull
        @Size(min = 3, max = 100)
        String title,

        @NotNull
        @Min(1900)
        Integer publicationYear,

        @NotNull
        @Size(min = 3, max = 100)
        String author
) {
  }