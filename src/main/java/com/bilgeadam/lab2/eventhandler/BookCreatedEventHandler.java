package com.bilgeadam.lab2.eventhandler;

import com.bilgeadam.lab2.event.BookCreatedEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class BookCreatedEventHandler {
    @EventListener
    public void onBookCreated(BookCreatedEvent evt) {
        System.out.println(evt.getMessage());
    }


}
