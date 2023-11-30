package com.bilgeadam.lab2.exception;

public class ResourcesNotFoundException extends RuntimeException {

    public ResourcesNotFoundException() {
        super("Book list is empty");
    }
}
