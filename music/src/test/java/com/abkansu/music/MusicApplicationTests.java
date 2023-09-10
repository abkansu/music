package com.abkansu.music;

import com.abkansu.music.album.controller.AlbumController;
import com.abkansu.music.album.service.AlbumService;
import com.abkansu.music.index.controller.IndexController;
import com.abkansu.music.song.controller.SongController;
import com.abkansu.music.song.service.SongService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class MusicApplicationTests {

	@Autowired
	private IndexController indexController;

	@Autowired
	private SongService songService;

	@Autowired
	private SongController songController;

	@Autowired
	private AlbumService albumService;

	@Autowired
	private AlbumController albumController;


	@Test
	void contextLoads() {
		assertNotNull(indexController);
		assertNotNull(songService);
		assertNotNull(songController);
		assertNotNull(albumService);
		assertNotNull(albumController);
	}

}
