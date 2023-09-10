package com.abkansu.music.exception.advice;

import com.abkansu.music.exception.ApiErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.NoSuchElementException;

@ControllerAdvice
public class ApiErrorHandler {

    @ExceptionHandler(value = {NoSuchElementException.class})
    public ResponseEntity<Object> noSuchElementExceptionHandler(NoSuchElementException noSuchElementException){
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        ApiErrorResponse apiErrorResponse = ApiErrorResponse
                .builder()
                .message(noSuchElementException.getMessage())
                .status(httpStatus)
                .statusCode(404)
                .timestamp(ZonedDateTime.now(ZoneId.of("Z")))
                .build();

        return new ResponseEntity<>(apiErrorResponse, httpStatus);
    }

    @ExceptionHandler(value = {HttpMessageNotReadableException.class})
    public ResponseEntity<Object> httpMessageNotReadableExceptionHandler(HttpMessageNotReadableException httpMessageNotReadableException){
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        ApiErrorResponse apiErrorResponse = ApiErrorResponse
                .builder()
                .message(httpMessageNotReadableException.getMessage())
                .status(httpStatus)
                .statusCode(400)
                .timestamp(ZonedDateTime.now(ZoneId.of("Z")))
                .build();
        return new ResponseEntity<>(apiErrorResponse, httpStatus);
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> exceptionHandler(Exception exception){
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        ApiErrorResponse apiErrorResponse = ApiErrorResponse
                .builder()
                .message(exception.getMessage())
                .status(httpStatus)
                .statusCode(400)
                .timestamp(ZonedDateTime.now(ZoneId.of("Z")))
                .build();
        return new ResponseEntity<>(apiErrorResponse, httpStatus);
    }
}
