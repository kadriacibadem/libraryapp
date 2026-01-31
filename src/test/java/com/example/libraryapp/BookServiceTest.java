package com.example.libraryapp;

import com.example.libraryapp.entity.Book;
import com.example.libraryapp.repository.BookRepo;
import com.example.libraryapp.service.BookService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.math.BigDecimal;

@SpringBootTest
public class BookServiceTest {
    @Autowired
    private BookService bookService;

    @MockitoBean
    private BookRepo bookRepo;

    @Test
    public void createBookTest(){
        Book book = new Book(1L, "Java", BigDecimal.ONE, "1234567890123", null, null);
        Mockito.when(bookRepo.save(book)).thenReturn(book);
        Book createdBook = bookService.save(book);
        assert createdBook != null;
        assert createdBook.getTitle().equals("Java");
    }
}
