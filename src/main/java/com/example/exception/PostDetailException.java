package com.example.exception;

public class PostDetailException extends RuntimeException {
    public PostDetailException(String message) {
        super(message);
    }
}