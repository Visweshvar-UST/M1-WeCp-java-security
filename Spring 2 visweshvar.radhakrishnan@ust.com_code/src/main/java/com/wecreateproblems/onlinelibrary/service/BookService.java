package com.wecreateproblems.onlinelibrary.service;

import com.wecreateproblems.onlinelibrary.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> getAllBooks();

    Optional<Book> getBookById(Long id);

    Book saveBook(Book book);
}
