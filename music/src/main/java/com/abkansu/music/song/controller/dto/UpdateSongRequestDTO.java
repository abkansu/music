package com.abkansu.music.song.controller.dto;

import lombok.Data;
import lombok.NonNull;


@Data
public class UpdateSongRequestDTO {
    @NonNull
    private Long id;

    @NonNull
    private String name;

}
