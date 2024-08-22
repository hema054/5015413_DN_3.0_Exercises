package com.example.BookstoreAPI.controller;

import com.example.BookstoreAPI.entity.Book;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
public class BookController {

    private List<Book> books = new ArrayList<>();
    private int bookIdCounter = 1;

    // Constructor to add some initial data (optional)
    public BookController() {
        books.add(new Book(bookIdCounter++, "Spring in Action", "Craig Walls", 45.99, "9781617294945"));
        books.add(new Book(bookIdCounter++, "Effective Java", "Joshua Bloch", 55.99, "9780134685991"));
        books.add(new Book(bookIdCounter++, "Clean Code", "Robert C. Martin", 42.50, "9780132350884"));
    }

    // GET method to retrieve all books with optional query parameters
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "author", required = false) String author) {

        List<Book> filteredBooks = books.stream()
                .filter(book -> (title == null || book.getTitle().contains(title)) &&
                        (author == null || book.getAuthor().contains(author)))
                .collect(Collectors.toList());

        return new ResponseEntity<>(filteredBooks, HttpStatus.OK);
    }

    // GET method to retrieve a book by ID
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable int id) {
        return books.stream()
                .filter(book -> book.getId() == id)
                .findFirst()
                .map(book -> new ResponseEntity<>(book, HttpStatus.OK))
                .orElseThrow(() -> new NoSuchElementException("Book not found with id: " + id));
    }

    // POST method to add a new book
    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        book.setId(bookIdCounter++);
        books.add(book);
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }

    // PUT method to update an existing book
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable int id, @RequestBody Book updatedBook) {
        return books.stream()
                .filter(book -> book.getId() == id)
                .findFirst()
                .map(book -> {
                    book.setTitle(updatedBook.getTitle());
                    book.setAuthor(updatedBook.getAuthor());
                    book.setPrice(updatedBook.getPrice());
                    book.setIsbn(updatedBook.getIsbn());
                    return new ResponseEntity<>(book, HttpStatus.OK);
                })
                .orElseThrow(() -> new NoSuchElementException("Book not found with id: " + id));
    }

    // DELETE method to remove a book by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable int id) {
        boolean removed = books.removeIf(book -> book.getId() == id);
        if (removed) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            throw new NoSuchElementException("Book not found with id: " + id);
        }
    }
}