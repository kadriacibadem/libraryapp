package com.example.libraryapp.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class BookRequestDto {

    @Schema(
            description = "Kitap ismi", example = "Effective Java"
    )
    @NotEmpty(message = "Kitap ismi boş olamaz")
    private String title;
    @Schema(
            description = "Kitap fiyatı", example = "45.99"
    )
    @NotEmpty(message = "Kitap fiyatı boş olamaz")
    private BigDecimal price;
    @Schema(
            description = "Kitap ISBN13 numarası", example = " "
    )
    @NotEmpty(message = "Kitap ISBN13 numarası boş olamaz")
    @JsonProperty("ISBN13")
    private String isbn13;
    @Schema(
            description = "Yayıncı ismi", example = "Addison-Wesley"
    )
    @NotEmpty(message = "Yayıncı ismi boş olamaz")
    private String publisherName;
    @Schema(
            description = "Yazar ismi ve soyismi", example = "Joshua Bloch"
    )
    @NotEmpty(message = "Yazar ismi ve soyismi boş olamaz")
    private String authorNameSurname;
}
