package com.example.BookstoreAPI.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Handle book not found exceptions
    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponse handleNoSuchElementException(NoSuchElementException ex) {
        return new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }

    // Handle invalid arguments or type mismatch
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex) {
        return new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "Invalid argument: " + ex.getMessage());
    }

    // Handle general exceptions
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorResponse handleGeneralException(Exception ex) {
        return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "An unexpected error occurred: " + ex.getMessage());
    }

    // Custom error response class
    public static class ErrorResponse {
        private int statusCode;
        private String message;

        public ErrorResponse(int statusCode, String message) {
            this.statusCode = statusCode;
            this.message = message;
        }

        public int getStatusCode() {
            return statusCode;
        }

        public void setStatusCode(int statusCode) {
            this.statusCode = statusCode;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}