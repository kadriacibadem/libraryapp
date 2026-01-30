package com.example.libraryapp.repository;

import com.example.libraryapp.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PublisherRepo extends JpaRepository<Publisher, Long> {
    Publisher findByPublisherName(String publisherName);
}
