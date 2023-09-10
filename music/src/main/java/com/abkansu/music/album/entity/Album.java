package com.abkansu.music.album.entity;

import com.abkansu.music.song.entity.Song;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    private Long publishYear;

    private String band;

    @OneToMany(mappedBy = "album")
    private Set<Song> songs;

}

