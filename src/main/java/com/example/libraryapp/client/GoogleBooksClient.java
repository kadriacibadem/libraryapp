package com.example.libraryapp.client;

import com.example.libraryapp.client.response.GoogleBookResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "googleBooksClient",
        url = "${url.google.books.api}"
)
public interface GoogleBooksClient {
    @GetMapping("/volumes?q={query}")
    GoogleBookResponse getBooks(@PathVariable("query") String bookName);
}
