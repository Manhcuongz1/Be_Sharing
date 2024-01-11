package com.example.demo.controller;

import com.example.demo.data.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.ModelAndView;

public class ResponseUtil {
    public static ResponseEntity<?> success(Object data) {
        Response<?> response = new Response<>(data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    public static ResponseEntity<?> success(Response<?> data) {
        return new ResponseEntity<>(data,HttpStatus.OK);
    }
    public static ResponseEntity<?> error(HttpStatus status, String message) {
        Response<?> response = new Response<>();
        response.setMessage(message);
        return new ResponseEntity<>(response, status);
    }
    public static ResponseEntity<?> error(HttpStatus status, Response<?> error) {
        return new ResponseEntity<>(error,status);
    }
}
