package com.abkansu.music.validations;

import com.abkansu.music.album.controller.dto.CreateAlbumRequestDTO;
import com.abkansu.music.album.controller.dto.UpdateAlbumRequestDTO;
import com.abkansu.music.song.controller.dto.AddSongRequestDTO;
import com.abkansu.music.song.controller.dto.CreateSongRequestDTO;
import com.abkansu.music.song.controller.dto.UpdateSongRequestDTO;

public class Validations {

    private Validations() {
        throw new IllegalStateException("Utility class");
    }

    private static boolean idValidator(Long id){
        return id >= 1;
    }

    private static boolean yearValidator(Long year){
        return year >= 1600 && year <= 2023;
    }

    private static boolean textValidator(String text){
        return text.length() != 0 && text.length() < 256;
    }


    public static boolean validateCreateAlbumRequestDTO(CreateAlbumRequestDTO createAlbumRequestDTO){
        return textValidator(createAlbumRequestDTO.getBand())
                && textValidator(createAlbumRequestDTO.getName())
                && yearValidator(createAlbumRequestDTO.getPublishYear());
    }

    public static boolean validateUpdateAlbumRequestDTO(UpdateAlbumRequestDTO updateAlbumRequestDTO){
        return textValidator(updateAlbumRequestDTO.getBand())
                && textValidator(updateAlbumRequestDTO.getName())
                && yearValidator(updateAlbumRequestDTO.getPublishYear())
                && idValidator(updateAlbumRequestDTO.getId());
    }

    public static boolean validateAddSongRequestDTO(AddSongRequestDTO addSongRequestDTO){
        return idValidator(addSongRequestDTO.getAlbumId())
                && idValidator(addSongRequestDTO.getSongId());
    }

    public static boolean validateCreateSongRequestDTO(CreateSongRequestDTO createSongRequestDTO){
        return textValidator(createSongRequestDTO.getName());
    }

    public static boolean validateUpdateSongRequestDTO(UpdateSongRequestDTO updateSongRequestDTO){
        return textValidator(updateSongRequestDTO.getName())
                && idValidator(updateSongRequestDTO.getId());
    }

}
