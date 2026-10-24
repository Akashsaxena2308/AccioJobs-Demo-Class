package MovieList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/commonPath")
public class MovieController {
    private final List<Movie> movies = new ArrayList<>();
    long id;

    public MovieController() {
        movies.add(new Movie(1, "Interstellar", 2014));
        movies.add(new Movie(2, "3 idiots", 2009));
        movies.add(new Movie(3, "two State", 2014));

    }

    // 1 get movies
    @GetMapping("/Movie")
    public ResponseEntity<List<Movie>> getMovies() {
//        return movies;
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    // 2 get id
    @GetMapping("/Movie/{id}")
    public Movie getMovie(@PathVariable long id) {
        for (Movie m : movies) {
            if (m.getId() == id) {
                return m;
            }
        }
        return null;
    }

    // 3 add a movie
    @PostMapping("/addMovies")
    public List<Movie> addMovies(@RequestBody MovieInput input) {
        Movie movie = new Movie(id++, input.getTitle(), input.getReleaseDate());
        movies.add(movie);
        return movies;
    }

    // 4 update a movie
    @PutMapping("/Update/{id}")
    public List<Movie> updateMovie(@PathVariable long id, @RequestBody MovieInput input) {

        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).getId() == id) {
                Movie movie = new Movie(id, input.getTitle(), input.getReleaseDate());
                movies.set(i, movie);

            }
        }
        return movies;

    }

    //delete a movie by id
    @DeleteMapping("/deleteById/{id}")
    public List<Movie> deleteById(@PathVariable long id) {
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).getId() == id) {
                movies.remove(i);
            }
        }
        return movies;
    }


}
