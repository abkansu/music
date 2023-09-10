package com.abkansu.music.song.service;


import com.abkansu.music.album.entity.Album;
import com.abkansu.music.album.service.AlbumService;
import com.abkansu.music.song.controller.dto.AddSongRequestDTO;
import com.abkansu.music.song.controller.dto.CreateSongRequestDTO;
import com.abkansu.music.song.controller.dto.UpdateSongRequestDTO;
import com.abkansu.music.song.entity.Song;
import com.abkansu.music.song.repository.SongRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TestSongService {

    @InjectMocks
    private SongService songService;

    @Mock
    private AlbumService albumService;

    @Mock
    private SongRepository songRepository;


    @Test
    void testCreateSong(){
        //given
        CreateSongRequestDTO createSongRequestDTO = new CreateSongRequestDTO("name");

        //when
        songService.createSong(createSongRequestDTO);

        //then
        verify(songRepository).save(any(Song.class));
    }

    @Test
    void testUpdateSong(){
        //given
        UpdateSongRequestDTO updateSongRequestDTO = new UpdateSongRequestDTO(1L, "name");
        Song song = Song
                .builder()
                .name("name")
                .id(1L)
                .build();
        //when
        when(songRepository.findById(1L)).thenReturn(Optional.of(song));
        songService.updateSong(updateSongRequestDTO);

        //then
        verify(songRepository).save(any(Song.class));
    }

    @Test
    void testDeleteSong(){
        //given
        Song song = Song
                .builder()
                .name("name")
                .id(1L)
                .build();
        //when
        when(songRepository.findById(1L)).thenReturn(Optional.of(song));
        songService.deleteSong(1L);

        //then
        verify(songRepository).delete(any(Song.class));
    }

    @Test
    void testAddSong(){
        //given
        AddSongRequestDTO addSongRequestDTO = new AddSongRequestDTO(1L, 1L);
        Album album = Album
                .builder()
                .band("band")
                .publishYear(1926L)
                .name("name")
                .id(1L)
                .build();
        Song song = Song
                .builder()
                .name("name")
                .id(1L)
                .build();

        //when
        when(albumService.getAlbum(1L)).thenReturn(album);
        when(songRepository.findById(1L)).thenReturn(Optional.of(song));
        songService.addSongToAlbum(addSongRequestDTO);

        //then
        assertEquals(album.getId(), song.getAlbum().getId());
        verify(songRepository).save(song);

    }
}
