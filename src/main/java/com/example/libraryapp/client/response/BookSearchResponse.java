package com.example.libraryapp.client.response;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("ISBN13")
    private String isbn13;
    private String publisherName;
    private String authorNameSurname;
}
