package assignment.curd.movies.Controller;

import assignment.curd.movies.DTO.MoviesDto;
import assignment.curd.movies.Model.Movies;
import assignment.curd.movies.Service.MoviesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MoviesController {
    private final MoviesService moviesService;

    @PostMapping
    public ResponseEntity<Movies> addUser(@RequestBody MoviesDto moviesDto){
        return new ResponseEntity<>(moviesService.addUser(moviesDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Movies>> getAllMovies(){
        return new ResponseEntity<>(moviesService.getAllMovies(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movies> getMovieById(@PathVariable UUID id){
        return new ResponseEntity<>(moviesService.getMovieById(id), HttpStatus.FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movies> updateMovies(@PathVariable UUID id, @RequestBody MoviesDto moviesDto){
        return new ResponseEntity<>(moviesService.updateMovie(id, moviesDto), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Movies> deletetMoviesById(@PathVariable UUID id){
        return new ResponseEntity<>(moviesService.deleteMovieById(id), HttpStatus.ACCEPTED);
    }
}
