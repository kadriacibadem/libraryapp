package com.example.libraryapp.controller;

import com.example.libraryapp.dto.response.PublisherResponse;
import com.example.libraryapp.mapper.PublisherMapper;
import com.example.libraryapp.service.PublisherService;
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
@RequestMapping("/api/publisher")
@RequiredArgsConstructor
public class PublisherController {

    private final Logger logger = LogManager.getLogger(this.getClass());

    private final PublisherService publisherService;

    @Operation(
            summary = "Tüm yayınevlerini listeleme REST API",
            description = "Tüm yayınevlerini listeler"
    )
    @GetMapping("/publishers")
    ResponseEntity<List<PublisherResponse>> getAllPublishers(){
        try{
            return ResponseEntity.ok(
                    publisherService.findAll().stream()
                            .map(PublisherMapper::toResponse)
                            .toList()
            );
        }catch (Exception e){
            logger.error(e);
            return ResponseEntity.badRequest().build();
        }
    }
}
