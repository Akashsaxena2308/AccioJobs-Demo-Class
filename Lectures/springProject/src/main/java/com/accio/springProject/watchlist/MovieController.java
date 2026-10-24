package com.accio.springProject.watchlist;

import java.net.URI;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {
    // WALKTHROUGH 2: map key = movie ID; values = stored Movie objects.
    // Start empty so GET initially returns []. Restarting clears the watchlist.
    private final Map<Long, Movie> movies = new LinkedHashMap<>();
    private long nextId = 1;

    @GetMapping
    public List<Movie> getAll() {
        return new ArrayList<>(movies.values());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOne(@PathVariable("id") long id) {
        Movie movie = movies.get(id);
        if (movie == null) {
            return notFound();
        }
        return ResponseEntity.ok(movie);
    }

    // WALKTHROUGH 3: validate FIRST, then allocate an ID and store the movie.
    @PostMapping
    public ResponseEntity<Object> create(@RequestBody MovieInput input) {
        String problem = validate(input);
        if (problem != null) {
            return ResponseEntity.badRequest().body(new MovieError(problem));
        }

        long id = nextId++;
        Movie movie = new Movie(id, input.getTitle().trim(), input.getReleaseYear());
        movies.put(id, movie);
        return ResponseEntity.created(URI.create("/movies/" + id)).body(movie);
    }

    // WALKTHROUGH 4: PUT replaces both details, preserves ID, and never inserts.
    @PutMapping("/{id}")
    public ResponseEntity<Object> replace(@PathVariable("id") long id,
                                           @RequestBody MovieInput input) {
        if (!movies.containsKey(id)) {
            return notFound();
        }
        String problem = validate(input);
        if (problem != null) {
            return ResponseEntity.badRequest().body(new MovieError(problem));
        }

        // No mutation occurs before all validation passes.
        Movie replacement = new Movie(id, input.getTitle().trim(), input.getReleaseYear());
        movies.put(id, replacement);
        return ResponseEntity.ok(replacement);
    }

    // WALKTHROUGH 5: deleting an early ID must not change nextId.
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") long id) {
        Movie removed = movies.remove(id);
        if (removed == null) {
            return notFound();
        }
        return ResponseEntity.noContent().build();
    }

    private ResponseEntity<Object> notFound() {
        return ResponseEntity.status(404).body(new MovieError("Movie not found"));
    }

    // Shared by POST and PUT. No new validation annotations/layers are needed.
    private String validate(MovieInput input) {
        if (input == null || input.getTitle() == null || input.getTitle().isBlank()) {
            return "Title is required";
        }
        if (input.getReleaseYear() == null) {
            return "Release year is required";
        }
        if (input.getReleaseYear() < 1888 || input.getReleaseYear() > 2100) {
            return "Release year must be between 1888 and 2100";
        }
        return null;
    }
}



//Packages

//Service

//Repository

//Controller

//Model

//Entity

//
//class B { //Dependency
//
//
//}
//class A {
//
//    A(B b){
//
//    }
//}
//
//
//new A()