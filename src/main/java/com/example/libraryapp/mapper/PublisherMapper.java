package com.example.libraryapp.mapper;

import com.example.libraryapp.dto.response.PublisherResponse;
import com.example.libraryapp.entity.Publisher;

public class PublisherMapper {
    public static PublisherResponse toResponse(Publisher publisher) {
        if (publisher == null) return null;

        return new PublisherResponse(
                publisher.getPublisherName()
        );
    }
}
