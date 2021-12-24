package com.example.demo.controller;

import com.example.demo.exceptions.ApiException;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.model.dto.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.jni.Time;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalControllerAdvice {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> handleAll(Exception e){
        log.error("Error in app", e);
        return new ResponseEntity<ApiResponse>(
                ApiResponse
                        .builder()
                        .message(String.format("Some error happened: %s", e.getMessage()))
                        .build(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ApiResponse> handleNotFound(ApiException e) {
        log.error("Error in app", e);
        return new ResponseEntity<ApiResponse>(
                ApiResponse
                        .builder()
                        .message(e.getMessage())
                        .build(),
                e.getHttpStatus());
    }
}
