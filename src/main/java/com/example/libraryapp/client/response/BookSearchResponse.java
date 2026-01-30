package com.example.libraryapp.client.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class BookSearchResponse {
    private String title;
    private BigDecimal price;
    private String ISBN13;
    private String publisherName;
    private String authorNameSurname;
}
