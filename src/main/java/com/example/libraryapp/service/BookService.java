package com.example.libraryapp.service;

import com.example.libraryapp.dto.request.BookRequestDto;
import com.example.libraryapp.entity.Book;

import java.util.List;

public interface BookService {
    Book save(Book book);
    Book update(Book book);
    void delete(Book book);
    Book findByTitle(String title);
    List<Book> findAll();
    Book createBookFromDto(BookRequestDto bookRequestDto);
    List<Book> findByBooksStartWithA();
    Book updateBook(BookRequestDto bookRequestDto);
    void deleteBook(String isbn13);
    Book findById(Long id);
}
