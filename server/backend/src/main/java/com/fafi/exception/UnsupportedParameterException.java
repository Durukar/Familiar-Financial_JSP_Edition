package com.fafi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class UnsupportedParameterException extends RuntimeException {
    public UnsupportedParameterException(String message) {
        super(message);
    }
}
