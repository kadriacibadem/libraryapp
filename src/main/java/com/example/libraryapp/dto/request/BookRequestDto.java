package com.example.libraryapp.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class BookRequestDto {
    private String title;
    private BigDecimal price;
    private String ISBN13;;
    private String publisherName;
    private String authorNameSurname;
}
