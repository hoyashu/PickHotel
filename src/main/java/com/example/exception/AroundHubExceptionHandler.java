package com.example.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class AroundHubExceptionHandler {
    private String VIEW_PATH = "/error/";

//    @ExceptionHandler(RuntimeException.class)
//    public String eventErrorHandler(RuntimeException ex, Model model) {
//        ex.printStackTrace();
//        model.addAttribute("message", ex.getMessage());
//
//        return VIEW_PATH + "error";
//    }

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
//        System.out.println("MethodArgumentNotValidException오류!");
//        Map<String, String> errors = new HashMap<>();
//        ex.getBindingResult().getAllErrors()
//                .forEach(c -> System.out.println("오류!" + c.getDefaultMessage()));
//
//        return ResponseEntity.badRequest().body(errors);
//    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Map<String, String>> ExceptionHandler(Exception e) {
        HttpHeaders responseHeaders = new HttpHeaders();
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

        System.out.println("advice 내 exceptionHandler");

        Map<String, String> map = new HashMap<>();
        map.put("error type", httpStatus.getReasonPhrase());
        map.put("code", "400");
        map.put("message", "에러발생");

        return new ResponseEntity<>(map, responseHeaders, httpStatus);
    }
}