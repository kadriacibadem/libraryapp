package com.example.libraryapp.mapper;

import com.example.libraryapp.dto.response.BookResponse;
import com.example.libraryapp.dto.response.PublisherResponse;
import com.example.libraryapp.entity.Book;
import com.example.libraryapp.entity.Publisher;

public class BookMapper {

    public static BookResponse toResponse(Book book){
        if(book == null) return null;

        Publisher publisher = book.getPublisher();

        return new BookResponse(
                book.getTitle(),
                book.getPrice(),
                book.getISBN13(),
                publisher == null ? null : new PublisherResponse(
                        publisher.getPublisherName()
                )
        );
    }
}
