package com.example.libraryapp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Table(name = "book")
@AllArgsConstructor
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id", nullable = false)
    private Long bookId;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "isbn_13")
    private String ISBN13;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publisher_id",referencedColumnName = "publisher_id")
    private Publisher publisher;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id",referencedColumnName = "author_id")
    private Author author;

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(!(o instanceof Book book)) return false;
        return bookId != null && bookId.equals(book.getBookId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
