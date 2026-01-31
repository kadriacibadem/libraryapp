package com.example.libraryapp.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class BookResponse {
    private String title;
    private BigDecimal price;
    @JsonProperty("ISBN13")
    private String isbn13;
    private PublisherResponse publisherResponse;
    private String authorNameSurname;

    public BookResponse(String title, BigDecimal price, String isbn13, PublisherResponse publisherResponse, String authorNameSurname) {
        this.title = title;
        this.price = price;
        this.isbn13 = isbn13;;
        this.publisherResponse = publisherResponse;
        this.authorNameSurname = authorNameSurname;
    }

}
