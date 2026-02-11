package com.example.libraryapp.mapper;

import com.example.libraryapp.dto.response.BookResponse;
import com.example.libraryapp.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {PublisherMapperStruct.class})
public interface BookMapperStruct {
    BookMapperStruct INSTANCE = Mappers.getMapper(BookMapperStruct.class);

    @Mapping(target = "title", source = "book.title")
    @Mapping(target = "price", source = "book.price")
    @Mapping(target = "isbn13", source = "book.ISBN13")
    @Mapping(target = "publisherResponse", source = "book.publisher")
    @Mapping(target = "authorNameSurname", source = "book.author.authorNameSurname")
    BookResponse toResponse(Book book);
}
