package com.wecreateproblems.onlinelibrary.service;

import com.wecreateproblems.onlinelibrary.entity.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    List<Author> getAllAuthors();

    Optional<Author> getAuthorById(Long id);

    Author saveAuthor(Author author);
}
