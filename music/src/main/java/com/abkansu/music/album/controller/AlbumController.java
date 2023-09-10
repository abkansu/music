package com.abkansu.music.album.controller;

import com.abkansu.music.album.controller.dto.CreateAlbumRequestDTO;
import com.abkansu.music.album.controller.dto.UpdateAlbumRequestDTO;
import com.abkansu.music.album.entity.Album;
import com.abkansu.music.album.service.AlbumService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/album")
@RequiredArgsConstructor
public class AlbumController {
    private final AlbumService albumService;


    @PostMapping
    public HttpStatus createAlbum(
            @RequestBody CreateAlbumRequestDTO createAlbumRequestDTO
    ){
        return albumService.createAlbum(createAlbumRequestDTO);
    }

    @GetMapping
    public List<Album> getAlbums(){
        return albumService.getAlbums();
    }

    @PutMapping
    public HttpStatus updateAlbum(
            @RequestBody UpdateAlbumRequestDTO updateAlbumRequestDTO
    ){
        return albumService.updateAlbum(updateAlbumRequestDTO);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteAlbum(@PathVariable(name = "id") Long id){
        return albumService.deleteAlbum(id);
    }


}
