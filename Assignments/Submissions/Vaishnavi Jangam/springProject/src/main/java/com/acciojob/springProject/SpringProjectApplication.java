package com.acciojob.springProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringProjectApplication {
	@GetMapping("/songs")
	public String getSong(@RequestParam(name = "title") String title){
		return "Song" + title;
	}

	@GetMapping("/playlist/{id}/songs/{songId}")
	public String getPlaylistbyId(@PathVariable("id") String id, @PathVariable("songId") String songId){
		return "Playlist ID: " + id + ", Song ID: " + songId;
	}

	@GetMapping()
	public static void main(String[] args) {
		SpringApplication.run(SpringProjectApplication.class, args);
	}


}
