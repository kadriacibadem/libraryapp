package com.example.libraryapp;

import com.example.libraryapp.entity.Book;
import com.example.libraryapp.repository.BookRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class BookControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private BookRepo bookRepo;

    @Test
    void getAllBooksTest() throws Exception {
        Book book1 = new Book(1L, "Clean Code", BigDecimal.valueOf(29.99), "1234567890123", null, null);
        Book book2 = new Book(2L, "Kriptex", BigDecimal.valueOf(10.99), "9876543210987", null, null);

        List<Book> books = List.of(book1, book2);
        given(bookRepo.findAll()).willReturn(books);

        mockMvc.perform(get("/api/book/books").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Clean Code"))
                .andExpect(jsonPath("$[1].title").value("Kriptex"));

    }

}
