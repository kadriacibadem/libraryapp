package com.example.libraryapp.controller;

import com.example.libraryapp.client.response.BookSearchResponse;
import com.example.libraryapp.client.service.GoogleBookService;
import com.example.libraryapp.dto.request.BookRequestDto;
import com.example.libraryapp.dto.response.BookResponse;
import com.example.libraryapp.entity.Book;
import com.example.libraryapp.mapper.BookMapper;
import com.example.libraryapp.service.BookService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;
    private final GoogleBookService googleBookService;

    @PostMapping("/create")
    public ResponseEntity<BookResponse> createBook(@RequestBody BookRequestDto bookRequestDto) {
        try{
            Book book = bookService.createBookFromDto(bookRequestDto);
            BookResponse bookResponse = BookMapper.toResponse(book);
            return ResponseEntity.ok(bookResponse);
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Book> updateBook(@RequestBody Book book) {
        Book updatedBook = bookService.update(book);
        return ResponseEntity.ok(updatedBook);
    }

    @GetMapping("/books" )
    public ResponseEntity<List<BookResponse>> getAllBooks() {
        try{
            return ResponseEntity.ok(
                    bookService.findAll()
                            .stream()
                            .map(BookMapper::toResponse)
                            .toList()
            );
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/books-start-with-a" )
    public ResponseEntity<List<BookResponse>> getBooksStartingWithA() {
        try{
            return ResponseEntity.ok(
                    bookService.findByBooksStartWithA()
                            .stream()
                            .map(BookMapper::toResponse)
                            .toList()
            );
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/search/{bookName}")
    public ResponseEntity<List<BookSearchResponse>> searchBook(@PathVariable String bookName) {
        try{
            return ResponseEntity.ok(
                    googleBookService.searchBooks(bookName)
            );
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}
