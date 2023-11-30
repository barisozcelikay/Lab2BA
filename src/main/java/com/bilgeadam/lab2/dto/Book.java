package com.bilgeadam.lab2.dto;


import java.time.LocalDate;


public class Book {

    private String name;
    private String isbn;
    private String author;
    private LocalDate publishDate;

    public Book(String name, String isbn, String author, LocalDate publishDate) {
        this.name = name;
        this.isbn = isbn;
        this.author = author;
        this.publishDate = publishDate;
    }

    public Book()
    {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }
}
