package com.library.controller;

import com.library.entity.Book;
import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository repository;

    @GetMapping
    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Book> getBookById(@PathVariable Integer id) {
        return repository.findById(id);
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return repository.save(book);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Integer id,
                           @RequestBody Book book) {

        book.setId(id);
        return repository.save(book);

    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Integer id) {

        repository.deleteById(id);
        return "Book deleted successfully.";

    }

}