package com.example.demo.exception;

import com.example.demo.data.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = StorageException.class)
    public ResponseEntity<?>storageException(StorageException ex) {
        return new ResponseEntity<>(new Response<>(null,ex.getMessage(),Boolean.FALSE,null),HttpStatus.PAYLOAD_TOO_LARGE);
    }
}
