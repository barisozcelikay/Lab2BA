package com.bilgeadam.lab2.service;

import com.bilgeadam.lab2.dto.Book;
import com.bilgeadam.lab2.exception.ResourceAlreadyCreatedException;
import com.bilgeadam.lab2.exception.ResourceNotFoundException;
import com.bilgeadam.lab2.exception.ResourcesNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class BookService {

    private List<Book> fakeBookTable;

    @Autowired
    private CustomEventPublisherService eventPublisherService;



    public BookService() {
        fakeBookTable = new ArrayList<>();
        // test
        Book testBook = new Book("testBook", "TB1", "TA1", LocalDate.now());
        Book testBook2 = new Book("testBook2", "TB2", "TA2", LocalDate.now());
        fakeBookTable.add(testBook);
        fakeBookTable.add(testBook2);
    }

    /**
     * Get all books in the fake DB
     *
     * @return
     */
    public List<Book> getAllBooks() {
        if (fakeBookTable.isEmpty()) {
            throw new ResourcesNotFoundException();
        }
        return fakeBookTable;
    }

    /**
     * Crates a book into fake DB
     *
     * @param request
     * @return returns added book instance
     */
    public Book createBook(Book request) {
        boolean bookAlreadyExistFlag = false;
        for (Book book : fakeBookTable) {
            if (book.getIsbn().equals(request.getIsbn())) {
                bookAlreadyExistFlag = true;
                break;
            }
        }
        if (bookAlreadyExistFlag) {
            throw new ResourceAlreadyCreatedException("Book is already created");
        } else {
            fakeBookTable.add(request);
            eventPublisherService.publishBookCreatedEvent("Book is created with isbn: "+ request.getIsbn());
            return request;

        }
    }

    /**
     * Update a book with getting isbn number
     *
     * @param updateRequest
     * @return returns updated book
     */
    public Book updateBook(Book updateRequest) {
        Book book = this.getBookByIsbn(updateRequest.getIsbn());
        book.setAuthor(updateRequest.getAuthor());
        book.setPublishDate(updateRequest.getPublishDate());
        book.setName(updateRequest.getName());
        fakeBookTable = fakeBookTable.stream().map((i) -> i.getIsbn().equals(updateRequest.getIsbn()) ? updateRequest : i)
                .collect(Collectors.toList());
        return updateRequest;
    }

    /**
     * Get book by isbn number
     *
     * @param isbn
     * @return returns book by isbn number
     */
    public Book getBookByIsbn(String isbn) {
        Book book = this.getAllBooks().stream().filter((i) -> Objects.equals(i.getIsbn(), isbn)).findAny().orElse(null);
        if (book == null) {
            throw new ResourceNotFoundException(isbn);
        } else {
            return book;
        }
    }

    public Book deleteBookByIsbn(String isbn) {
        Book book = this.getAllBooks().stream().filter((i) -> Objects.equals(i.getIsbn(), isbn)).findAny().orElse(null);
        if (book == null) {
            throw new ResourceNotFoundException(isbn);
        } else {
            this.fakeBookTable.remove(book);
            return book;
        }
    }

}
