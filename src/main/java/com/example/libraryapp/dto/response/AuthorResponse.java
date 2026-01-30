package com.example.libraryapp.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AuthorResponse {
    private String authorNameSurname;
    private List<BookResponse> bookResponses;

    public AuthorResponse(String authorNameSurname, List<BookResponse> bookResponses) {
        this.authorNameSurname = authorNameSurname;
        this.bookResponses = bookResponses;
    }
}
