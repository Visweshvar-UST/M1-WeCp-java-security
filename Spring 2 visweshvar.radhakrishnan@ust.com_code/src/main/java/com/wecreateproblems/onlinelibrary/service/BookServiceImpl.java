package com.wecreateproblems.onlinelibrary.service;

import com.wecreateproblems.onlinelibrary.entity.Author;
import com.wecreateproblems.onlinelibrary.entity.Book;
import com.wecreateproblems.onlinelibrary.repository.AuthorRepository;
import com.wecreateproblems.onlinelibrary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    // implement book service 
    @Autowired
    private BookRepository bookRepo;
    @Autowired
    private AuthorRepository authorRepo;
    
    @Override
    public List<Book> getAllBooks() {
        // TODO Auto-generated method stub
        List<Book> res = bookRepo.findAll();
        System.out.println("%%%%%*****************getAllBooks***************%%%%%%"+res);
        return res;
    }

    @Override
    public Optional<Book> getBookById(Long id) {
        // TODO Auto-generated method stub
        Optional<Book> res = bookRepo.findById(id);
        System.out.println("%%%%%***************getBookById*****************%%%%%%"+res);
        return res;
    }
    
    @Override
    public Book saveBook(Book book) {
        // TODO Auto-generated method stub
        Optional<Author> author = authorRepo.findById(book.getAuthor().getId());
        if(author.isPresent()){
            author.get().addBooks(book);
            authorRepo.save(author.get());
            Book res = bookRepo.save(book);
            System.out.println("%%%%%%******************saveBook**************%%%%%"+res);
            return res;
        }
        return null;
    }
    
}
