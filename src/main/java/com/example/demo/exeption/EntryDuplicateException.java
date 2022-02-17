package com.example.demo.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EntryDuplicateException extends RuntimeException {
    public EntryDuplicateException(String message) {
        super(message);
    }

    public EntryDuplicateException(String message, Throwable cause) {
        super(message, cause);
    }




}
