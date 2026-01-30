package com.example.libraryapp.controller;

import com.example.libraryapp.dto.response.PublisherResponse;
import com.example.libraryapp.mapper.PublisherMapper;
import com.example.libraryapp.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/publisher")
@RequiredArgsConstructor
public class PublisherController {
    private final PublisherService publisherService;

    @GetMapping("/publishers")
    ResponseEntity<List<PublisherResponse>> getAllPublishers(){
        try{
            return ResponseEntity.ok(
                    publisherService.findAll().stream()
                            .map(PublisherMapper::toResponse)
                            .toList()
            );
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}
