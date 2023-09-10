package com.abkansu.music.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Builder
@AllArgsConstructor
@Getter
public class ApiErrorResponse {
    private int statusCode;
    private HttpStatus status;
    private String message;
    private ZonedDateTime timestamp;
}
