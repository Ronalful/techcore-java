package com.example.module9.book;

import com.example.module9.author.AuthorDto;
import com.example.module9.jwt.JwtTokenFilter;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookController.class)
@AutoConfigureMockMvc(addFilters = false)
class BookControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private BookService bookService;
    @MockitoBean
    private JwtTokenFilter jwtTokenFilter;

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
}