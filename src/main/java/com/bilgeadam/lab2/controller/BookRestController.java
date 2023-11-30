package com.bilgeadam.lab2.controller;

import com.bilgeadam.lab2.dto.Book;
import com.bilgeadam.lab2.exception.ResourceNotFoundException;
import com.bilgeadam.lab2.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/book")
public class BookRestController {

    @Autowired
    private BookService bookService;


    @GetMapping("/all")
    public ResponseEntity<List<Book>> getBookList() {
        return ResponseEntity.ok().body(bookService.getAllBooks());
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<Book> getBook(@PathVariable String isbn) {
        return ResponseEntity.ok().body(bookService.getBookByIsbn(isbn));
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book newBook) {
        return ResponseEntity.ok().body(bookService.createBook(newBook));
    }

    @PutMapping("{isbn}")
    public ResponseEntity<Book> updateBook(@RequestBody Book book) {
        return ResponseEntity.ok().body(bookService.updateBook(book));
    }

    @DeleteMapping("{isbn}")
    public ResponseEntity<Book> deleteBook(@PathVariable String isbn) {
        return ResponseEntity.ok().body(bookService.deleteBookByIsbn(isbn));
    }
}
