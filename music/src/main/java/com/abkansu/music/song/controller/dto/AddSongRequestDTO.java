package com.abkansu.music.song.controller.dto;

import jakarta.validation.constraints.Min;
import lombok.Data;
import lombok.NonNull;

@Data
public class AddSongRequestDTO {
    @NonNull
    @Min(value = 1)
    private Long albumId;

    @NonNull
    @Min(value = 1)
    private Long songId;
}
