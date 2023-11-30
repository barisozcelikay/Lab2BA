package com.bilgeadam.lab2.service;

import com.bilgeadam.lab2.event.BookCreatedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class CustomEventPublisherService {

    @Autowired
    ApplicationEventPublisher publisher;


    public void publishBookCreatedEvent(String message){
        BookCreatedEvent event = new BookCreatedEvent(this, message);
        publisher.publishEvent(event);
    }
}
