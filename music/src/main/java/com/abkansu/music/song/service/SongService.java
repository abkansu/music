package com.abkansu.music.song.service;

import com.abkansu.music.album.service.AlbumService;
import com.abkansu.music.song.controller.dto.AddSongRequestDTO;
import com.abkansu.music.song.controller.dto.CreateSongRequestDTO;
import com.abkansu.music.song.controller.dto.UpdateSongRequestDTO;
import com.abkansu.music.song.entity.Song;
import com.abkansu.music.song.repository.SongRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SongService {
    private final SongRepository songRepository;
    private final AlbumService albumService;

    public List<Song> getSongs() {
        return songRepository.findAll();
    }

    public HttpStatus createSong(CreateSongRequestDTO createSongRequestDTO) {
        Song song = Song
                .builder()
                .name(createSongRequestDTO.getName())
                .build();
        songRepository.save(song);
        return HttpStatus.CREATED;
    }

    public HttpStatus updateSong(UpdateSongRequestDTO updateSongRequestDTO) {
        var song = songRepository.findById(updateSongRequestDTO.getId()).orElseThrow();
        song.setName(updateSongRequestDTO.getName());
        songRepository.save(song);
        return HttpStatus.ACCEPTED;
    }

    public HttpStatus deleteSong(Long id) {
        var song = songRepository.findById(id).orElseThrow();
        songRepository.delete(song);
        return HttpStatus.OK;
    }

    public HttpStatus addSongToAlbum(AddSongRequestDTO addSongRequestDTO) {
        var song = songRepository.findById(addSongRequestDTO.getSongId()).orElseThrow();
        var album = albumService.getAlbum(addSongRequestDTO.getAlbumId());
        song.setAlbum(album);
        songRepository.save(song);
        return HttpStatus.ACCEPTED;
    }
}
