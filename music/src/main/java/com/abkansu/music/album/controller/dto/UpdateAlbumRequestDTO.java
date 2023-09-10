package com.abkansu.music.album.controller.dto;

import lombok.Data;
import lombok.NonNull;


@Data
public class UpdateAlbumRequestDTO {
    @NonNull
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private Long publishYear;

    @NonNull
    private String band;
}
