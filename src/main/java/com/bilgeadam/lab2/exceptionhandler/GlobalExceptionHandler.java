package com.bilgeadam.lab2.exceptionhandler;

import com.bilgeadam.lab2.exception.ResourceAlreadyCreatedException;
import com.bilgeadam.lab2.exception.ResourceNotFoundException;
import com.bilgeadam.lab2.exception.ResourcesNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> resourceNotFound(ResourceNotFoundException exp) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(exp.getMessage());
    }

    @ExceptionHandler(ResourceAlreadyCreatedException.class)
    public ResponseEntity<String> resourceAlreadyCreated(ResourceAlreadyCreatedException exp) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(exp.getMessage());
    }

    @ExceptionHandler(ResourcesNotFoundException.class)
    public ResponseEntity<String> resourcesNotFoundException(ResourcesNotFoundException exp) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(exp.getMessage());
    }
}
