package com.abkansu.music.index.service;

import com.abkansu.music.album.service.AlbumService;
import com.abkansu.music.song.service.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IndexService {
    private final AlbumService albumService;
    private final SongService songService;
}
