package com.example.libraryapp.controller;

import com.example.libraryapp.dto.response.AuthorResponse;
import com.example.libraryapp.mapper.AuthorMapper;
import com.example.libraryapp.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/author")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @GetMapping("/authors")
    public ResponseEntity<List<AuthorResponse>> getAllAuthors() {
        try{
            return ResponseEntity.ok(
                    authorService.findAll().stream()
                            .map(AuthorMapper::toResponse)
                            .toList()
            );
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

}
