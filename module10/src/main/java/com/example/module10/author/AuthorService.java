package com.example.module10.author;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final AuthorMapper mapper;

    public AuthorDto createAuthor(CreateAuthorDto request) {
        var author = authorRepository.save(
                mapper.toAuthor(request)
        );
        return mapper.fromAuthor(author);
    }

    public List<AuthorDto> getAllAuthors() {
        return authorRepository.findAll().stream()
                .map(mapper::fromAuthor)
                .toList();
    }
}
