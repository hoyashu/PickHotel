package com.example.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionController {
    private String VIEW_PATH = "/error/";

    @ExceptionHandler(RuntimeException.class)
    public String eventErrorHandler(RuntimeException ex, Model model) {
        ex.printStackTrace();
        model.addAttribute("message", ex.getMessage());

        return VIEW_PATH + "error";
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        System.out.println("MethodArgumentNotValidException오류!");
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors()
                .forEach(c -> System.out.println("오류!" + c.getDefaultMessage()));

        return ResponseEntity.badRequest().body(errors);
    }
}