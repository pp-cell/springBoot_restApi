package com.error.exception.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@ControllerAdvice
public class Handler {
    @ExceptionHandler(value = Exception.class)
    public String errors(Exception e) {
        return "error";
    }
    @ExceptionHandler(value = productError.class)
    public String productHandler(productError productError1)
    {
        return "error";
    }
}
