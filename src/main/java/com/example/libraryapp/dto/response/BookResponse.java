package com.example.libraryapp.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class BookResponse {
    private String title;
    private BigDecimal price;
    private String ISBN13;;
    private PublisherResponse publisherResponse;

    public BookResponse(String title, BigDecimal price, String ISBN13, PublisherResponse publisherResponse) {
        this.title = title;
        this.price = price;
        this.ISBN13 = ISBN13;;
        this.publisherResponse = publisherResponse;
    }

}
