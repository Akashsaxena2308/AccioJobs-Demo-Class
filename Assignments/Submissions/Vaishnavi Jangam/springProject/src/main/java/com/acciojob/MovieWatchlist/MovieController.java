package MovieWatchlist;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/commonPath")

public class MovieController {
    private final List<Movie> movies = new ArrayList<>();
    private long id;

    public MovieController() {
        movies.add(new Movie(1, "Interstellar", 2014));
        movies.add(new Movie(2, "3 Idiots", 2009));
        id = 2;
    }

    @GetMapping("/Movie")
    public ResponseEntity<List<Movie>> getMovies(){
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping("/Movie/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable long id){
        for(Movie m : movies){
            if(m.getId() == id){
                return new ResponseEntity<>(m, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/addMovies")
    public ResponseEntity<List<Movie>> addMovies(@RequestBody MovieInput movieInput){
        Movie movie = new Movie(id+1, movieInput.getTitle(), movieInput.getReleaseYear());

        movies.add(movie);
        id++;
        return new ResponseEntity<>(movies, HttpStatus.CREATED);
    }

    @PutMapping("/updateMovies/{id}")
    public ResponseEntity<List<Movie>> updateMovies(@PathVariable long id, @RequestBody MovieInput movieInput){
        for(int i=0; i<movies.size(); i++){
            if(movies.get(i).getId() == id){
                Movie movie = new Movie(id,movieInput.getTitle(), movieInput.getReleaseYear());
                movies.set(i, movie);
                return new ResponseEntity<>(movies, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<List<Movie>> deleteMoviesById(@PathVariable long id){
        for(int i=0; i<movies.size(); i++){
            if(movies.get(i).getId() == id){
                movies.remove(i);
                return new ResponseEntity<>(movies, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
