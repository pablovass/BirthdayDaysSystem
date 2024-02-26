package com.pablovallejos.controller;

import com.pablovallejos.exception.ErrorResponse;
import com.pablovallejos.exception.ValidationExceptionMessage;
import jakarta.validation.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

public class ErrorController {

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(ValidationException e, WebRequest request) {
        String errorMessage = ValidationExceptionMessage.valueOf(e.getMessage()).getMessage();
        String fullErrorMessage = errorMessage;

        ErrorResponse errorResponse = new ErrorResponse(fullErrorMessage);

        // Devolver la respuesta con el formato personalizado y el código de estado adecuado
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}