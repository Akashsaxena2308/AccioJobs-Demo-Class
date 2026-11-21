package com.accio.springProject.JpaMovies;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jpa/movies")
public class MoviesController {

    private final MovieService service;

    public MoviesController(MovieService service){
        this.service = service;
    }

    @GetMapping
    public List<Movie> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Movie findById(@PathVariable("id") Long id){
        return service.findById(id);
    }

    @PostMapping
    public Movie create(@Valid @RequestBody MovieInput input){
        return service.create(input);
    }

    @PutMapping("/{id}")
    public Movie update(@PathVariable("id") Long id, @Valid @RequestBody MovieInput input){
        return service.update(id, input);
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable("id") Long id){
        service.delete(id);
    }

    @GetMapping("/suitable")
    public List<Movie> suitable(@RequestParam("rating") double rating,
                                @RequestParam("time") int time){
        return service.suitable(rating, time);
    }
}

// CRUD

// READ

// CREATE

// UPDATE

// DELETE
