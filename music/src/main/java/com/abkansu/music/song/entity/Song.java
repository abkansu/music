package com.abkansu.music.song.entity;

import com.abkansu.music.album.entity.Album;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "album_id", referencedColumnName = "id")
    private Album album;
}
