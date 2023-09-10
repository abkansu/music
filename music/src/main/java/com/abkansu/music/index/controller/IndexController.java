package com.abkansu.music.index.controller;

import com.abkansu.music.album.entity.Album;
import com.abkansu.music.album.service.AlbumService;
import com.abkansu.music.song.entity.Song;
import com.abkansu.music.song.service.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller("/")
@RequiredArgsConstructor
public class IndexController {

    private final SongService songService;
    private final AlbumService albumService;

    @GetMapping
    public String index(Model model){
        List<Album> albums = albumService.getAlbums();
        List<Song> songs = songService.getSongs();
        model.addAttribute("albums", albums);
        model.addAttribute("songs", songs);
        return "index";
    }
}
