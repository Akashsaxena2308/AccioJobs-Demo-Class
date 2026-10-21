package com.acciojob.moviewatchlist;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Movie_Controller {

   final private List<Movie> movieList = new ArrayList<>();
   private int id = 1;

   // add movies
   @PostMapping("/addMovies")
   public String addMovie(@RequestBody Movie newMovie){
       movieList.add(new Movie(id, newMovie.getTitle(), newMovie.getReleaseYear()));
       id++;
       return "Movie added successfully";
   }

   // get movies
   @GetMapping("/movies")
   public ResponseEntity<List<Movie>> getMovies(){
       return  ResponseEntity.ok(movieList);
   }

   // get movies by id
    @GetMapping("/movies/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Integer id){

       for(Movie movie : movieList){
           if(movie.getId().equals(id)){
               return ResponseEntity.ok(movie);
           }
       }
       return ResponseEntity.notFound().build();

    }

    // update movies by id
    @PutMapping("updateMovie/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Integer id, @RequestBody Movie updateMovie){

       if(updateMovie.getTitle() == null
               || updateMovie.getTitle().isBlank()
               || updateMovie.getReleaseYear() == null
               || updateMovie.getReleaseYear() < 1888
               || updateMovie.getReleaseYear() > 2100
       ){
           return ResponseEntity.badRequest().build();
       }

       for(Movie movie: movieList){
           if(movie.getId().equals(id)){
               movie.setTitle(updateMovie.getTitle());
               movie.setReleaseYear(updateMovie.getReleaseYear());

               return ResponseEntity.ok(movie);
           }
       }
       return ResponseEntity.notFound().build();

    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id){

       Boolean removed = movieList.removeIf(movie -> movie.getId().equals(id));
       if(removed)
           return ResponseEntity.ok().build();
       else
           return ResponseEntity.notFound().build();

    }
}
