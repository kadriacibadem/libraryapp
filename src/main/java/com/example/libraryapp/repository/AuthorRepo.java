package com.example.libraryapp.repository;

import com.example.libraryapp.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo extends JpaRepository<Author, Long> {
    Author findByAuthorNameSurname(String authorNameSurname);
}
