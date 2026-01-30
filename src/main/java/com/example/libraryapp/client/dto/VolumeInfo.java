package com.example.libraryapp.client.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class VolumeInfo {
    private String title;
    private List<String> authors;
    private String publisher;
    private List<IndustryIdentifier> industryIdentifiers;
}
