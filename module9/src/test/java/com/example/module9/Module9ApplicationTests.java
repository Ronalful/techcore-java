package com.example.module9;

import com.example.module9.author.AuthorDto;
import com.example.module9.author.CreateAuthorDto;
import com.example.module9.book.BookDto;
import com.example.module9.book.CreateBookDto;
import com.example.module9.jwt.JwtTokenProvider;
import com.example.module9.user.Role;
import com.example.module9.user.User;
import com.example.module9.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class Module9ApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private JwtTokenProvider tokenProvider;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    private String baseUrl() {
        return "http://localhost:" + port + "/api";
    }

    //Task 9
    @Test
    void testCreateBook() {
        userRepository.save(User.builder()
                .username("user")
                .password(passwordEncoder.encode("password"))
                .role(Role.USER)
                .build());
        var token = tokenProvider.generateToken("user");
        var requestBook = new CreateBookDto(
                "Test Book",
                2025,
                "Jon Doe"
        );

        var requestAuthor = new CreateAuthorDto(
                "Jon Doe"
        );

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);

        HttpEntity<CreateAuthorDto> requestAuthorEntity = new HttpEntity<>(requestAuthor, headers);
        HttpEntity<CreateBookDto> requestBookEntity = new HttpEntity<>(requestBook, headers);

        ResponseEntity<AuthorDto> postAuthorResponse = restTemplate.postForEntity(
                baseUrl() + "/authors",
                requestAuthorEntity,
                AuthorDto.class
        );

        ResponseEntity<BookDto> postBookResponse = restTemplate.postForEntity(
                baseUrl() + "/books",
                requestBookEntity,
                BookDto.class
        );

        assertThat(postAuthorResponse.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        AuthorDto createAuthor = postAuthorResponse.getBody();
        assertThat(createAuthor).isNotNull();
        assertThat(createAuthor.name()).isNotNull();
        assertThat(createAuthor.name()).isEqualTo("Jon Doe");

        assertThat(postBookResponse.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        BookDto createdBook = postBookResponse.getBody();
        assertThat(createdBook).isNotNull();
        assertThat(createdBook.title()).isNotNull();
        assertThat(createdBook.title()).isEqualTo("Test Book");
    }
}
