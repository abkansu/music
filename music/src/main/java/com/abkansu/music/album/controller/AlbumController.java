package com.abkansu.music.album.controller;

import com.abkansu.music.album.controller.dto.AlbumResponseDTO;
import com.abkansu.music.album.controller.dto.CreateAlbumRequestDTO;
import com.abkansu.music.album.controller.dto.UpdateAlbumRequestDTO;
import com.abkansu.music.album.entity.Album;
import com.abkansu.music.album.service.AlbumService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.abkansu.music.validations.Validations.validateCreateAlbumRequestDTO;
import static com.abkansu.music.validations.Validations.validateUpdateAlbumRequestDTO;

@RestController
@RequestMapping("/api/v1/album")
@RequiredArgsConstructor
public class AlbumController {
    private final AlbumService albumService;


    @PostMapping
    public AlbumResponseDTO createAlbum(
            @RequestBody CreateAlbumRequestDTO createAlbumRequestDTO
    ){
        if (!validateCreateAlbumRequestDTO(createAlbumRequestDTO)) throw new IllegalArgumentException();
        return albumService.createAlbum(createAlbumRequestDTO);
    }

    @GetMapping
    public List<Album> getAlbums(){
        return albumService.getAlbums();
    }

    @PutMapping
    public AlbumResponseDTO updateAlbum(
            @RequestBody UpdateAlbumRequestDTO updateAlbumRequestDTO
    ){
        if (!validateUpdateAlbumRequestDTO(updateAlbumRequestDTO)) throw new IllegalArgumentException();
        return albumService.updateAlbum(updateAlbumRequestDTO);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteAlbum(@PathVariable(name = "id") Long id){
        return albumService.deleteAlbum(id);
    }


}
