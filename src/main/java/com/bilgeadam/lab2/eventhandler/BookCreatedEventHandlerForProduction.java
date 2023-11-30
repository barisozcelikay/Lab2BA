package com.bilgeadam.lab2.eventhandler;

import com.bilgeadam.lab2.event.BookCreatedEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Profile("prod")
public class BookCreatedEventHandlerForProduction {

    @EventListener
    public void onBookCreated(BookCreatedEvent event)
    {
        List<String> emails = new ArrayList<>();
        emails.add("a@gmail.com");
        emails.add("b@gmail.com");
        sendEmailToAllUsers(emails,"New Book Created","New book created with isbn: "+event.getMessage());
    }

    /**
     * This method simulates sending e-mail to provided user e-mail addresses
     * @param to
     * @param header
     * @param message
     */
    private void sendEmailToAllUsers(List<String> to , String header,  String message)
    {
        //Implement sending e-mail logic
        System.out.println("User created email sent to following users: "+ to);
        System.out.println("Email header: "+ header + " EmailContent: "+ message);
    }
}
