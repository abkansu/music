package com.abkansu.music.song.controller.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class SongResponseDTO {
    private int statusCode;
    private HttpStatus status;
    private String message;
}
