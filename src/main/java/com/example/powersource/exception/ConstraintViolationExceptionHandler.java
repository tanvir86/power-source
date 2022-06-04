package com.example.powersource.exception;

import com.example.powersource.dto.ConstraintError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import javax.validation.ConstraintViolationException;


@RestControllerAdvice
public class ConstraintViolationExceptionHandler {
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ConstraintError> handleConstraintViolationException(ConstraintViolationException exception) {
        ConstraintError customError = new ConstraintError();
        customError.setError(HttpStatus.BAD_REQUEST.getReasonPhrase());
        customError.setStatus(HttpStatus.BAD_REQUEST.value());
        customError.setMessage(exception.getLocalizedMessage());
        return ResponseEntity.badRequest().body(customError);
    }
}
