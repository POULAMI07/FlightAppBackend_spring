package com.example.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.model.ExceptionResponseMessage;

@ControllerAdvice
public class CustomControllerAdvice {
	@ExceptionHandler(value = Exception.class)
    public ResponseEntity<ExceptionResponseMessage> handleException(Exception e){
        return ResponseEntity.status(200).body(new ExceptionResponseMessage(204, e.getMessage()));
    }
}
