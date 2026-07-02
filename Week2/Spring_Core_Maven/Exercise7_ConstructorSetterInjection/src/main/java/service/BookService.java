package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private String libraryName;
    private BookRepository bookRepository;

    public BookService(String libraryName) {
        this.libraryName = libraryName;
    }

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void displayService() {
        System.out.println("Library Name: " + libraryName);
        bookRepository.displayRepository();
    }

}