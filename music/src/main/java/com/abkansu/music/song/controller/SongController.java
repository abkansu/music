package com.abkansu.music.song.controller;

import com.abkansu.music.song.controller.dto.AddSongRequestDTO;
import com.abkansu.music.song.controller.dto.CreateSongRequestDTO;
import com.abkansu.music.song.controller.dto.UpdateSongRequestDTO;
import com.abkansu.music.song.entity.Song;
import com.abkansu.music.song.service.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/song")
@RequiredArgsConstructor
public class SongController {
    private final SongService songService;

    @PostMapping
    public HttpStatus createSong(
            @RequestBody CreateSongRequestDTO createSongRequestDTO
            ){
        return songService.createSong(createSongRequestDTO);
    }

    @GetMapping
    public List<Song> getSongs(){
        return songService.getSongs();
    }


    @PutMapping
    public HttpStatus updateSong(
            @RequestBody UpdateSongRequestDTO updateSongRequestDTO
            ){
        return songService.updateSong(updateSongRequestDTO);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteSong(
            @PathVariable(name = "id") Long id
    ){
        return songService.deleteSong(id);
    }

    @PutMapping("/add-song")
    public HttpStatus addSongToAlbum(
            @RequestBody AddSongRequestDTO addSongRequestDTO
    ){
        return songService.addSongToAlbum(addSongRequestDTO);
    }

}
