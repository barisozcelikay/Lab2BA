package com.bilgeadam.lab2.exception;


public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String isbn) {
        super("Book not exist with isbn: "+isbn);
    }
}
