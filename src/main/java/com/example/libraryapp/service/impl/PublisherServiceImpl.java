package com.example.libraryapp.service.impl;

import com.example.libraryapp.dto.request.BookRequestDto;
import com.example.libraryapp.entity.Publisher;
import com.example.libraryapp.repository.PublisherRepo;
import com.example.libraryapp.service.PublisherService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class PublisherServiceImpl implements PublisherService {

    private final PublisherRepo repo;

    @Override
    public Publisher save(Publisher publisher) {
        return repo.save(publisher);
    }

    @Override
    public Publisher update(Publisher publisher) {
        Optional<Publisher> existingPublisher = repo.findById(publisher.getPublisherId());
        if (existingPublisher.isPresent()) {
            return repo.save(publisher);
        } else {
            throw new IllegalArgumentException("Publisher with ID " + publisher.getPublisherId() + " does not exist.");
        }

    }

    @Override
    public Publisher update(Publisher publisher, BookRequestDto bookRequestDto) {
        Publisher existingPublisher = repo.findByPublisherName(bookRequestDto.getPublisherName());
        if (existingPublisher == null) {
            return this.createPublisher(bookRequestDto);
        }
        return existingPublisher;
    }

    @Override
    public void delete(Publisher publisher) {
        Optional<Publisher> existingPublisher = repo.findById(publisher.getPublisherId());
        if (existingPublisher.isPresent()) {
            repo.delete(existingPublisher.get());
        } else {
            throw new IllegalArgumentException("Publisher with ID " + publisher.getPublisherId() + " does not exist.");
        }
    }

    @Override
    public Optional<Publisher> findByPublisherName(String publisherName) {
        return repo.findByPublisherName(publisherName) != null ?
                Optional.of(repo.findByPublisherName(publisherName)) : Optional.empty();
    }

    @Override
    public Publisher createPublisher(BookRequestDto bookRequestDto) {
        return this.findByPublisherName(bookRequestDto.getPublisherName())
                .orElseGet(() -> {
                    Publisher newPublisher = new Publisher();
                    newPublisher.setPublisherName(bookRequestDto.getPublisherName());
                    return repo.save(newPublisher);
                });
    }

    @Override
    public List<Publisher> findAll() {
        return repo.findAll();
    }

    @Override
    public Publisher findById(Long id) {
        return repo.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Publisher with ID " + id + " does not exist."));
    }
}
