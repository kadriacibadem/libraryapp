package com.example.libraryapp.controller;

import com.example.libraryapp.client.response.BookSearchResponse;
import com.example.libraryapp.client.service.GoogleBookService;
import com.example.libraryapp.dto.request.BookRequestDto;
import com.example.libraryapp.dto.response.BookResponse;
import com.example.libraryapp.entity.Book;
import com.example.libraryapp.mapper.BookMapper;
import com.example.libraryapp.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
@RequiredArgsConstructor
@Validated
public class BookController {

    private static final Logger logger = LogManager.getLogger(BookController.class);

    private final BookService bookService;
    private final GoogleBookService googleBookService;

    @Operation(
            summary = "Kitap oluşturma REST API",
            description = "Yeni bir kitap oluşturur"
    )
    @PostMapping("/create")
    public ResponseEntity<BookResponse> createBook(@Valid @RequestBody BookRequestDto bookRequestDto) {
        try{
            Book book = bookService.createBookFromDto(bookRequestDto);
            BookResponse bookResponse = BookMapper.toResponse(book);
            return ResponseEntity.ok(bookResponse);
        }catch (Exception e){
            logger.error(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @Operation(
            summary = "Kitap getirme REST API",
            description = "Kitap ismine göre kitap bilgilerini getirir"
    )
    @GetMapping("/get/{title}")
    public ResponseEntity<BookResponse> createBook(@PathVariable String title) {
        try{
            Book book = bookService.findByTitle(title);
            BookResponse bookResponse = BookMapper.toResponse(book);
            return ResponseEntity.ok(bookResponse);
        }catch (Exception e){
            logger.error(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @Operation(
            summary = "Kitap güncelleme REST API",
            description = "ISBN13 numarasına göre mevcut bir kitabı günceller"
    )
    @PutMapping("/update")
    public ResponseEntity<BookResponse> updateBook(@Valid @RequestBody BookRequestDto bookRequestDto) {
        try{
            Book updatedBook = bookService.updateBook(bookRequestDto);
            BookResponse bookResponse = BookMapper.toResponse(updatedBook);
            return ResponseEntity.ok(bookResponse);
        }catch (Exception e){
            logger.error(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @Operation(
            summary = "Kitap silme REST API",
            description = "ISBN13 numarasına göre mevcut bir kitabı siler"
    )
    @DeleteMapping("/delete/{isbn13}")
    public ResponseEntity<BookResponse> deleteBook(@PathVariable String isbn13) {
        try{
            bookService.deleteBook(isbn13);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            logger.error(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @Operation(
            summary = "Tüm kitapları listeleme REST API",
            description = "Tüm kitapları listeler"
    )
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
            logger.error(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @Operation(
            summary = "A ile başlayan kitapları getirme REST API",
            description = "A harfi ile başlayan kitapları listeler"
    )
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
            logger.error(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @Operation(
            summary = "Google ile kitap arama REST API",
            description = "Google Books API kullanarak kitap arar"
    )
    @GetMapping("/search/{bookName}")
    public ResponseEntity<List<BookSearchResponse>> searchBook(@PathVariable String bookName) {
        try{
            return ResponseEntity.ok(
                    googleBookService.searchBooks(bookName)
            );
        }catch (Exception e){
            logger.error(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
}
