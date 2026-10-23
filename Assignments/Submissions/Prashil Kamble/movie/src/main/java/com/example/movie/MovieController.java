package com.example.movie;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MovieController {

    private List<Movie> movies = new ArrayList<>();
    int id;

    public MovieController(){
        movies.add(new Movie(1, "Intersteller", 2014, 2.49));
        movies.add(new Movie(2, "Inception", 2018, 3.15));
        id = 3;
    }

    // get all movies
    @GetMapping("/allMovies")
    public List<Movie> getMovies(){
        return movies;
    }

    // get movie details by id
    @GetMapping("/getMovie/{id}")
    public ResponseEntity<Object> getMovie(@PathVariable int id){
        for (Movie m : movies){
            if(m.getId() == id) return ResponseEntity.ok(m);
        }
        return ResponseEntity.status(404).body("Movie not found");
    }

    // add movie
    @PostMapping("/addMovie")
    public ResponseEntity<Object> addMovie(@RequestBody MovieInput m){

        if(m.getName() == null || m.getReleaseYear() < 1888 || m.getReleaseYear() > 2100 || m.getDuration() < 0){
            return ResponseEntity.status(400).body("Please Enter valid name or duration or release year");
        }
        movies.add(new Movie(id++, m.getName(), m.getReleaseYear(), m.getDuration()));
        return ResponseEntity.ok(movies);
    }

    // update in the movie
    @PutMapping("/updateMovie/{id}")
    public ResponseEntity<Object> updatePatient(@PathVariable int id, @RequestBody MovieInput mIp){

        if(mIp.getName() == null || mIp.getReleaseYear() < 1888 || mIp.getReleaseYear() > 2100 || mIp.getDuration() < 0){
            return ResponseEntity.status(400).body("Please Enter valid name or duration or release year");
        }

        for (Movie m : movies){
            if(m.getId() == id){
                m.setName(mIp.getName());
                m.setDuration(mIp.getDuration());
                m.setReleaseYear(mIp.getReleaseYear());
            }
        }

        return ResponseEntity.ok(movies);
    }

    // delete movie
    @DeleteMapping("/deleteMovie/{id}")
    public ResponseEntity<Object> deleteMovie(@PathVariable int id){

        boolean deleted = false;

        for (Movie m : movies){
            if(m.getId() == id){
                movies.remove(m);
                deleted = true;
            }
        }

        if(!deleted) return ResponseEntity.status(404).body("Movie not found");

        return ResponseEntity.ok(movies);
    }

}
