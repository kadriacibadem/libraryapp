package com.example.libraryapp.client.service.impl;

import com.example.libraryapp.client.GoogleBooksClient;
import com.example.libraryapp.client.mapper.GoogleBookMapper;
import com.example.libraryapp.client.response.BookSearchResponse;
import com.example.libraryapp.client.response.GoogleBookResponse;
import com.example.libraryapp.client.service.GoogleBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GoogleBookServiceImpl implements GoogleBookService {

    private final GoogleBooksClient googleBooksClient;

    @Override
    public List<BookSearchResponse> searchBooks(String bookName) {
        GoogleBookResponse googleBookResponse = googleBooksClient.getBooks(bookName);
        return googleBookResponse.getItems()
                .stream()
                .map(GoogleBookMapper::toResponse)
                .toList();
    }
}
