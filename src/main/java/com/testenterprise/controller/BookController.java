package com.testenterprise.controller;

import com.testenterprise.Book;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class BookController {

    @GetMapping(value = "/book")
    public Book getBooks() {
        return new Book(
                "Harry Potter",
                "J.K",
                1
        );
    }

    @PostMapping(value = "/book")
    public Book saveBook(@RequestBody Book book) {
        return Book
                .builder()
                .title(book.getTitle())
                .author(book.getAuthor())
                .number(book.getNumber())
                .build();
    }
}