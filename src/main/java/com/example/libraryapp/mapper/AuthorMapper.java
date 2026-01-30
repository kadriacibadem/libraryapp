package com.example.libraryapp.mapper;

import com.example.libraryapp.dto.response.AuthorResponse;
import com.example.libraryapp.entity.Author;

public class AuthorMapper {
    public static AuthorResponse toResponse(Author author) {
        if (author == null) return null;

        return new AuthorResponse(
                author.getAuthorNameSurname(),
                author.getBooks().stream().map(
                        BookMapper::toResponse
                ).toList()
        );
    }
}
