package com.abkansu.music.album.controller.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NonNull;


@Data
public class UpdateAlbumRequestDTO {
    @NonNull
    @Min(value = 1)
    private Long id;

    @NonNull
    @Size(min = 1, max = 255)
    private String name;

    @NonNull
    @Min(value = 1600)
    @Max(value = 2023)
    private Long publishYear;

    @NonNull
    @Size(min = 1, max = 255)
    private String band;
}
