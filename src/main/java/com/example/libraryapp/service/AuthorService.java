package com.example.libraryapp.service;

import com.example.libraryapp.dto.request.BookRequestDto;
import com.example.libraryapp.entity.Author;
import com.example.libraryapp.entity.Book;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    Author save(Author author);
    Author update(Author author);
    void delete(Author author);
    Author createAuthor(BookRequestDto bookRequestDto, Book book);
    Optional<Author> findByAuthorNameSurname(String authorNameSurname);
    List<Author> findAll();
}
