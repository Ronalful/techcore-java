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
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("newtest")
public class Module9ApplicationTestsWithTestContainers {

    @Container
    private static final PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:16.3")
            .withDatabaseName("testdb")
            .withUsername("test")
            .withPassword("test");

    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
    }

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

    @Test
    void testCreateBook() {
        userRepository.save(User.builder()
                .username("user")
                .password(passwordEncoder.encode("password"))
                .role(Role.USER)
                .build());

        var token = tokenProvider.generateToken("user");
        var requestBook = new CreateBookDto("Test Book", 2025, "Jon Doe");
        var requestAuthor = new CreateAuthorDto("Jon Doe");

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);

        var requestAuthorEntity = new HttpEntity<>(requestAuthor, headers);
        var requestBookEntity = new HttpEntity<>(requestBook, headers);

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
        AuthorDto createdAuthor = postAuthorResponse.getBody();
        assertThat(createdAuthor).isNotNull();
        assertThat(createdAuthor.name()).isEqualTo("Jon Doe");

        assertThat(postBookResponse.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        BookDto createdBook = postBookResponse.getBody();
        assertThat(createdBook).isNotNull();
        assertThat(createdBook.title()).isEqualTo("Test Book");
    }
}
