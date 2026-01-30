package com.example.libraryapp.client.service;

import com.example.libraryapp.client.response.BookSearchResponse;

import java.util.List;

public interface GoogleBookService {
    List<BookSearchResponse> searchBooks(String bookName);
}
