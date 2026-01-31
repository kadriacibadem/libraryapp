package com.example.libraryapp.service.impl;

import com.example.libraryapp.dto.request.BookRequestDto;
import com.example.libraryapp.entity.Author;
import com.example.libraryapp.entity.Book;
import com.example.libraryapp.entity.Publisher;
import com.example.libraryapp.repository.BookRepo;
import com.example.libraryapp.service.AuthorService;
import com.example.libraryapp.service.BookService;
import com.example.libraryapp.service.PublisherService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepo repo;
    private final PublisherService publisherService;
    private final AuthorService authorService;


    @Override
    public Book save(Book book) {
        return repo.save(book);
    }

    @Override
    public Book update(Book book) {
        Optional<Book> existingBook = repo.findById(book.getBookId());
        if (existingBook.isPresent()) {
            return repo.save(book);
        }else {
            throw new IllegalArgumentException("Book with ID " + book.getBookId() + " does not exist.");
        }
    }

    @Override
    public void delete(Book book) {
        Optional<Book> existingBook = repo.findById(book.getBookId());
        if (existingBook.isPresent()) {
            repo.delete(book);
        }else {
            throw new IllegalArgumentException("Book with ID " + book.getBookId() + " does not exist.");
        }
    }

    @Override
    public Book findByTitle(String title) {
        Book book = repo.findByTitle(title);
        if(book == null){
            throw new IllegalArgumentException("Book with title " + title + " does not exist.");
        }
        return book;
    }

    @Override
    public List<Book> findAll() {
        List<Book> allBook = repo.findAll();
        if(allBook.isEmpty()){
            throw new IllegalArgumentException("No books found in the library.");
        }
        return allBook;
    }

    @Override
    public Book createBookFromDto(BookRequestDto bookRequestDto) {
        Publisher publisher = publisherService.createPublisher(bookRequestDto);
        Book book = new Book();
        book.setTitle(bookRequestDto.getTitle());
        book.setPrice(bookRequestDto.getPrice());
        book.setPublisher(publisher);
        book.setISBN13(bookRequestDto.getIsbn13());
        Author author = authorService.createAuthor(bookRequestDto,book);
        book.setAuthor(author);
        return repo.save(book);
    }

    @Override
    public List<Book> findByBooksStartWithA() {
        return this.findAll().stream()
                .filter(
                        book -> book.getTitle().toUpperCase().startsWith("A")
                ).toList();
    }

    @Override
    public Book updateBook(BookRequestDto bookRequestDto) {
        Book book = repo.findByISBN13(bookRequestDto.getIsbn13());
        if(book == null){
            throw new IllegalArgumentException("Book with ISBN13 " + bookRequestDto.getIsbn13() + " does not exist.");
        }
        book.setTitle(bookRequestDto.getTitle());
        Publisher publisher = publisherService.update(book.getPublisher(), bookRequestDto);
        book.setPublisher(publisher);
        Author author = authorService.update(book.getAuthor(), bookRequestDto,book);
        book.setAuthor(author);
        book.setPrice(bookRequestDto.getPrice());
        return repo.save(book);
    }

    @Override
    public void deleteBook(String isbn13) {
        Book book = repo.findByISBN13(isbn13);
        if(book == null){
            throw new IllegalArgumentException("Book with ISBN13 " + isbn13 + " does not exist.");
        }
        repo.delete(book);
    }

    @Override
    public Book findById(Long id) {
        return repo.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Book with ID " + id + " does not exist."));
    }
}
