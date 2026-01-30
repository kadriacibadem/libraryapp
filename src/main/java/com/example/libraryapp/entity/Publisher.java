package com.example.libraryapp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "publisher")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Publisher {
    @Id
    @Column(name = "publisher_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long publisherId;

    @Column(name = "publisher_name")
    private String publisherName;

    @OneToMany(mappedBy = "publisher", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Book> books = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(!(o instanceof Publisher publisher)) return false;
        return publisherId != null && publisherId.equals(publisher.getPublisherId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
