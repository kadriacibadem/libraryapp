package com.example.libraryapp.service;

import com.example.libraryapp.dto.request.BookRequestDto;
import com.example.libraryapp.entity.Book;
import com.example.libraryapp.entity.Publisher;

import java.util.List;

public interface BookService {
    Book save(Book book);
    Book update(Book book);
    void delete(Book book);
    List<Book> findAll();
    Book createBookFromDto(BookRequestDto bookRequestDto);
    List<Book> findByBooksStartWithA();
}
