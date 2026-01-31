package com.example.libraryapp.service;

import com.example.libraryapp.dto.request.BookRequestDto;
import com.example.libraryapp.entity.Publisher;

import java.util.List;
import java.util.Optional;

public interface PublisherService {
    Publisher save(Publisher publisher);
    Publisher update(Publisher publisher);
    Publisher update(Publisher publisher, BookRequestDto bookRequestDto);
    void delete(Publisher publisher);
    Optional<Publisher> findByPublisherName(String publisherName);
    Publisher createPublisher(BookRequestDto bookRequestDto);
    List<Publisher> findAll();
    Publisher findById(Long id);
}
