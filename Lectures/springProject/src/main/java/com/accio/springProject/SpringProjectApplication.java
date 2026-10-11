package com.accio.springProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class SpringProjectApplication {


	@GetMapping("/songs")
	public String getSongs(@RequestParam(name = "title") String title){
		return "Song" + title;
	}

//	/songs?title=sunrise
	//playlist/{id}/songs
	//playlist/1/songs
	//playlist/2/songs


	//playlist/{id}/song/{songId}
	//


	//localhost:8081/playlist
	@GetMapping("/playlist/{id}/songs/{songId}")
	public String getPlayistbyId(@PathVariable("id") String id, @PathVariable("songId") String songId){
		return "Song" + id;
	}






	public static void main(String[] args) {

		SpringApplication.run(SpringProjectApplication.class, args);
	}

}
