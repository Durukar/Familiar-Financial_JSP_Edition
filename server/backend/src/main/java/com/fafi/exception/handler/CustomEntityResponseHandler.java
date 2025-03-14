package com.fafi.exception.handler;

import com.fafi.exception.ExceptionResponse;
import com.fafi.exception.UnsupportedParameterException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice // Sempre que precisar concentrar um tratamento que precisa ser espalhado em outros controllers
@RestController
public class CustomEntityResponseHandler extends ResponseEntityExceptionHandler {

    // Exception generica
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex, WebRequest request) {
        ExceptionResponse response = new ExceptionResponse(
                new Date(),
                ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Exception para a rota User com os parametros errados
    @ExceptionHandler(UnsupportedParameterException.class)
    public final ResponseEntity<ExceptionResponse> handleUnsupportedParameterException(UnsupportedParameterException ex, WebRequest request) {
        ExceptionResponse response = new ExceptionResponse(
                new Date(),
                ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
