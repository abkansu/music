package com.abkansu.music.song.controller.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NonNull;

@Data
public class CreateSongRequestDTO {
    private String name;

    @JsonCreator
    public CreateSongRequestDTO(
            @JsonProperty("name") @NonNull String name
    ){
        this.name = name;
    }
}
