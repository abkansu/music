package com.abkansu.music.song.controller;

import com.abkansu.music.song.controller.dto.AddSongRequestDTO;
import com.abkansu.music.song.controller.dto.CreateSongRequestDTO;
import com.abkansu.music.song.controller.dto.SongResponseDTO;
import com.abkansu.music.song.controller.dto.UpdateSongRequestDTO;
import com.abkansu.music.song.entity.Song;
import com.abkansu.music.song.service.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.abkansu.music.validations.Validations.*;

@RestController
@RequestMapping("/api/v1/song")
@RequiredArgsConstructor
public class SongController {
    private final SongService songService;

    @PostMapping
    public SongResponseDTO createSong(
            @RequestBody CreateSongRequestDTO createSongRequestDTO
            ){
        if(!validateCreateSongRequestDTO(createSongRequestDTO)) throw new IllegalArgumentException();
        return songService.createSong(createSongRequestDTO);
    }

    @GetMapping
    public List<Song> getSongs(){
        return songService.getSongs();
    }


    @PutMapping
    public SongResponseDTO updateSong(
            @RequestBody UpdateSongRequestDTO updateSongRequestDTO
            ){
        if(!validateUpdateSongRequestDTO(updateSongRequestDTO)) throw new IllegalArgumentException();
        return songService.updateSong(updateSongRequestDTO);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteSong(
            @PathVariable(name = "id") Long id
    ){
        return songService.deleteSong(id);
    }

    @PutMapping("/add-song")
    public SongResponseDTO addSongToAlbum(
            @RequestBody AddSongRequestDTO addSongRequestDTO
    ){
        if(!validateAddSongRequestDTO(addSongRequestDTO)) throw new IllegalArgumentException();
        return songService.addSongToAlbum(addSongRequestDTO);
    }

}
