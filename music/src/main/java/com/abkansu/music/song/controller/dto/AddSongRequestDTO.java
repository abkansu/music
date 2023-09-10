package com.abkansu.music.song.controller.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class AddSongRequestDTO {
    @NonNull
    private Long albumId;

    @NonNull
    private Long songId;
}
