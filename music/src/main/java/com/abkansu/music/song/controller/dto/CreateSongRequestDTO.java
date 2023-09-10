package com.abkansu.music.song.controller.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NonNull;

@Data
public class CreateSongRequestDTO {
    private String name;

    @JsonCreator
    public CreateSongRequestDTO(
            @JsonProperty("name") @NonNull @Size(min = 1, max = 255) String name
    ){
        this.name = name;
    }
}
