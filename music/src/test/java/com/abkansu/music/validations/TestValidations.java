package com.abkansu.music.validations;

import com.abkansu.music.album.controller.dto.CreateAlbumRequestDTO;
import com.abkansu.music.album.controller.dto.UpdateAlbumRequestDTO;
import com.abkansu.music.song.controller.dto.AddSongRequestDTO;
import com.abkansu.music.song.controller.dto.CreateSongRequestDTO;
import com.abkansu.music.song.controller.dto.UpdateSongRequestDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.abkansu.music.validations.Validations.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

@ExtendWith(MockitoExtension.class)
class TestValidations {

    @Test
    void testValidateCreateAlbumRequestDTO(){
        //given
        CreateAlbumRequestDTO createAlbumRequestDTO = new CreateAlbumRequestDTO("name", 1200L, "band");

        //when then
        assertFalse(validateCreateAlbumRequestDTO(createAlbumRequestDTO));
    }

    @Test
    void testValidateUpdateCreateAlbumRequestDTO(){
        //given
        UpdateAlbumRequestDTO updateAlbumRequestDTO = new UpdateAlbumRequestDTO(1L, "name", 1200L, "band");

        //when then
        assertFalse(validateUpdateAlbumRequestDTO(updateAlbumRequestDTO));
    }


    @Test
    void testValidateAddSongRequestDTO(){
        //given
        AddSongRequestDTO addSongRequestDTO = new AddSongRequestDTO(1L, 0L);

        //when then
        assertFalse(validateAddSongRequestDTO(addSongRequestDTO));
    }

    @Test
    void testValidateCreateSongRequestDTO(){
        //given
        CreateSongRequestDTO createSongRequestDTO = new CreateSongRequestDTO("");

        //when then
        assertFalse(validateCreateSongRequestDTO(createSongRequestDTO));
    }


    @Test
    void testValidateUpdateSongRequestDTO(){
        //given
        UpdateSongRequestDTO updateSongRequestDTO = new UpdateSongRequestDTO(0L, "name");

        //when then
        assertFalse(validateUpdateSongRequestDTO(updateSongRequestDTO));
    }

}
