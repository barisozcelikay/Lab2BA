package com.bilgeadam.lab2.exception;

public class ResourceAlreadyCreatedException extends RuntimeException{
    public ResourceAlreadyCreatedException(String exp) {
        super(exp);
    }
}
