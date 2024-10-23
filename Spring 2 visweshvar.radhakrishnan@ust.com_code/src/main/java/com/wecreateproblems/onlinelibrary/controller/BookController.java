package com.wecreateproblems.onlinelibrary.controller;


import com.wecreateproblems.onlinelibrary.entity.Author;
import com.wecreateproblems.onlinelibrary.entity.Book;
import com.wecreateproblems.onlinelibrary.service.AuthorService;
import com.wecreateproblems.onlinelibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    // implement book controller
    @Autowired
    private BookService bookService;

    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        Book res = bookService.saveBook(book);
        return ResponseEntity.ok(res);
    }
    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getABook(@PathVariable Long id){
        Optional<Book> res = bookService.getBookById(id);
        if(res.isPresent())
            return ResponseEntity.ok(res.get());
        else
            return ResponseEntity.noContent().build();
    }
    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBook(){
        // return ResponseEntity.ok(bookService.getAllBooks());
        return new ResponseEntity<List<Book>>(bookService.getAllBooks(), HttpStatus.OK);
    }
}