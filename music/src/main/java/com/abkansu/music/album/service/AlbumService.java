package com.abkansu.music.album.service;

import com.abkansu.music.album.controller.dto.AlbumResponseDTO;
import com.abkansu.music.album.controller.dto.CreateAlbumRequestDTO;
import com.abkansu.music.album.controller.dto.UpdateAlbumRequestDTO;
import com.abkansu.music.album.entity.Album;
import com.abkansu.music.album.repository.AlbumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlbumService {
    private final AlbumRepository albumRepository;

    public AlbumResponseDTO createAlbum(CreateAlbumRequestDTO createAlbumRequestDTO) {
        albumRepository.save(
                fromCreateAlbumRequestDTO(createAlbumRequestDTO)
        );
        return AlbumResponseDTO
                .builder()
                .status(HttpStatus.CREATED)
                .message("Successfully Created")
                .statusCode(201)
                .build();
    }

    public List<Album> getAlbums() {
        return albumRepository.findAll();
    }


    public HttpStatus deleteAlbum(Long id) {
        var album = albumRepository.findById(id).orElseThrow();
        albumRepository.delete(album);
        return HttpStatus.OK;

    }

    public AlbumResponseDTO updateAlbum(UpdateAlbumRequestDTO updateAlbumRequestDTO) {
        Album album = albumRepository.findById(updateAlbumRequestDTO.getId()).orElseThrow();
        albumRepository.save(
                fromUpdateAlbumRequestDTO(album, updateAlbumRequestDTO)
        );
        return AlbumResponseDTO
                .builder()
                .status(HttpStatus.OK)
                .message("Successfully Updated")
                .statusCode(200)
                .build();
    }

    public Album getAlbum(Long id){
        return albumRepository.findById(id).orElseThrow();
    }


    private Album fromCreateAlbumRequestDTO(CreateAlbumRequestDTO createAlbumRequestDTO){
        return Album
                .builder()
                .band(createAlbumRequestDTO.getBand())
                .name(createAlbumRequestDTO.getName())
                .publishYear(createAlbumRequestDTO.getPublishYear())
                .build();
    }

    private Album fromUpdateAlbumRequestDTO(Album album, UpdateAlbumRequestDTO updateAlbumRequestDTO){
        album.setBand(updateAlbumRequestDTO.getBand());
        album.setName(updateAlbumRequestDTO.getName());
        album.setPublishYear(updateAlbumRequestDTO.getPublishYear());
        return album;
    }
}
