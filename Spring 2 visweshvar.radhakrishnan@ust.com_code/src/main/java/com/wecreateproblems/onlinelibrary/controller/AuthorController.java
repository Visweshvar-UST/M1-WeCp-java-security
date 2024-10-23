package com.wecreateproblems.onlinelibrary.controller;

import com.wecreateproblems.onlinelibrary.entity.Author;
import com.wecreateproblems.onlinelibrary.entity.Book;
import com.wecreateproblems.onlinelibrary.repository.AuthorRepository;
import com.wecreateproblems.onlinelibrary.service.AuthorService;
import com.wecreateproblems.onlinelibrary.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AuthorController {
    // implement author controller
    @Autowired
    private AuthorService authorService;

    @PostMapping("/authors")
    public ResponseEntity<Author> addAuthor(@RequestBody Author author){
        Author res = authorService.saveAuthor(author);
        return ResponseEntity.ok(res);
    }
    @GetMapping("/authors/{id}")
    public ResponseEntity<Author> getAAuthor(@PathVariable Long id){
        Optional<Author> res = authorService.getAuthorById(id);
        if(res.isPresent())
            // return ResponseEntity.ok(res.get());
            return new ResponseEntity<Author>(res.get(), HttpStatus.CREATED);
        else
            return ResponseEntity.noContent().build();
    }
    @GetMapping("/authors")
    public ResponseEntity<List<Author>> getAllAuthor(){
        return ResponseEntity.ok(authorService.getAllAuthors());
    }
    

}
