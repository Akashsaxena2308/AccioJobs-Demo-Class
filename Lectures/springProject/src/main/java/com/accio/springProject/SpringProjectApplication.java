package com.accio.springProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class SpringProjectApplication {

//Annotations  --> @Annotations
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

	//Object Return
	//Song Preview
	// Title
	// Duration


	//Create a GET endpoint which returns a song with its name and duration
	//{name : song1, duration: 5.6}

//http:hostname:port/pathvariabes/pathvariables/pathvariables?filterName=filterValue&filterName2=filterValue2
	//    /songs?duration=5&nameStartWith=A
	//pathvariable ---> resource
	//1st index --> song --> resource
	//

	//HTTP request --> Format / Structure

	@GetMapping("/song/{index}")
	public List<Song> getSong(@PathVariable("index") int index){

		List<Song> songs = new ArrayList<>();
		songs.add(new Song("Song1", 5.0));

		songs.add(new Song("Song3", 5.5));
		return songs;
	}

	//OBJECT --> JSON
	// Primitive --> int, boolean, float

	//JSON
	// STRING
	// Number
	//Boolean
	//Array
	//Object
	//Null



	public static void main(String[] args) {

		SpringApplication.run(SpringProjectApplication.class, args);
	}

}
