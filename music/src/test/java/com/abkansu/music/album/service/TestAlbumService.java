package com.abkansu.music.album.service;

import com.abkansu.music.album.controller.dto.CreateAlbumRequestDTO;
import com.abkansu.music.album.controller.dto.UpdateAlbumRequestDTO;
import com.abkansu.music.album.entity.Album;
import com.abkansu.music.album.repository.AlbumRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TestAlbumService {
    @InjectMocks
    private AlbumService albumService;

    @Mock
    private AlbumRepository albumRepository;

    @Test
    void testCreateAlbum(){
        //given
        CreateAlbumRequestDTO createAlbumRequestDTO = new CreateAlbumRequestDTO("name", 1926L, "band");
        //when
        albumService.createAlbum(createAlbumRequestDTO);
        //then
        verify(albumRepository).save(any(Album.class));
    }

    @Test
    void testUpdateAlbum(){
        //given
        UpdateAlbumRequestDTO updateAlbumRequestDTO = new UpdateAlbumRequestDTO(1L, "name", 1926L, "band");
        Album album = Album
                .builder()
                .band("band")
                .publishYear(1926L)
                .name("name")
                .id(1L)
                .build();
        //when
        when(albumRepository.findById(1L)).thenReturn(Optional.of(album));
        albumService.updateAlbum(updateAlbumRequestDTO);
        //then
        verify(albumRepository).save(any(Album.class));
    }

    @Test
    void testDeleteAlbum(){
        //given
        Album album = Album
                .builder()
                .band("band")
                .publishYear(1926L)
                .name("name")
                .id(1L)
                .build();
        //when
        when(albumRepository.findById(1L)).thenReturn(Optional.of(album));
        albumService.deleteAlbum(1L);

        //then
        verify(albumRepository).delete(any(Album.class));
    }

}
