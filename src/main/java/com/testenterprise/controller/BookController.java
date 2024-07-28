package com.testenterprise.controller;

import com.testenterprise.dto.BookDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class BookController {

    @GetMapping(value = "/book")
    public BookDto getBooks() {
        return new BookDto(
                "Harry Potter",
                "J.K",
                1
        );
    }

    @PostMapping(value = "/book")
    public BookDto saveBook(@RequestBody BookDto book) {
        return BookDto
                .builder()
                .title(book.getTitle())
                .author(book.getAuthor())
                .number(book.getNumber())
                .build();
    }

    @DeleteMapping(value = "/book/{id}")
    public void deleteBook(@PathVariable int id) {
    }

    @PatchMapping(value = "/book/{id}")
    public BookDto updateBook(@PathVariable int id, @RequestBody BookDto book) {
        return BookDto
                .builder()
                .title("Harry Potter")
                .author("J.K")
                .number(book.getNumber())
                .build();
    }
}