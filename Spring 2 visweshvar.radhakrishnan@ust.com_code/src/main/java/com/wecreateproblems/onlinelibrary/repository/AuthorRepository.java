package com.wecreateproblems.onlinelibrary.repository;

import com.wecreateproblems.onlinelibrary.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {
    // use JPA repository
}