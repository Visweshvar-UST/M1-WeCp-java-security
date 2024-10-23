package com.wecreateproblems.onlinelibrary.service;

import com.wecreateproblems.onlinelibrary.entity.Author;
import com.wecreateproblems.onlinelibrary.repository.AuthorRepository;
import com.wecreateproblems.onlinelibrary.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService{
    // implement author service
    @Autowired
    private AuthorRepository authorRepo;
    @Autowired
    private BookRepository bookRepo;
    
    @Override
    public List<Author> getAllAuthors() {
        // TODO Auto-generated method stub
        List<Author> res = authorRepo.findAll();
        System.out.println("&&&**********getAllAuthors*************&&&"+res);
        return res;
    }
    
    @Override
    public Optional<Author> getAuthorById(Long id) {
        // TODO Auto-generated method stub
        Optional<Author> res = authorRepo.findById(id);
        System.out.println("&&&***********getAuthorById************&&&"+res);
        return res;
    }
    
    @Override
    public Author saveAuthor(Author author) {
        // TODO Auto-generated method stub
        Author res = authorRepo.saveAndFlush(author);
        System.out.println("&&&************saveAuthor***********&&&"+res);
        return res;
    }

}
