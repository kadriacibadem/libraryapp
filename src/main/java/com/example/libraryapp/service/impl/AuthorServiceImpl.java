package com.example.libraryapp.service.impl;

import com.example.libraryapp.dto.request.BookRequestDto;
import com.example.libraryapp.entity.Author;
import com.example.libraryapp.entity.Book;
import com.example.libraryapp.repository.AuthorRepo;
import com.example.libraryapp.service.AuthorService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepo repo;

    @Override
    public Author save(Author author) {
        return repo.save(author);
    }

    @Override
    public Author update(Author author) {
        Optional<Author> existingAuthor = repo.findById(author.getAuthorId());
        if (existingAuthor.isPresent()) {
            return repo.save(author);
        }else{
            throw new IllegalArgumentException("Author with ID " + author.getAuthorId() + " does not exist.");
        }
    }

    @Override
    public void delete(Author author) {
        Optional<Author> existingAuthor = repo.findById(author.getAuthorId());
        if (existingAuthor.isPresent()) {
            repo.delete(author);
        }else {
            throw new IllegalArgumentException("Author with ID " + author.getAuthorId() + " does not exist.");
        }
    }

    @Override
    public Author createAuthor(BookRequestDto bookRequestDto, Book book) {
        return findByAuthorNameSurname(bookRequestDto.getAuthorNameSurname()).orElseGet(
                () -> {
                    Author author = new Author();
                    author.setAuthorNameSurname(bookRequestDto.getAuthorNameSurname());
                    author.setBooks(List.of(book));
                    return repo.save(author);
                }
        );
    }

    @Override
    public Optional<Author> findByAuthorNameSurname(String authorNameSurname) {
        return repo.findByAuthorNameSurname(authorNameSurname) != null ?
                Optional.of(repo.findByAuthorNameSurname(authorNameSurname)) : Optional.empty();
    }

    @Override
    public List<Author> findAll() {
        return repo.findAll();
    }
}
