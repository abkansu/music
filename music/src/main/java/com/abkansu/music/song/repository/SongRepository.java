package com.abkansu.music.song.repository;

import com.abkansu.music.song.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> {
}
