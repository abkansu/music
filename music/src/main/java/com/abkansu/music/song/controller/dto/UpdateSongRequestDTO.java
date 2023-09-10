package com.abkansu.music.song.controller.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NonNull;


@Data
public class UpdateSongRequestDTO {
    @NonNull
    @Min(value = 1)
    private Long id;

    @NonNull
    @Size(min = 1, max = 255)
    private String name;

}
