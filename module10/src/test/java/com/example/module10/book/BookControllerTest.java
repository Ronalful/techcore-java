package com.example.module10.book;

import com.example.module10.author.AuthorDto;
import com.example.module10.author.AuthorNotFoundException;
import com.example.module10.jwt.JwtTokenFilter;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookController.class)
@AutoConfigureMockMvc(addFilters = false)
class BookControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @MockitoBean
    private BookService bookService;
    @MockitoBean
    private JwtTokenFilter jwtTokenFilter;

    //Task 7
    @Test
    public void testGetBookById() throws Exception {
        var testBookDto = new BookDto(
                1L,
                "Test Book",
                2025,
                new AuthorDto(
                        1L,
                        "Jon Doe"
                )
        );

        Mockito.when(bookService.findBookById(1L)).thenReturn(testBookDto);

        mockMvc.perform(get("/api/books/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Test Book"));
    }

    //Task 8
    @Test
    public void testCorrectAddBookWithStatus() throws Exception {
        var testAuthorDto = new AuthorDto(
                1L,
                "Jon Doe"
        );
        var testBookDto = new BookDto(
                1L,
                "Test Book",
                2025,
                testAuthorDto
        );
        var testCreateBookDto = new CreateBookDto(
                "Test Book",
                2025,
                "Jon Doe"
        );

        Mockito.when(bookService.createBook(testCreateBookDto)).thenReturn(testBookDto);

        mockMvc.perform(post("/api/books")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(testCreateBookDto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.title").value("Test Book"))
                .andExpect(jsonPath("$.publicationYear").value("2025"))
                .andExpect(jsonPath("$.author.id").value(1))
                .andExpect(jsonPath("$.author.name").value("Jon Doe"));
    }

    //Task 8
    @Test
    public void testIncorrectAddBookWithStatus() throws Exception {
        var testCreateBookDto = new CreateBookDto(
                "Test Book",
                2025,
                "Jon Doe"
        );

        Mockito.when(bookService.createBook(testCreateBookDto)).thenThrow(AuthorNotFoundException.class);

        mockMvc.perform(post("/api/books")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(testCreateBookDto)))
                .andExpect(status().isNotFound());
    }
}