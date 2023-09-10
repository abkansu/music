package com.abkansu.music.album.repository;

import com.abkansu.music.album.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long> {
}
