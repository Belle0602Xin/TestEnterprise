package com.testenterprise.controller;

import com.testenterprise.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
