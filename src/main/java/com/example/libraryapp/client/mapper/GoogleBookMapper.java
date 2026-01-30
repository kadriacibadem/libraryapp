package com.example.libraryapp.client.mapper;

import com.example.libraryapp.client.dto.IndustryIdentifier;
import com.example.libraryapp.client.dto.Item;
import com.example.libraryapp.client.response.BookSearchResponse;

import java.math.BigDecimal;

public class GoogleBookMapper {
    public static BookSearchResponse toResponse(Item item) {
        if (item == null || item.getVolumeInfo() == null) return null;

        String title = "";
        BigDecimal price = BigDecimal.ZERO;
        String isbn13 = "";
        String publisher = "";
        String author = "";

        title = item.getVolumeInfo().getTitle() != null ? item.getVolumeInfo().getTitle() : "";

        if(item.getVolumeInfo().getAuthors() != null){
            author = item.getVolumeInfo().getAuthors().getFirst();
        }

        publisher = item.getVolumeInfo().getPublisher() != null ? item.getVolumeInfo().getPublisher() : "";

        if(item.getVolumeInfo().getIndustryIdentifiers() != null && !item.getVolumeInfo().getIndustryIdentifiers().isEmpty()){
            isbn13 = item.getVolumeInfo().getIndustryIdentifiers().stream()
                    .filter(id -> "ISBN_13".equals(id.getType()))
                    .map(IndustryIdentifier::getIdentifier)
                    .findFirst()
                    .orElse("");
        }

        if (item.getSaleInfo() != null && item.getSaleInfo().getRetailPrice() != null) {
            price = item.getSaleInfo().getRetailPrice().getAmount() != null ? item.getSaleInfo().getRetailPrice().getAmount() : BigDecimal.ZERO;
        }

        return new BookSearchResponse(
                title,
                price,
                isbn13,
                publisher,
                author
        );
    }
}
