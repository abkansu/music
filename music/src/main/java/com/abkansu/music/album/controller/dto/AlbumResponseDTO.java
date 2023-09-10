package com.abkansu.music.album.controller.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Builder
@Data
public class AlbumResponseDTO {
    private int statusCode;
    private HttpStatus status;
    private String message;
}
