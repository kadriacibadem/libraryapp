package com.example.libraryapp.controller;

import com.example.libraryapp.dto.response.AuthorResponse;
import com.example.libraryapp.mapper.AuthorMapper;
import com.example.libraryapp.service.AuthorService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/author")
@RequiredArgsConstructor
public class AuthorController {

    private final Logger logger = LogManager.getLogger(this.getClass());

    private final AuthorService authorService;

    @Operation(
            summary = "Tüm yazarları listeleme REST API",
            description = "Tüm yazarları listeler"
    )
    @GetMapping("/authors")
    public ResponseEntity<List<AuthorResponse>> getAllAuthors() {
        try{
            return ResponseEntity.ok(
                    authorService.findAll().stream()
                            .map(AuthorMapper::toResponse)
                            .toList()
            );
        }catch (Exception e){
            logger.error(e);
            return ResponseEntity.badRequest().build();
        }
    }

}
