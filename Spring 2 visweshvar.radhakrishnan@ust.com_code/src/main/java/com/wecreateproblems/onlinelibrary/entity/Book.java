package com.wecreateproblems.onlinelibrary.entity;

import javax.persistence.*;
// import java.util.List;

@Entity
public class Book {
    // implement book entity
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String genre;
    @ManyToOne
    private Author author;
    public Book() {
    }
    public Book(Long id, String title, String genre, Author author) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.author = author;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public Author getAuthor() {
        return author;
    }
    public void setAuthor(Author author) {
        this.author = author;
    }
    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", genre=" + genre + ", author=" + author + "]";
    }
    
}