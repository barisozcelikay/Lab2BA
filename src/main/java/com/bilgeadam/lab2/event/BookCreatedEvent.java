package com.bilgeadam.lab2.event;

import org.springframework.context.ApplicationEvent;

public class BookCreatedEvent extends ApplicationEvent {

    private String message;

    public BookCreatedEvent(Object source , String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
