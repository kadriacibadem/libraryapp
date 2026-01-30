package com.example.libraryapp.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PublisherResponse {
    private String publisherName;

    public PublisherResponse(String publisherName) {
        this.publisherName = publisherName;
    }
}
